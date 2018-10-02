package nl.oose.jeroenkleingeltink;

import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class EndpointHandler {
    BuzzFactory factory = BuzzFactory.getInstance();

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

    // Uses opgave2 A fizzbuzz factory
    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postIntToString(IntNumberModel number) {
        StringNumberModel stringNumber = new StringNumberModel();

        BuzzAdapter ba = factory.create("Rings");

        stringNumber.setNumber(ba.getValue(number.getNumber()));

        return Response.ok().entity(stringNumber).build();
    }

    // Uses opgave2 B Adapter for RingsBuzz
    @POST
    @Path("/rings")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postIntToStringRings(IntNumberModel number) {
        StringNumberModel stringNumber = new StringNumberModel();

        BuzzAdapter ba = factory.create("Rings");

        stringNumber.setNumber(ba.getValue(number.getNumber()));

        return Response.ok().entity(stringNumber).build();
    }

    // Uses opgave2 B Adapter for FizzBuzz
    @POST
    @Path("/fizz")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postIntToStringFizz(IntNumberModel number) {
        StringNumberModel stringNumber = new StringNumberModel();

        BuzzAdapter ba = factory.create("Fizz");

        stringNumber.setNumber(ba.getValue(number.getNumber()));

        return Response.ok().entity(stringNumber).build();
    }
}
