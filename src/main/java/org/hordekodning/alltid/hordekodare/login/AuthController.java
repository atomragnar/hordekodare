package org.hordekodning.alltid.hordekodare.login;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;

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
    public String linkLogin() {
        return "login";
    }

    @PostMapping("/login") 
    public String loginCheck(@RequestParam String username, @RequestParam String password) {
        int check = userService.isLoginValid(username, password);
        if (check == Constants.USERNAME_WRONG) {
            return "login";
        }
        if (check == Constants.PASSWORD_WRONG) {
            return "login";
        }
        return "redirect:/userpage";
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
    public String registration(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {

        if (userService.isEmailRegistered(user.getEmail())) {
            result.rejectValue("email", Constants.EMAIL_REJECT_MESSAGE);
        }
        
        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "register";
        }

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
