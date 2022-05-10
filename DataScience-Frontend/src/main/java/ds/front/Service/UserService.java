package ds.front.Service;

import ds.front.Model.User;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    ResponseEntity<User> userLogin(int username, String password);
    List<User> getAllUsers();
    EntityModel<User> getUserById(int id) throws Exception;
    ResponseEntity<User> createUser(User user);
    ResponseEntity<User> updateUser(User user, int id);
    String deleteUser(int id);

    User createTestUser(User user);
}
