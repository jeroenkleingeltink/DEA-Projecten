package jeroen.school.dea.Domain;

import java.util.ArrayList;
import java.util.List;

public class PlaylistsEntity {
    private List<PlaylistEntity> playlists = new ArrayList<>();
    private int length = 0;

    public List<PlaylistEntity> getPlaylists() {
        return playlists;
    }

    public void setPlaylists(List<PlaylistEntity> playlists) {
        this.playlists = playlists;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
}
