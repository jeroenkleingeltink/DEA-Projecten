package jeroen.school.dea.DataSource.DAO;

import jeroen.school.dea.Domain.PlaylistDTOS.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistsDTO;
import jeroen.school.dea.Domain.PlaylistsEntity;

public interface IHibernatePlaylistDAO {
    boolean createNewPlaylist(CreatePlaylistDTO newPlaylist, int userId);
    PlaylistsEntity getAllPlayListsByToken(int userId);
}
