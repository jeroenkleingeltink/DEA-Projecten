package jeroen.school.dea.Controllers;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import jeroen.school.dea.Models.UserModel;
import jeroen.school.dea.Services.UserService;

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

        // get userentity from authenticationhandler

        // return user entity
        return Response.ok("gek").build();
    }
}
