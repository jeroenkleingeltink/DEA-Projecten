package jeroen.school.dea.DataSource;

import jeroen.school.dea.Domain.LoginDTO;
import jeroen.school.dea.Domain.UserDTO;
import jeroen.school.dea.Exceptions.UnauthorizedException;
import jeroen.school.dea.Exceptions.UserNotFoundException;

import java.sql.SQLException;

public interface IUserDAO {
    UserDTO login(LoginDTO user) throws SQLException, UserNotFoundException;
    int validate(String token) throws SQLException, UnauthorizedException;
    boolean isPlaylistOwner(int playlistId, int userId) throws SQLException;
}
