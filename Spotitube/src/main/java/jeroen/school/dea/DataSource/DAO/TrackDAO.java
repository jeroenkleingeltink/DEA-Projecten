package jeroen.school.dea.DataSource.DAO;

import jeroen.school.dea.DataSource.Utilities.IDBConnection;
import jeroen.school.dea.Domain.TrackDTOS.TrackDTO;
import jeroen.school.dea.Domain.TrackDTOS.TracksDTO;
import jeroen.school.dea.Exceptions.TrackException;

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

        String query = "SELECT * FROM track t WHERE NOT EXISTS (SELECT null FROM playlisttrack pt WHERE playlistid = ? AND pt.trackid = t.trackid)";
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
    public boolean deleteTrackFromPlaylist(int playlistId, int trackId) throws SQLException, TrackException {
        connection = dbCon.getConnection();

        String query = "DELETE FROM playlisttrack WHERE playlistid = ? AND trackid = ?";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, playlistId);
        prep.setInt(2, trackId);

        int rs = prep.executeUpdate();

        if (rs == 0) {
            throw new TrackException("No tracks found.");
        }

        return true;
    }

    @Override
    public boolean addTrackToPlaylist(int playlistId, int trackId) throws SQLException, TrackException {
        connection = dbCon.getConnection();

        String query = "INSERT INTO playlisttrack (playlistid, trackid) VALUES (?, ?)";
        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, playlistId);
        prep.setInt(2, trackId);

        int rs = prep.executeUpdate();

        if (rs == 0) {
            throw new TrackException("Track not added to playlist.");
        }

        return true;
    }

    /**
     * creates tracklist from result set
     * @param rs
     * @throws SQLException
     */
    private void createTracklist(ResultSet rs) throws SQLException {
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
