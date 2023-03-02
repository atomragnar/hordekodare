
package org.hordekodning.alltid.hordekodare.Service;

import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;
import java.time.LocalTime;
import java.time.LocalDate;
import java.time.LocalTime;


@Service
@SessionScope
public class ServiceTime {

    LocalTime now = LocalTime.now();
    LocalDate ld = LocalDate.now();

    //Night
    LocalTime time1 = LocalTime.parse("19:01:00.00");
    LocalTime time2 = LocalTime.parse("23:59:00.00");

    LocalTime time9 = LocalTime.parse("00:00:00.00");
    LocalTime time10 = LocalTime.parse("06:00:00.00");

    //Morning
    LocalTime time3 = LocalTime.parse("06:01:00.00");
    LocalTime time4 = LocalTime.parse("09:00:00.00");
    //Day
    LocalTime time5 = LocalTime.parse("09:01:00.00");
    LocalTime time6 = LocalTime.parse("17:00:00.00");
    //Afternoon
    LocalTime time7 = LocalTime.parse("17:01:00.00");
    LocalTime time8 = LocalTime.parse("19:00:00.00");

    public ServiceTime() {
        this.now = now;
        this.ld = ld;
    }

    public LocalTime getNow() {
        return now;
    }

    public LocalDate getLd() {
        return ld;
    }

    public boolean isNight() {
        Boolean night;
        if (now.isAfter(time1) && now.isBefore(time2)&& now.isAfter(time9) && now.isBefore(time10)
) {
            return night = true;
        }
    return false;

    }

    public boolean isMorning() {
        Boolean morning;
        if (now.isAfter(time3) && now.isBefore(time4)) {
            return morning = true;
        }
        return false;

    }

    public boolean isDay() {
        Boolean day;
        if (now.isAfter(time5) && now.isBefore(time6)) {
            return day = true;
        }
        return false;

    }

    public boolean isAfternoon() {
        Boolean afternoon;
        if (now.isAfter(time7) && now.isBefore(time8)) {
            return afternoon = true;
        }
        return false;

    }

}
