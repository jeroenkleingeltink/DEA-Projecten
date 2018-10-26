package jeroen.school.dea.ServicesTests;

import jeroen.school.dea.DataSource.IUserDAO;
import jeroen.school.dea.DataSource.Utilities.IPlaylistMapper;
import jeroen.school.dea.DataSource.Utilities.PlaylistMapper;
import jeroen.school.dea.Domain.CreatePlaylistDTO;
import jeroen.school.dea.Domain.PlaylistsDTO;
import jeroen.school.dea.Exceptions.PlaylistException;
import jeroen.school.dea.Exceptions.UnauthorizedException;
import jeroen.school.dea.Services.PlaylistService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.ws.rs.core.Response;

import java.sql.SQLException;

import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestPlaylistService {
    PlaylistsDTO playlists;
    CreatePlaylistDTO createPlaylist;
    PlaylistsDTO playlist;

    @Mock
    IPlaylistMapper playlistMapper;

    @Mock
    IUserDAO userDAO;

    @InjectMocks
    PlaylistService playlistService;

    private static final String TOKEN = "1234";
    private static final int USERID = 1;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        playlists = new PlaylistsDTO();

        createPlaylist = new CreatePlaylistDTO();

        playlist = new PlaylistsDTO();
    }

    @Test
    public void testSuccessfulCreatePlaylist() throws UnauthorizedException, SQLException, PlaylistException {
        when(userDAO.validate(TOKEN)).thenReturn(USERID);

        when(playlistMapper.createNewPlaylist(any(CreatePlaylistDTO.class), any(Integer.class))).thenReturn(true);

        when(playlistMapper.getAllPlayListsByToken(any(Integer.class))).thenReturn(playlist);

        Response response = playlistService.createPlaylist(TOKEN, new CreatePlaylistDTO());

        Assert.assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());
    }

    @Test
    public void testUnauthorizedCreatePlaylist() throws UnauthorizedException, SQLException {
        when(userDAO.validate(TOKEN)).thenThrow(new UnauthorizedException());

        Response response = playlistService.createPlaylist(TOKEN, new CreatePlaylistDTO());

        Assert.assertEquals(Response.Status.UNAUTHORIZED, response.getStatusInfo().toEnum());
    }

    @Test
    public void testPlaylistExceptionCreatePlaylist() throws UnauthorizedException, SQLException, PlaylistException {
        when(userDAO.validate(TOKEN)).thenReturn(USERID);

        when(playlistMapper.createNewPlaylist(any(CreatePlaylistDTO.class), any(Integer.class))).thenReturn(true);

        when(playlistMapper.getAllPlayListsByToken(any(Integer.class))).thenThrow(new PlaylistException());

        Response response = playlistService.createPlaylist(TOKEN, new CreatePlaylistDTO());

        Assert.assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo().toEnum());
    }

    @Test
    public void testSQLExceptionCreatePlaylist() throws UnauthorizedException, SQLException {
        when(userDAO.validate(TOKEN)).thenThrow(new SQLException());

        Response response = playlistService.createPlaylist(TOKEN, new CreatePlaylistDTO());

        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR, response.getStatusInfo().toEnum());
    }
}
