package jeroen.school.dea.DataSource;

import jeroen.school.dea.DataSource.Utilities.MysqlConnection;

import javax.inject.Inject;
import java.sql.Connection;

public class UserDAO implements IUserDAO {
    private Connection con;

    @Override
    public boolean validate() {
        con = MysqlConnection.getConnection();

        return false;
    }
}
