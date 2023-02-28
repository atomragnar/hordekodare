package org.hordekodning.alltid.hordekodare.Time;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import java.time.LocalDate;
import java.time.LocalTime;
@Service
@SessionScope
public class Time {

   LocalTime now;
    LocalDate ld;


    public Time() {
        now = LocalTime.now();
        ld = LocalDate.now();
    }

    public LocalTime getNow() {
        return now;
    }

    public LocalDate getLd() {
        return ld;
    }
}


