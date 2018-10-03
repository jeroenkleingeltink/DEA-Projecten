package jeroen.school.dea.Controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jeroen.school.dea.Entities.UserEntity;
import jeroen.school.dea.Models.UserModel;
import jeroen.school.dea.Services.UserService;

import java.sql.SQLException;

@Path("/login")
public class LoginController {
    UserService userService;

    public LoginController() {
        userService = new UserService();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(UserModel user) {
        // validate log in with AuthenticationHandler
        UserEntity ue = new UserEntity();
        try {
            ue = UserService.validateUser(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // get userentity from authenticationhandler
        System.out.println(ue);
        // return user entity
        return Response.ok().entity(ue).build();
    }
}
