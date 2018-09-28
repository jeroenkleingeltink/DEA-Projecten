package jeroen.school.dea.Services;

import jeroen.school.dea.Entities.UserEntity;
import jeroen.school.dea.Models.UserModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserService {
    private Connection con;

    public UserService() {
        con = new MysqlConnectionService.getConnection();
    }

    public UserEntity validateUser(UserModel user) throws SQLException {
        UserEntity loggedInUser = new UserEntity();

        String query = "SELECT * FROM user WHERE username = ? AND password = ?";
        PreparedStatement prep = con.prepareStatement(query);
        prep.setString(1, user.getUsername());
        prep.setString(2, user.getPassword());
        ResultSet rs = prep.executeQuery();

        if (!rs.next()){
            throw new SQLException("Not found");
        } else {
            rs.beforeFirst();
            while(rs.next()) {
                loggedInUser.setFirstname(rs.getString("firstname"));
                loggedInUser.setLastname(rs.getString("lastname"));
                loggedInUser.setToken(rs.getString("token"));
            }
        }
        return loggedInUser;
    }
}
