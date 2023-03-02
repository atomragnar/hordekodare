package org.hordekodning.alltid.hordekodare.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String getHome() {
        return "login";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/sign-in")
    public String signIn() {
        return "redirect:/userpage";
    }


    @PostMapping("/logout")
    public String handleLogout() {
        return "login";
    }


/*    @GetMapping("/403")
    public String forbidden() {
        return "error";
    }*/


}


