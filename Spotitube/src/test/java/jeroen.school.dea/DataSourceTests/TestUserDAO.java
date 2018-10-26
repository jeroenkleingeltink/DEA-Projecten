package jeroen.school.dea.DataSourceTests;

import jeroen.school.dea.DataSource.IUserDAO;
import jeroen.school.dea.Domain.LoginDTO;
import jeroen.school.dea.Domain.UserDTO;
import jeroen.school.dea.Exceptions.UserNotFoundException;
import org.junit.Test;

import javax.transaction.Transactional;
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
