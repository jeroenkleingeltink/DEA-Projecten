package jeroen.school.dea.Domain;

public class PlaylistEntity {
    private int id;
    private String name;
    private int owner;

    public PlaylistEntity() {}

    public PlaylistEntity(String name, int owner) {
        this.name = name;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOwner() {
        return owner;
    }

    public void setOwner(int owner) {
        this.owner = owner;
    }
}
