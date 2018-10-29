package jeroen.school.dea.DataSourceTests;

import jeroen.school.dea.DataSource.DAO.IUserDAO;
import jeroen.school.dea.Domain.UserDTOS.LoginDTO;
import jeroen.school.dea.Domain.UserDTOS.UserDTO;
import jeroen.school.dea.Exceptions.UserNotFoundException;
import org.junit.Test;

import java.sql.SQLException;

import static org.mockito.Mockito.mock;

public class TestUserDAO {
    // Class to be tested
    private IUserDAO userDAO;

    @Test
    void testLogin() throws SQLException, UserNotFoundException {
        LoginDTO loginDto = new LoginDTO();
        userDAO = mock(IUserDAO.class);

        UserDTO userDto = userDAO.login(loginDto);
    }
}
