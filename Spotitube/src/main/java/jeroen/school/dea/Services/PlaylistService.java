package jeroen.school.dea.Services;

import jeroen.school.dea.DataSource.IPlaylistDAO;
import jeroen.school.dea.DataSource.IUserDAO;
import jeroen.school.dea.Domain.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTO;
import jeroen.school.dea.Domain.PlaylistsDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/")
public class PlaylistService {
    private PlaylistsDTO playlists;
    private int userId;

    @Inject
    private IUserDAO user;

    @Inject
    private IPlaylistDAO playlist;

    /**
     * Creates a new playlist by userId
     * @param token
     * @param newPlaylist
     * @return List of current playlists based on userId
     */
    @POST
    @Path("/playlists")
    public Response createPlaylist(@QueryParam("token") String token, CreatePlaylistDTO newPlaylist) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.validate(token);

            if (playlist.createNewPlaylist(newPlaylist, userId)) {

                playlists = playlist.getAllPlayListsByToken(userId);

            }
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();
        }

        return Response.status(200).entity(playlists).build();
    }

    /**
     * Gets all playlists
     * @param token
     * @return List of current playlists based on userId
     */
    @GET
    @Path("/playlists")
    public Response getAllPlayLists(@QueryParam("token") String token) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.validate(token);

            playlists = playlist.getAllPlayListsByToken(userId);

        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();
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
    public Response editPlaylist(@QueryParam("token") String token, PlaylistDTO playlistDTO) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.validate(token);

            if (playlist.updatePlaylist(playlistDTO)) {

                playlists = playlist.getAllPlayListsByToken(userId);

            }
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();
        }

        return Response.status(200).entity(playlists).build();
    }

    /**
     * Deletes a playlist
     * @param playlistId
     * @param token
     * @return List of current playlists based on userId
     */
    @DELETE
    @Path("/playlists/{id}")
    public Response deletePlayListById(@PathParam("id") int playlistId, @QueryParam("token") String token) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.validate(token);

            if (playlist.deletePlaylistById(playlistId)) {

                playlists = playlist.getAllPlayListsByToken(userId);

            }
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();

        }

        return Response.status(200).entity(playlists).build();
    }
}
