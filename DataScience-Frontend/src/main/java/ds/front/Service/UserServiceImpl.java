package ds.front.Service;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;
import ds.front.Model.User;
import ds.front.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.awt.image.BandCombineOp;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<User> userLogin(int username, String password) {
        userRepository.findAll();
        // TODO - Finish this function.
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public EntityModel<User> getUserById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (!user.isPresent())
            throw new Exception("id: " + id);

        EntityModel<User> resource = EntityModel.of(user.get()); 						    // get the resource
        return resource;
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
