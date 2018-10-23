package jeroen.school.dea.DataSource;

import jeroen.school.dea.DataSource.Utilities.IDBConnection;
import jeroen.school.dea.DataSource.Exceptions.UserNotFoundException;
import jeroen.school.dea.Domain.LoginDTO;
import jeroen.school.dea.Domain.UserDTO;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAO implements IUserDAO {
    private Connection connection;

    @Inject
    private IDBConnection dbCon;

    @Override
    public UserDTO validate(LoginDTO user) throws SQLException {
        UserDTO loggedInUser = new UserDTO();
        connection = dbCon.getConnection();

        String query = "SELECT * FROM user WHERE username = ? AND password = ?";

        PreparedStatement prep = connection.prepareStatement(query);
        prep.setString(1, user.getUser());
        prep.setString(2, user.getPassword());
        ResultSet rs = prep.executeQuery();

        if (!rs.next()) {
            throw new UserNotFoundException("No user results found.");
        } else {
            rs.beforeFirst();

            while(rs.next()) {
                loggedInUser.setToken(rs.getString("token"));
                loggedInUser.setUser(rs.getString("firstname") + " " + rs.getString("lastname"));
            }
        }

        return loggedInUser;
    }

    /**
     * Gets the userId based on the token
     * @param token
     * @return Int userId
     * @throws SQLException
     */
    @Override
    public int getUserIdByToken(String token) throws SQLException {
        connection = dbCon.getConnection();
        int userId = 0;

        String query = "SELECT userid FROM user WHERE token = ?";

        PreparedStatement prep = connection.prepareStatement(query);
        prep.setString(1, token);
        ResultSet rs = prep.executeQuery();

        if (!rs.next()) {
            throw new UserNotFoundException("No user results found.");
        } else {
            rs.beforeFirst();

            while(rs.next()) {
                userId = rs.getInt("userid");
            }
        }

        return userId;
    }

    @Override
    public boolean isPlaylistOwner(int playlistId, int userId) throws SQLException {
        connection = dbCon.getConnection();

        String query = "SELECT * FROM playlist WHERE playlistid = ? AND owner = ?";

        PreparedStatement prep = connection.prepareStatement(query);
        prep.setInt(1, playlistId);
        prep.setInt(2, userId);
        ResultSet rs = prep.executeQuery();

        if (!rs.next()) {
            return false;
        }

        return true;
    }
}
