package org.hordekodning.alltid.hordekodare.login;

import java.util.List;

import org.hordekodning.alltid.hordekodare.config.SecurityConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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
public class LoginController {

    @Autowired
    UserService userService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

  /*  @GetMapping("/")
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
    }*/


    @GetMapping("/loginOld")
    public String loginForm() {
        return "loginOld";
    }

    @RequestMapping("/loginOld")
    public String linkLogin() {
        return "loginOld";
    }

    @PostMapping("/loginOld")
    public String loginCheck(@RequestParam String username, @RequestParam String password) {
        int check = userService.isLoginValid(username, password);
        if (check == Constants.USERNAME_WRONG) {
            return "loginOld";
        }
        if (check == Constants.PASSWORD_WRONG) {
            return "loginOld";
        }

        return "redirect:/userpage";
    }


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
        encodeUserPW(user);

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


    @GetMapping("/usersOld")
    public String users(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "usersOld";
    }

    

    @GetMapping("/users")
    public String getUsers(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "users";
    }


    @PostMapping("/handleAddUser")
    public String handleAddUser(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        encodeUserPW(user);

        if (userService.isEmailRegistered(user.getEmail())) {
            result.rejectValue("email", Constants.EMAIL_REJECT_MESSAGE);
            return "/add_user";
        }

        if (result.hasErrors()) {
            model.addAttribute("user", user);
            return "/add_user";
        }

        userService.saveUser(user);
        return "redirect:/users?success";
    }


    @GetMapping("/add_user")
    public String addUser(Model model, @RequestParam(required = false, defaultValue =  "missing") String id) {
        model.addAttribute("user", userService.getUserById(id));
        return "add_user";
    }


    public void encodeUserPW(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
    }


    
}
