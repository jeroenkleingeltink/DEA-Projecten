package jeroen.school.dea.Domain.PlaylistDTOS;

import jeroen.school.dea.Domain.TrackDTOS.TrackDTO;

import java.util.ArrayList;
import java.util.List;

public class PlaylistDTO {
    private int id;
    private String name;
    private int owner;
    private List<TrackDTO> tracks = new ArrayList<>();

    public PlaylistDTO(){}

    public PlaylistDTO(int id, String name, int owner) {
        this.id = id;
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

    public List<TrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }
}
