package ds.front.Controller;

import ds.front.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/data")
public class DataController {

    @GetMapping("/test")
    public ModelAndView testPageForVisualizations() {
        ModelAndView modelAndView = new ModelAndView("visualization");
        User user = new User();
        user.setUsername("Test User");
        modelAndView.addObject("user", user);
        return modelAndView;
    }
}
