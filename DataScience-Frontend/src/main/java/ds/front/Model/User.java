package ds.front.Model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@Entity
public class User {
    @Id
    private int userId;
    private String userName;
    private String password;
    private int personId;
}
