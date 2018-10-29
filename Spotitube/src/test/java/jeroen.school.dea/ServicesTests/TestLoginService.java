package jeroen.school.dea.ServicesTests;

import jeroen.school.dea.DataSource.DAO.IUserDAO;
import jeroen.school.dea.Domain.UserDTOS.LoginDTO;
import jeroen.school.dea.Domain.UserDTOS.UserDTO;
import jeroen.school.dea.Exceptions.UserNotFoundException;
import jeroen.school.dea.Services.LoginService;
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

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TestLoginService {
    private UserDTO userDto;
    private LoginDTO loginDto;

    @Mock
    IUserDAO userDAO;

    @InjectMocks
    LoginService loginService;

    private static final String USERNAME = "testuser";
    private static final String PASSWORD = "testpass";
    private static final String TOKEN = "1234";
    private static final String USER = "test user";

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);

        userDto = new UserDTO();
        userDto.setUser(USER);
        userDto.setToken(TOKEN);

        loginDto = new LoginDTO();
        loginDto.setUser(USERNAME);
        loginDto.setPassword(PASSWORD);
    }

    @Test
    public void testValidLoginCredentials() throws SQLException, UserNotFoundException {
        when(userDAO.login(any(LoginDTO.class))).thenReturn(userDto);
        //doReturn(userDto).when(userDAO).login(any(LoginDTO.class));

        Response response = loginService.login(loginDto);

        Assert.assertEquals(Response.Status.OK, response.getStatusInfo().toEnum());
    }

    @Test
    public void testWrongLoginCredentials() throws SQLException, UserNotFoundException {
        when(userDAO.login(any(LoginDTO.class))).thenThrow(new UserNotFoundException());

        Response response = loginService.login(loginDto);

        Assert.assertEquals(Response.Status.UNAUTHORIZED, response.getStatusInfo().toEnum());
    }

    @Test
    public void testSQLErrorDuringLogin() throws SQLException, UserNotFoundException {
        when(userDAO.login(any(LoginDTO.class))).thenThrow(new SQLException());

        Response response = loginService.login(loginDto);

        Assert.assertEquals(Response.Status.INTERNAL_SERVER_ERROR, response.getStatusInfo().toEnum());
    }
}
