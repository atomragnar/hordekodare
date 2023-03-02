package org.hordekodning.alltid.hordekodare.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/sign-in")
    public String signIn() {
        return "userpage";
    }



}


