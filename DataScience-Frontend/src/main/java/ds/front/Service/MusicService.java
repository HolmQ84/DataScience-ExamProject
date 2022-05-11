package ds.front.Service;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import ds.front.Model.Music;
import ds.front.Repository.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@EnableMongoRepositories(basePackages = "ds.front.Repository")
@Service
public class MusicService {

    @Autowired
    MusicRepository musicRepository;

    public List<Music> convertCSVtoListOfMusic() {
        try{
            CSVReader reader=
                    new CSVReaderBuilder(new FileReader("C:\\Users\\marti\\IdeaProjects\\DataScience-ExamProject\\DataScience-SongManagement\\data\\music-subset.csv")).
                            withSkipLines(1). // Skiping firstline as it is header
                            build();
            List<Music> musicList = reader.readAll().stream().map(data-> {
                Music music = new Music();
                music.setMusicId(data[0]);
                music.setTitle(data[1]);
                music.setRank(data[2]);
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date date = sdf1.parse(data[3]);
                    music.setDate(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                music.setArtist(data[4]);
                music.setSpotifyUrl(data[5]);
                music.setRegion(data[6]);
                music.setChart(data[7]);
                music.setTrend(data[8]);
                music.setStreams(data[9]);
                music.setDanceability(data[10]);
                music.setEnergy(data[11]);
                music.setKey(data[12]);
                music.setLoudness(data[13]);
                music.setMode(data[14]);
                music.setSpeechiness(data[15]);
                music.setAcousticness(data[16]);
                music.setInstrumentalness(data[17]);
                music.setLiveness(data[18]);
                music.setValence(data[19]);
                music.setTempo(data[20]);
                music.setDuration_ms(data[21]);
                return music;
            }).collect(Collectors.toList());
            return musicList;
        } catch (IOException | CsvException e) {
            e.printStackTrace();
            return new ArrayList<Music>();
        }
    }

    public void storeListOfMusicInMongoDB(List<Music> musicList) {
        musicRepository.saveAll(musicList);
    }

    public List<Music> getMusic() {
        return musicRepository.findAll();
    }
}
