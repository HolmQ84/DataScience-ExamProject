package ds.front.Controller;

import ds.front.Model.User;
import ds.front.Service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class LoginController {

    @Autowired
    LoginService loginService;

    @GetMapping("/login")
    public ModelAndView loginPage(HttpSession session, HttpServletResponse response, @ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject(user);
        if (session.getAttribute("user") != null) {
            modelAndView.addObject("user", session.getAttribute("user"));
        }
        return modelAndView;
    }

    @PostMapping("/login")
    public RedirectView userLogin(HttpServletRequest request, @ModelAttribute User loginUser) {
        User user = loginService.validateLogin(loginUser);
        if (user.getUsername() != null) {
            request.getSession().setAttribute("user", user);
            request.getSession().setAttribute("loggedIn", true);
            return new RedirectView("/");
        }
        return new RedirectView("/login");
    }

    @GetMapping("/sessiontest")
    public String testtest(HttpSession session) {
        System.out.println(session.getAttribute("user"));
        return "Testing session cookie.. Check terminal.";
    }

    @GetMapping("/")
    public ModelAndView index(HttpSession session, HttpServletResponse response, @ModelAttribute User user) {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("user" ,session.getAttribute("user"));
        modelAndView.addObject("loggedIn", session.getAttribute("loggedIn"));
        return modelAndView;
    }

    @GetMapping("/logout")
    public RedirectView logout(HttpServletRequest request, HttpSession session, HttpServletResponse response) {
        session = request.getSession(false);
        session.invalidate();
        return new RedirectView("/login");
    }

    public void loginCheck(HttpSession session, HttpServletResponse response) {
        try {
            if (session.getAttribute("user") != null) {
                response.sendRedirect("/");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
