package jeroen.school.dea.DomainTests;

import jeroen.school.dea.Domain.PlaylistDTOS.PlaylistsDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPlaylistDTO {
    PlaylistsDTO playlists;

    @Before
    public void setup() {
        playlists = new PlaylistsDTO();
    }

    @Test
    public void testCorrectlyIncreasePlaylistLength() {
        int baseDuration = 10;
        int increaseDuration = 20;

        playlists.setLength(baseDuration);
        playlists.increasePlaylistLength(increaseDuration);

        Assert.assertEquals(baseDuration + increaseDuration, playlists.getLength());
    }
}
