package jeroen.school.dea.DataSource;

import jeroen.school.dea.Domain.LoginDTO;
import jeroen.school.dea.Domain.UserDTO;

import java.sql.SQLException;

public interface IUserDAO {
    UserDTO validate(LoginDTO user) throws SQLException;
    int getUserIdByToken(String token) throws SQLException;
}
