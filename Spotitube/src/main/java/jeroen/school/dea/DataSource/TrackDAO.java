package jeroen.school.dea.DataSource;

import jeroen.school.dea.DataSource.Utilities.IDBConnection;
import jeroen.school.dea.Domain.TrackDTO;
import jeroen.school.dea.Domain.TracksDTO;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TrackDAO implements ITrackDAO{
    private Connection connection;
    private TracksDTO tracks;

    @Inject
    private IDBConnection dbCon;

    @Override
    public TracksDTO getAllTracksNotInPlaylist(int playlistId) throws SQLException {
        tracks = new TracksDTO();
        connection = dbCon.getConnection();

        String query = "SELECT * FROM track t INNER JOIN playlisttrack p on t.trackid = p.trackid WHERE p.playlistid != ?";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, playlistId);

        ResultSet rs = prep.executeQuery();

        createTracklist(rs);

        return tracks;
    }

    @Override
    public TracksDTO getAllTracksByPlaylistId(int playlistId) throws SQLException {
        tracks = new TracksDTO();
        connection = dbCon.getConnection();

        String query = "SELECT * FROM track  INNER JOIN playlisttrack p on track.trackid = p.trackid WHERE p.playlistid = ?";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, playlistId);

        ResultSet rs = prep.executeQuery();

        createTracklist(rs);

        return tracks;
    }

    @Override
    public boolean deleteTrackFromPlaylist(int playlistId, int trackId) throws SQLException {
        connection = dbCon.getConnection();

        String query = "DELETE FROM playlisttrack WHERE playlistid = ? AND trackid = ?";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, playlistId);
        prep.setInt(2, trackId);

        int rs = prep.executeUpdate();

        if (rs == 0) {
            // Create track exception
            throw new SQLException("No tracks found.");
        }

        return true;
    }


    /**
     * creates tracklist from result set
     * @param rs
     * @throws SQLException
     */
    private void createTracklist(ResultSet rs) throws SQLException {
        if (!rs.next()) {
            throw new SQLException("No tracks found.");
        } else {
            rs.beforeFirst();

            while (rs.next()) {
                tracks.getTracks().add(
                        new TrackDTO(
                                rs.getInt("trackid"),
                                rs.getString("title"),
                                rs.getString("performer"),
                                rs.getInt("duration"),
                                rs.getString("album"),
                                rs.getInt("playcount"),
                                rs.getString("publicationdate"),
                                rs.getString("description"),
                                rs.getBoolean("offlineavailable")
                        )
                );
            }
        }
    }
}
