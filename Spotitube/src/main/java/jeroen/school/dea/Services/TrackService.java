package jeroen.school.dea.Services;

import jeroen.school.dea.DataSource.DAO.ITrackDAO;
import jeroen.school.dea.DataSource.DAO.IUserDAO;
import jeroen.school.dea.Domain.TrackDTOS.AddTrackDTO;
import jeroen.school.dea.Domain.TrackDTOS.TracksDTO;
import jeroen.school.dea.Exceptions.TrackException;
import jeroen.school.dea.Exceptions.UnauthorizedException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/")
public class TrackService {
    private TracksDTO tracks;
    private int userId;

    @Inject
    private IUserDAO user;

    @Inject
    private ITrackDAO track;

    @GET
    @Path("/tracks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllTracksNotInPlaylist(@QueryParam("forPlaylist") int playlistId, @QueryParam("token") String token) {
        tracks = new TracksDTO();

        try {
            userId = user.validate(token);

            if (user.isPlaylistOwner(playlistId, userId)) {
                tracks = track.getAllTracksNotInPlaylist(playlistId);
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UnauthorizedException u) {
            u.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok().entity(tracks).build();
    }

    @GET
    @Path("/playlists/{id}/tracks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlaylistTracks(@QueryParam("token") String token, @PathParam("id") int playlistId) {
        tracks = new TracksDTO();

        try {
            userId = user.validate(token);

            if (user.isPlaylistOwner(playlistId, userId)) {

                tracks = track.getAllTracksByPlaylistId(playlistId);

            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.ok().status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UnauthorizedException e) {
            e.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok().entity(tracks).build();
    }

    @DELETE
    @Path("/playlists/{playlistId}/tracks/{trackId}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteTrackFromPlaylist(@PathParam("playlistId") int playlistId,
                                            @PathParam("trackId") int trackId,
                                            @QueryParam("token") String token) {
        tracks = new TracksDTO();

        try {
            userId = user.validate(token);

            if (track.deleteTrackFromPlaylist(playlistId, trackId)) {
                tracks = track.getAllTracksByPlaylistId(playlistId);
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UnauthorizedException e) {
            e.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (TrackException e) {
            e.printStackTrace();

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().entity(tracks).build();
    }

    @POST
    @Path("/playlists/{id}/tracks")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addTrackToPlaylist(@PathParam("id") int playlistId, @QueryParam("token") String token, AddTrackDTO pTrack) {
        tracks = new TracksDTO();

        try {
            int userId = user.validate(token);

            if (user.isPlaylistOwner(playlistId, userId) && track.addTrackToPlaylist(playlistId, pTrack.getId())) {

                tracks = track.getAllTracksByPlaylistId(playlistId);

            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UnauthorizedException e) {
            e.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (TrackException e) {
            e.printStackTrace();

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().entity(tracks).build();
    }
}
