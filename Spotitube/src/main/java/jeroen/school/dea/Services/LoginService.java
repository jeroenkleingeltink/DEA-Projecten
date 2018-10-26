package jeroen.school.dea.Services;

import jeroen.school.dea.DataSource.IUserDAO;
import jeroen.school.dea.DataSource.UserDAO;
import jeroen.school.dea.Domain.LoginDTO;
import jeroen.school.dea.Domain.UserDTO;
import jeroen.school.dea.Exceptions.UserNotFoundException;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/")
public class LoginService {
    @Inject
    private UserDAO userDAO;

    public LoginService() {}

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO user) {
        UserDTO loggedInUser = new UserDTO();

        try {
            loggedInUser = userDAO.login(user);
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        } catch (UserNotFoundException e) {
            e.printStackTrace();

            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        return Response.ok().entity(loggedInUser).build();
    }
}
