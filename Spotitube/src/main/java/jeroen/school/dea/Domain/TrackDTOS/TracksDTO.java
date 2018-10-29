package jeroen.school.dea.Domain.TrackDTOS;

import jeroen.school.dea.Domain.TrackDTOS.TrackDTO;

import java.util.ArrayList;
import java.util.List;

public class TracksDTO {
    private List<TrackDTO> tracks = new ArrayList<>();

    public List<TrackDTO> getTracks() {
        return tracks;
    }

    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
    }
}
