package ds.front.Model;

import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "music")
public class Music {
    @CsvBindByPosition(position = 0)
    private int musicId;
    @CsvBindByPosition(position = 1)
    private String title;
    @CsvBindByPosition(position = 2)
    private int rank;
    @CsvBindByPosition(position = 3)
    private Date date;
    @CsvBindByPosition(position = 4)
    private String artist;
    @CsvBindByPosition(position = 5)
    private String spotifyUrl;
    @CsvBindByPosition(position = 6)
    private String region;
    @CsvBindByPosition(position = 7)
    private String chart;
    @CsvBindByPosition(position = 8)
    private String trend;
    @CsvBindByPosition(position = 9)
    private int streams;
    @CsvBindByPosition(position = 10)
    private double danceability;
    @CsvBindByPosition(position = 11)
    private double energy;
    @CsvBindByPosition(position = 12)
    private double key;
    @CsvBindByPosition(position = 13)
    private double loudness;
    @CsvBindByPosition(position = 14)
    private double mode;
    @CsvBindByPosition(position = 15)
    private double speechiness;
    @CsvBindByPosition(position = 16)
    private double acousticness;
    @CsvBindByPosition(position = 17)
    private double instrumentalness;
    @CsvBindByPosition(position = 18)
    private double liveness;
    @CsvBindByPosition(position = 19)
    private double valence;
    @CsvBindByPosition(position = 20)
    private double tempo;
    @CsvBindByPosition(position = 21)
    private double duration_ms;

    public Music(String musicId, String title, String rank, Date date, String artist, String spotifyUrl,
                 String region, String chart, String trend, String streams, String danceability, String energy,
                 String key, String loudness, String mode, String speechiness, String acousticness,
                 String instrumentalness, String liveness, String valence, String tempo, String duration_ms) {
        this.musicId = Integer.parseInt(musicId);
        this.title = title;
        this.rank = Integer.parseInt(rank);
        this.date = date;
        this.artist = artist;
        this.spotifyUrl = spotifyUrl;
        this.region = region;
        this.chart = chart;
        this.trend = trend;
        this.streams = (int) Double.parseDouble(streams);
        this.danceability = Double.parseDouble(danceability);
        this.energy = Double.parseDouble(energy);
        this.key = Double.parseDouble(key);
        this.loudness = Double.parseDouble(loudness);
        this.mode = Double.parseDouble(mode);
        this.speechiness = Double.parseDouble(speechiness);
        this.acousticness = Double.parseDouble(acousticness);
        this.instrumentalness = Double.parseDouble(instrumentalness);
        this.liveness = Double.parseDouble(liveness);
        this.valence = Double.parseDouble(valence);
        this.tempo = Double.parseDouble(tempo);
        this.duration_ms = Double.parseDouble(duration_ms);
    }

    public Music() {
    }

    public int getMusicId() {
        return musicId;
    }

    public void setMusicId(String musicId) {
        this.musicId = Integer.parseInt(musicId);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = Integer.parseInt(rank);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSpotifyUrl() {
        return spotifyUrl;
    }

    public void setSpotifyUrl(String spotifyUrl) {
        this.spotifyUrl = spotifyUrl;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getChart() {
        return chart;
    }

    public void setChart(String chart) {
        this.chart = chart;
    }

    public String getTrend() {
        return trend;
    }

    public void setTrend(String trend) {
        this.trend = trend;
    }

    public int getStreams() {
        return streams;
    }

    public void setStreams(String streams) {
        this.streams = (int) Double.parseDouble(streams);
    }

    public double getDanceability() {
        return danceability;
    }

    public void setDanceability(String danceability) {
        this.danceability = Double.parseDouble(danceability);
    }

    public double getEnergy() {
        return energy;
    }

    public void setEnergy(String energy) {
        this.energy = Double.parseDouble(energy);
    }

    public double getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = Double.parseDouble(key);
    }

    public double getLoudness() {
        return loudness;
    }

    public void setLoudness(String loudness) {
        this.loudness = Double.parseDouble(loudness);
    }

    public double getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = Double.parseDouble(mode);
    }

    public double getSpeechiness() {
        return speechiness;
    }

    public void setSpeechiness(String speechiness) {
        this.speechiness = Double.parseDouble(speechiness);
    }

    public double getAcousticness() {
        return acousticness;
    }

    public void setAcousticness(String acousticness) {
        this.acousticness = Double.parseDouble(acousticness);
    }

    public double getInstrumentalness() {
        return instrumentalness;
    }

    public void setInstrumentalness(String instrumentalness) {
        this.instrumentalness = Double.parseDouble(instrumentalness);
    }

    public double getLiveness() {
        return liveness;
    }

    public void setLiveness(String liveness) {
        this.liveness = Double.parseDouble(liveness);
    }

    public double getValence() {
        return valence;
    }

    public void setValence(String valence) {
        this.valence = Double.parseDouble(valence);
    }

    public double getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = Double.parseDouble(tempo);
    }

    public double getDuration_ms() {
        return duration_ms;
    }

    public void setDuration_ms(String duration_ms) {
        this.duration_ms = Double.parseDouble(duration_ms);
    }
}
