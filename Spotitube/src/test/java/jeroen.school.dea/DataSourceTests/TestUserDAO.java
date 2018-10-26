package jeroen.school.dea.DataSourceTests;

import jeroen.school.dea.DataSource.UserDAO;
import jeroen.school.dea.Domain.LoginDTO;
import jeroen.school.dea.Domain.UserDTO;
import jeroen.school.dea.Exceptions.UserNotFoundException;
import org.junit.Assert;
import org.junit.Test;

import javax.transaction.Transactional;
import java.sql.SQLException;

public class TestUserDAO {
    @Test
    public void testLogin() throws SQLException, UserNotFoundException {
        UserDAO userDAO = new UserDAO();

        LoginDTO loginDto = new LoginDTO();
        loginDto.setUser("jeroen");
        loginDto.setPassword("test1234");

        UserDTO userDto = userDAO.login(loginDto);

        Assert.assertEquals("Jeroen Klein Geltink", userDto.getUser());
    }
}
