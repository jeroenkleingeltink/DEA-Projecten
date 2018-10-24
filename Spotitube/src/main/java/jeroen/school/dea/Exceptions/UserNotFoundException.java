package jeroen.school.dea.Exceptions;

import java.sql.SQLException;

public class UserNotFoundException extends Exception {
    public UserNotFoundException() {}

    public UserNotFoundException(String message) {
        super(message);
    }
}
