package jeroen.school.dea.Services;

import jeroen.school.dea.DataSource.IUserDAO;
import jeroen.school.dea.DataSource.UserDAO;
import jeroen.school.dea.Domain.LoginDTO;
import jeroen.school.dea.Domain.UserDTO;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

@Path("/")
public class LoginService {
    @Inject
    private IUserDAO userDAO;

    public LoginService() {}

    @Path("/login")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(LoginDTO user) {
        UserDTO loggedInUser;

        try {
            loggedInUser = userDAO.validate(user);
        } catch (SQLException e) {
            e.printStackTrace();

            return Response.status(401).build();
        }

        return Response.status(200).entity(loggedInUser).build();
    }
}
