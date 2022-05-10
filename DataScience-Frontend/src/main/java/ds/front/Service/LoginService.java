package ds.front.Service;

import ds.front.Model.User;
import ds.front.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LoginService {

    @Autowired
    UserRepository userRepository;

    public User validateLogin(User loginUser) {
        try {
            List<User> allUsers = userRepository.findAll();
            for (User current : allUsers) {
                if (current.getUsername().equals(loginUser.getUsername())) {
                    if (BCrypt.checkpw(loginUser.getPassword(), current.getPassword())) {
                        return current;
                    }
                    return new User();
                }
            }
            return new User();
        } catch (Exception exception) {
            return new User();
        }
    }
}
