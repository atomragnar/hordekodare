package org.hordekodning.alltid.hordekodare.Time;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalTime;

@Controller
public class TimeController {

@Autowired
Time time = new Time();

    @GetMapping("/userpage")
    public String showTime(Model m){
        m.addAttribute("time", time);
        return "userpage";
    }

}
