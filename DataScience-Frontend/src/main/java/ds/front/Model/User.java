package ds.front.Model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private int userId;
    private String username;
    private String password;
    private String email;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "person_id")
    private Person person;

    public User(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
    }

    public User() {
    }
}
