package jeroen.school.dea.DataSource;

import jeroen.school.dea.Domain.TracksDTO;
import jeroen.school.dea.Exceptions.TrackException;

import java.sql.SQLException;

public interface ITrackDAO {
    TracksDTO getAllTracksNotInPlaylist(int playlistId) throws SQLException;
    TracksDTO getAllTracksByPlaylistId(int playlistId) throws SQLException;
    boolean deleteTrackFromPlaylist(int playlistId, int trackId) throws SQLException, TrackException;
    boolean addTrackToPlaylist(int playlistId, int trackId) throws SQLException, TrackException;
}
