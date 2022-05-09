package ds.front.Service;

import ds.front.Model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User userLogin(int username, String password);
    List<User> getAllUsers();
    User getUserById(int id);
    User createTestUser(User user);
}
