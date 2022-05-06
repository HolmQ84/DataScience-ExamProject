package ds.front.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.sql.Date;

@Data
@Entity
public class Person {
    @Id
    private int personId;
    private String firstName;
    private String lastName;
    private Date birthdate;
    private int addressId;
}
