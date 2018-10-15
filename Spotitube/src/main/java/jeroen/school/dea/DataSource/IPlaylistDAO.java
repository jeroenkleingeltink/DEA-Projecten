package jeroen.school.dea.DataSource;

import jeroen.school.dea.Domain.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTO;
import jeroen.school.dea.Domain.PlaylistsDTO;

import java.sql.SQLException;

public interface IPlaylistDAO {
    PlaylistsDTO getAllPlayListsByToken(int userId) throws SQLException;
    boolean deletePlaylistById(int playlistId) throws SQLException;
    boolean createNewPlaylist(CreatePlaylistDTO newPlaylist, int userId) throws SQLException;
    boolean updatePlaylist(PlaylistDTO changedPlaylist) throws SQLException;
}
