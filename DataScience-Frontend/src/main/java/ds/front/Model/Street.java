package ds.front.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Street {
    @Id
    private int streetId;
    private String streetName;
}
