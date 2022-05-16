package ds.front.Controller;

import ds.front.Model.User;
import ds.front.Service.FakerUsers;
import ds.front.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;

@RequestMapping("/users")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable int userId) throws Exception {
        // TODO - Fix the person, address, city and street not being sent.
        return userService.getUserById(userId);
    }

    @PostMapping("/")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{id}")
    public Optional<User> updateUser(@RequestBody User user, @PathVariable int id) {
        return userService.updateUser(user, id);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        return userService.deleteUser(id);
    }

    @GetMapping("/test/createUser")
    public User createRandomUser() {
        FakerUsers fakerUser = new FakerUsers();
        User user = fakerUser.createFakeUser();
        try {
            userService.createTestUser(user);
            return user;
        } catch (Exception e) {
            System.out.println("Error: "+e);
            return new User();
        }
    }
}
