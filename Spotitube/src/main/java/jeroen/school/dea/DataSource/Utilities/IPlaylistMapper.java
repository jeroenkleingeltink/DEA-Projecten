package jeroen.school.dea.DataSource.Utilities;

import jeroen.school.dea.Domain.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTO;
import jeroen.school.dea.Domain.PlaylistsDTO;
import jeroen.school.dea.Exceptions.PlaylistException;

import java.sql.SQLException;

public interface IPlaylistMapper {
    PlaylistsDTO getAllPlayListsByToken(int userId) throws SQLException, PlaylistException;
    boolean deletePlaylistById(int playlistId) throws SQLException, PlaylistException;
    boolean createNewPlaylist(CreatePlaylistDTO newPlaylist, int userId) throws SQLException, PlaylistException;
    boolean updatePlaylist(PlaylistDTO changedPlaylist) throws SQLException, PlaylistException;
//    static PlaylistMapper getInstance();
}
