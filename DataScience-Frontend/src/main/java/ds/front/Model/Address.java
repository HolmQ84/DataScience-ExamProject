package ds.front.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class Address {
    @Id
    private int addressId;
    private int streetId;
    private int streetNumber;
    private int cityId;
    private String country;
}
