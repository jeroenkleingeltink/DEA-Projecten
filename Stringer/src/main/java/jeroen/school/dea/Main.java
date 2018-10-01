package jeroen.school.dea;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.json.*;

@Path("/stringer")
public class Main {

    @GET
    @Path("/reverse")
    @Produces(MediaType.TEXT_PLAIN)
    public String reverseGet(@QueryParam("string") String input) {
        Stringer stringer = new Stringer(input);

        return stringer.getReverse();
    }

    @POST
    @Path("/reverse")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.APPLICATION_JSON)
    public Response reversePost(String input) {
        Stringer stringer = new Stringer(input);

        return Response.ok().entity(stringer).build();
    }

    @GET
    @Path("/reverse/{value}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response reverseCalcGet(@PathParam("value") String input) {
        IStringer stringer = new StringCalcAdapter(new StringCalc(input));

        return Response.ok(String.format("{\"Reverse calced\": \"%s\"}", stringer.getReverse())).build();
    }
}
