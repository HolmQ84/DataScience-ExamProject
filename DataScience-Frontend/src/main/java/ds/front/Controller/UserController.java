package ds.front.Controller;

import ds.front.Model.User;
import ds.front.Service.FakerUsers;
import ds.front.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
    public User getUserById(@PathVariable int userId) {
        System.out.println("Running fetch user with id: " + userId);
        return userService.getUserById(userId);
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
