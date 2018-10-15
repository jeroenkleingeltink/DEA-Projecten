package jeroen.school.dea.DataSource.Exceptions;

import java.sql.SQLException;

public class UserNotFoundException extends SQLException {
    public UserNotFoundException() {}

    public UserNotFoundException(String message) {
        super(message);
    }
}
