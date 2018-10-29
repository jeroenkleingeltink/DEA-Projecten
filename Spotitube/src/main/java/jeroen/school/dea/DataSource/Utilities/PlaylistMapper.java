package jeroen.school.dea.DataSource.Utilities;

import jeroen.school.dea.DataSource.DAO.IPlaylistDAO;
import jeroen.school.dea.Domain.PlaylistDTOS.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistDTO;
import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistsDTO;
import jeroen.school.dea.Exceptions.PlaylistException;

import javax.ejb.Singleton;
import javax.inject.Inject;
import java.sql.SQLException;

@Singleton
public class PlaylistMapper implements IPlaylistMapper {
    @Inject
    private IPlaylistDAO playlistDAO;

    private static PlaylistMapper instance;

    private PlaylistsDTO playlistsIdentity = new PlaylistsDTO();

    private boolean hasPropertyChanged = true;

    public static PlaylistMapper getInstance() {
        if (instance == null) {
            instance = new PlaylistMapper();
        }

        return instance;
    }

    @Override
    public PlaylistsDTO getAllPlayListsByToken(int userId) throws SQLException, PlaylistException {
        PlaylistsDTO playlists = new PlaylistsDTO();

        if(hasPropertyChanged) {

            playlists = playlistDAO.getAllPlayListsByToken(userId);

            playlistsIdentity = playlists;

            hasPropertyChanged = false;

            return playlists;
        }

        return playlistsIdentity;
    }

    @Override
    public boolean deletePlaylistById(int playlistId) throws SQLException, PlaylistException {
        if (!playlistDAO.deletePlaylistById(playlistId)) {

            return false;

        }

        hasPropertyChanged = true;

        return true;
    }

    @Override
    public boolean createNewPlaylist(CreatePlaylistDTO newPlaylist, int userId) throws SQLException, PlaylistException {
        if (!playlistDAO.createNewPlaylist(newPlaylist, userId)) {

            return false;

        }

        hasPropertyChanged = true;

        return true;
    }

    @Override
    public boolean updatePlaylist(PlaylistDTO changedPlaylist) throws SQLException, PlaylistException {
        if (!playlistDAO.updatePlaylist(changedPlaylist)) {

            return false;

        }

        hasPropertyChanged = true;

        return true;
    }
}
