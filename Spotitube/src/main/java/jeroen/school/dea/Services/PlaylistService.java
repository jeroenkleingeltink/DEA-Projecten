package jeroen.school.dea.Services;

import jeroen.school.dea.DataSource.IPlaylistDAO;
import jeroen.school.dea.DataSource.IUserDAO;
import jeroen.school.dea.Domain.PlaylistDTO;
import jeroen.school.dea.Domain.TempPlaylistDTO;
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

    @GET
    @Path("/playlists")
    public Response getAllPlayLists(@QueryParam("token") String token) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.getUserIdByToken(token);

            playlists = playlist.getAllPlayListsByToken(userId);

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
            userId = user.getUserIdByToken(token);

            if (playlist.deletePlaylistById(playlistId)) {

                playlists = playlist.getAllPlayListsByToken(userId);

            }
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();

        }

        return Response.status(200).entity(playlists).build();
    }

    /**
     * Creates a new playlist by userId
     * @param token
     * @param newPlaylist
     * @return List of current playlists based on userId
     */
    @POST
    @Path("/playlists")
    public Response createPlaylist(@QueryParam("token") String token, TempPlaylistDTO newPlaylist) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.getUserIdByToken(token);

            if (playlist.createNewPlaylist(newPlaylist, userId)) {

                playlists = playlist.getAllPlayListsByToken(userId);

            }
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();
        }

        return Response.status(200).entity(playlists).build();
    }

    @PUT
    @Path("playlists/{id}")
    public Response editPlaylist(@QueryParam("token") String token, TempPlaylistDTO tempPlaylistDTO) {
        playlists = new PlaylistsDTO();

        try {
            userId = user.getUserIdByToken(token);

            if (playlist.updatePlaylist(tempPlaylistDTO)) {

                playlists = playlist.getAllPlayListsByToken(userId);

            }
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(500).build();
        }

        return Response.status(200).entity(playlists).build();
    }
}
