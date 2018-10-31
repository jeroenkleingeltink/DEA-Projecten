package jeroen.school.dea.DataSource.Utilities;

import jeroen.school.dea.Domain.PlaylistDTOS.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistsDTO;
import jeroen.school.dea.Domain.PlaylistsEntity;
import jeroen.school.dea.Exceptions.PlaylistException;

import java.sql.SQLException;

public interface IPlaylistMapper {
    PlaylistsDTO getAllPlayListsByToken(int userId) throws SQLException, PlaylistException;
    boolean deletePlaylistById(int playlistId) throws SQLException, PlaylistException;
    boolean createNewPlaylist(CreatePlaylistDTO newPlaylist, int userId) throws SQLException, PlaylistException;
    boolean updatePlaylist(PlaylistDTO changedPlaylist) throws SQLException, PlaylistException;
    PlaylistsEntity getAllPlayListsByTokenHibernate(int userId);
}
