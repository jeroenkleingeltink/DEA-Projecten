package jeroen.school.dea.Services;

import jeroen.school.dea.DataSource.DAO.IUserDAO;
import jeroen.school.dea.DataSource.Utilities.IPlaylistMapper;
import jeroen.school.dea.Domain.PlaylistDTOS.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistsDTO;
import jeroen.school.dea.Exceptions.PlaylistException;
import jeroen.school.dea.Exceptions.UnauthorizedException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/")
public class PlaylistService {
    private PlaylistsDTO playlists;
    private int userId;

    @Inject
    private IUserDAO user;

    @Inject
    private IPlaylistMapper playlist;

    /**
     * Creates a new playlist by userId
     * @param token
     * @param newPlaylist
     * @return List of current playlists based on userId
     */
    @POST
    @Path("/playlists")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createPlaylist(@QueryParam("token") String token, CreatePlaylistDTO newPlaylist) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.validate(token);

            if (playlist.createNewPlaylist(newPlaylist, userId)) {

                playlists = playlist.getAllPlayListsByToken(userId);

            }
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UnauthorizedException e) {
            e.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (PlaylistException e) {
            e.printStackTrace();

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().entity(playlists).build();
    }

    /**
     * Gets all playlists
     * @param token
     * @return List of current playlists based on userId
     */
    @GET
    @Path("/playlists")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlayLists(@QueryParam("token") String token) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.validate(token);

            playlists = playlist.getAllPlayListsByToken(userId);

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UnauthorizedException e) {
            e.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (PlaylistException e) {
            e.printStackTrace();

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().entity(playlists).build();
    }

    /**
     * Edit playlist name
     * @param token
     * @param playlistDTO
     * @return List of current playlists based on userId
     */
    @PUT
    @Path("playlists/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response editPlaylist(@QueryParam("token") String token, PlaylistDTO playlistDTO) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.validate(token);

            if (playlist.updatePlaylist(playlistDTO)) {

                playlists = playlist.getAllPlayListsByToken(userId);

            }
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UnauthorizedException e) {
            e.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (PlaylistException e) {
            e.printStackTrace();

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().entity(playlists).build();
    }

    /**
     * Deletes a playlist
     * @param playlistId
     * @param token
     * @return List of current playlists based on userId
     */
    @DELETE
    @Path("/playlists/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePlayListById(@PathParam("id") int playlistId, @QueryParam("token") String token) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.validate(token);

            if (!playlist.deletePlaylistById(playlistId)) {

                throw new PlaylistException();

            }

            playlists = playlist.getAllPlayListsByToken(userId);

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UnauthorizedException e) {
            e.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        } catch (PlaylistException e) {
            e.printStackTrace();

            return Response.status(Response.Status.BAD_REQUEST).build();
        }

        return Response.ok().entity(playlists).build();
    }
}
