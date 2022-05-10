package ds.front.Model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document
public class Music {
    @Id
    private int musicId;
    private String title;
    private int rank;
    private Date date;
    private String artist;
    private String spotifyUrl;
    private String region;
    private String chart;
    private String trend;
}
