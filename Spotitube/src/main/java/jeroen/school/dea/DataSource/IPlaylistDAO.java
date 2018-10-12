package jeroen.school.dea.DataSource;

import jeroen.school.dea.Domain.TempPlaylistDTO;
import jeroen.school.dea.Domain.PlaylistsDTO;

import java.sql.SQLException;

public interface IPlaylistDAO {
    PlaylistsDTO getAllPlayListsByToken(int userId) throws SQLException;
    boolean deletePlaylistById(int playlistId) throws SQLException;
    boolean createNewPlaylist(TempPlaylistDTO newPlaylist, int userId) throws SQLException;
    boolean updatePlaylist(TempPlaylistDTO changedPlaylist) throws SQLException;
}
