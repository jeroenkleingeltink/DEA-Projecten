package jeroen.school.dea.DataSource;

import jeroen.school.dea.DataSource.Utilities.IDBConnection;
import jeroen.school.dea.Domain.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTO;
import jeroen.school.dea.Domain.PlaylistsDTO;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PlaylistDAO implements IPlaylistDAO {
    private Connection connection;

    @Inject
    private IDBConnection dbCon;

    @Override
    public PlaylistsDTO getAllPlayListsByToken(int userId) throws SQLException {
        PlaylistsDTO playlists = new PlaylistsDTO();
        connection = dbCon.getConnection();

        String query = "SELECT pl.playlistid, pl.name, pl.owner,\n" +
                "(SELECT SUM(t.duration) FROM playlisttrack p INNER JOIN track t on p.trackid = t.trackid WHERE p.playlistid = pl.playlistid) AS length\n" +
                "FROM playlist pl WHERE owner = ?";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, userId);

        ResultSet rs = prep.executeQuery();

        if (!rs.next()) {
            throw new SQLException("No playlists found.");
        } else {
            rs.beforeFirst();

            while (rs.next()) {
                playlists.getPlaylists().add(
                    new PlaylistDTO(
                        rs.getInt("playlistid"),
                        rs.getString("name"),
                        rs.getInt("owner")
                    )
                );

                playlists.increasePlaylistLength(rs.getInt("length"));

            }
        }

        return playlists;
    }

    @Override
    public boolean deletePlaylistById(int playlistId) throws SQLException {
        connection = dbCon.getConnection();

        String query = "DELETE FROM playlist where playlistid = ?";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, playlistId);

        int rs = prep.executeUpdate();

        if (rs == 0) {
            throw new SQLException("No rows were Deleted.");
        }

        return true;
    }

    @Override
    public boolean createNewPlaylist(CreatePlaylistDTO newPlaylist, int userId) throws SQLException {
        connection = dbCon.getConnection();

        String query = "INSERT INTO playlist (name, owner) VALUES (?, ?)";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setString(1, newPlaylist.getName());
        prep.setInt(2, userId);

        int rs = prep.executeUpdate();

        if (rs == 0) {
            throw new SQLException("Playlist was not added.");
        }

        return true;
    }

    @Override
    public boolean updatePlaylist(PlaylistDTO changedPlaylist) throws SQLException {
        connection = dbCon.getConnection();

        String query = "UPDATE playlist SET name = ? WHERE playlistid = ?";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setString(1, changedPlaylist.getName());
        prep.setInt(2, changedPlaylist.getId());

        int rs = prep.executeUpdate();

        if (rs == 0) {
            throw new SQLException("Playlist was not updated.");
        }

        return true;
    }
}
