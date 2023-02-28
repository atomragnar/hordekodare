package org.hordekodning.alltid.hordekodare.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthController {

    @Autowired
    UserService userService;

    // GetMapping for index

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String linkhome() {
        return "index";
    }


    @GetMapping("/login")
    public String loginForm() {
        return "login";
    }

    @RequestMapping("/login")
    public String linklogin() {
        return "login";
    }

    @PostMapping("/login") 
    public String logincheck(@RequestParam String username, @RequestParam String password) {
        return "userpage";
    }


    // registration form.

    @RequestMapping("/register") 
    public String linkRegister() {
        return "register";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        User user = userService.getNewUser();
        model.addAttribute("user", user);
        return "register";
    }


    @PostMapping("/register/save")
    public String registration(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/register?success";
    }


    @GetMapping("/users")
    public String users(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    



    
}
