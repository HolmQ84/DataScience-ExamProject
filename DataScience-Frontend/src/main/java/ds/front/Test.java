package ds.front;

import ds.front.Service.MusicService;
import ds.front.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

public class Test {

    @Autowired
    MusicService musicService;

    public static void main(String[] args) {
        MusicService musicService = new MusicService();
        // List<Music> list = musicService.csvToModel();
        // System.out.println(list);
        System.out.println(musicService.getMusic());
        // musicService.listToMongo(list);
    }
}
