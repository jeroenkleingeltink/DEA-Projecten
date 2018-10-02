package nl.oose.jeroenkleingeltink;

import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class EndpointHandler {
    @GET
    @Path("/")
    @Produces(MediaType.TEXT_PLAIN)
    public String Welcome() {
        return "Welcome to FizzBuzz";
    }

    @GET
    @Path("/{value}")
    @Produces(MediaType.TEXT_PLAIN)
    public Response getUrlValue(@PathParam("value") String input) {
        if (StringUtils.isNumeric(input)) {
            return Response.ok(input).build();
        } else {
            return Response.serverError().build();
        }
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postIntToString(IntNumberModel number) {
        StringNumberModel stringNumber = new StringNumberModel();

        stringNumber.setNumber(Integer.toString(number.getNumber()));

        return Response.ok().entity(stringNumber).build();
    }
}
