package jeroen.school.dea;

import javax.ejb.Singleton;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("/items")
@Singleton
public class ItemResource {
    private List<Item> items = new ArrayList<Item>();

    public ItemResource() {
        items.add(new Item("Bread", "Breakfast", "Delicious!"));
        items.add(new Item("Butter", "Breakfast", "Use it with bread"));
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getTextItems() {
        return "bread, butter";
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Item> getJsonItems() {
        return items;
    }
}
