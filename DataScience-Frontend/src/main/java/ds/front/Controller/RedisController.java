package ds.front.Controller;

import ds.front.Model.User;
import ds.front.Service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RequestMapping("/redis")
@RestController
public class RedisController {

    @Autowired
    RedisService redisService;

    @GetMapping("/saveUser")
    public User saveUser(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return redisService.saveUser(user);
    }

    @GetMapping("/allUsers")
    public ResponseEntity<List<User>> getAllUsers(){
        return ResponseEntity.ok(redisService.getAllUsers());
    }

    @GetMapping("/getOne/{id}")
    public User getOneInvoice(@PathVariable Integer id) {
        return redisService.getOneInvoice(id);
    }
}
