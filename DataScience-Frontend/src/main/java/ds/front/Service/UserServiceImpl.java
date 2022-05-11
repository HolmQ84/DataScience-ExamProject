package ds.front.Service;

import ds.front.Model.User;
import ds.front.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public EntityModel<User> getUserById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new Exception("Couldnt find user with ID: " + id);

        return EntityModel.of(user.get());
    }

    @Override
    public ResponseEntity<User> createUser(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt(10)));
        User savedUser = userRepository.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedUser.getUserId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @Override
    public ResponseEntity<User> updateUser(User user, int id) {
        Optional<User> attendanceOptional = userRepository.findById(id);
        if (attendanceOptional.isEmpty())
            return ResponseEntity.notFound().build();
        user.setUserId(id);
        userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    @Override
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User successfully deleted.";
    }

    @Override
    public User createTestUser(User user) {
        return userRepository.save(user);
    }
}
