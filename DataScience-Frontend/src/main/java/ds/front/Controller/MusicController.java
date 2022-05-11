package ds.front.Controller;

import ds.front.Model.Music;
import ds.front.Service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MusicController {

    @Autowired
    MusicService musicService;

    @GetMapping("/filldb")
    public String musicToDB() {
        int value = musicService.storeListOfMusicInMongoDB(musicService.convertCSVtoListOfMusic());
        return "Music list successfully stored in MongoDB. " + value + " song added.";
    }

    @GetMapping("/getMusic")
    public List<Music> getAllMusic() {
        return musicService.getMusic();
    }
}
