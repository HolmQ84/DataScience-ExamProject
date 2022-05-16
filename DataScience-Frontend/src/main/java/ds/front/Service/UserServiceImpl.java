package ds.front.Service;

import ds.front.Model.User;
import ds.front.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;


import java.net.URI;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Cacheable(value = "User")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    @Cacheable(cacheNames = "users", key = "#id")
    public Optional<User> getUserById(int id) throws Exception {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty())
            throw new Exception("Couldnt find user with ID: " + id);

        return user;
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
    @CachePut(value="User", key="#id")
    public Optional<User> updateUser(User user, int id) {
        Optional<User> attendanceOptional = userRepository.findById(id);
        if (attendanceOptional.isEmpty())
            return null;
        user.setUserId(id);
        userRepository.save(user);
        return Optional.of(user);
    }

    @Override
    @CacheEvict(value="User", key="#id")
    // @CacheEvict(value="User", allEntries=true) //in case there are multiple entires to delete
    public String deleteUser(int id) {
        userRepository.deleteById(id);
        return "User successfully deleted.";
    }

    @Override
    public User createTestUser(User user) {
        return userRepository.save(user);
    }
}
