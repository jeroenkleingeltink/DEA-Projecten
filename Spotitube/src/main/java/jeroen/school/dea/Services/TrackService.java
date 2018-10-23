package jeroen.school.dea.Services;

import jdk.management.resource.internal.inst.UnixAsynchronousServerSocketChannelImplRMHooks;
import jeroen.school.dea.DataSource.Exceptions.UserNotFoundException;
import jeroen.school.dea.DataSource.ITrackDAO;
import jeroen.school.dea.DataSource.IUserDAO;
import jeroen.school.dea.Domain.TrackDTO;
import jeroen.school.dea.Domain.TracksDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
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
    public Response getAllTracksNotInPlaylist(@QueryParam("forPlaylist") int playlistId, @QueryParam("token") String token) {
        tracks = new TracksDTO();

        try {
            userId = user.getUserIdByToken(token);

            if (user.isPlaylistOwner(playlistId, userId)) {
                tracks = track.getAllTracksNotInPlaylist(playlistId);
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();
        }

        return Response.status(200).entity(tracks).build();
    }

    @GET
    @Path("/playlists/{id}/tracks")
    public Response getAllPlaylistTracks(@QueryParam("token") String token, @PathParam("id") int playlistId) {
        tracks = new TracksDTO();

        try {
            int userId = user.getUserIdByToken(token);

            if (user.isPlaylistOwner(playlistId, userId)) {

                tracks = track.getAllTracksByPlaylistId(playlistId);

            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(200).build();
        }

        return Response.status(200).entity(tracks).build();
    }

    @DELETE
    @Path("/playlists/{playlistId}/tracks/{trackId}")
    public Response deleteTrackFromPlaylist(@PathParam("playlistId") int playlistId,
                                            @PathParam("trackId") int trackId,
                                            @QueryParam("token") String token) {
        tracks = new TracksDTO();

        try {
            int userId = user.getUserIdByToken(token);

            if (track.deleteTrackFromPlaylist(playlistId, trackId)) {
                tracks = track.getAllTracksByPlaylistId(playlistId);
            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();
        }

        return Response.status(200).entity(tracks).build();
    }

    @POST
    @Path("/playlists/{id}/tracks")
    public Response addTrackToPlaylist(@PathParam("id") int playlistId, @QueryParam("token") String token, TrackDTO pTrack) {
        tracks = new TracksDTO();

        System.out.println("playlistId" + playlistId + " Track ID: " + pTrack.getId());

        try {
            int userId = user.getUserIdByToken(token);

            if (user.isPlaylistOwner(playlistId, userId) && track.addTrackToPlaylist(playlistId, pTrack.getId())) {

                tracks = track.getAllTracksByPlaylistId(playlistId);

            }

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();
        }

        return Response.status(200).entity(tracks).build();
    }
}