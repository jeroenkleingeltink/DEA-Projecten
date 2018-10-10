package jeroen.school.dea.Services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/")
public class PlaylistService {

    @Path("/playlists")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllPlayLists(@QueryParam("token") String token) {
        return Response.ok(String.format("{\"playlists\" :[\n" +
                "               {\n" +
                "                  \"id\"    : 1,\n" +
                "                  \"name\"  : \"Death metal\",\n" +
                "                  \"owner\" : \"henk\",\n" +
                "                  \"tracks\": []\n" +
                "               },\n" +
                "               {\n" +
                "                  \"id\"    : 2,\n" +
                "                  \"name\"  : \"Pop\",\n" +
                "                  \"owner\" : 1,\n" +
                "                  \"tracks\": []\n" +
                "               }\n" +
                "              ],\n" +
                "  \"length\"  :0}")).build();

    }
}
