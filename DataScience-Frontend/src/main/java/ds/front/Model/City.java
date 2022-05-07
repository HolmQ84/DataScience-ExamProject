package ds.front.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class City {
    @Id
    private int cityId;
    private String cityName;
    private int postalCode;
}

