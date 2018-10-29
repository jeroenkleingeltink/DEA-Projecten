package jeroen.school.dea.Domain.PlaylistDTOS;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsDTO {
    private List<PlaylistDTO> playlists = new ArrayList<>();
    private int length = 0;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public List<PlaylistDTO> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistDTO> playlists) {
        this.playlists = playlists;
    }

    public void increasePlaylistLength(int increment) {
        this.length += increment;
    }
}
