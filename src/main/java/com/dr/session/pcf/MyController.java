package com.dr.session.pcf;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@RestController
public class MyController {

    @RequestMapping("/now")
    public String add(HttpSession session) {
        String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
        session.setAttribute("timestamp", timestamp);
        return timestamp;
    }

    @RequestMapping("/value")
    public Object get(HttpSession session) {
        return session.getAttribute("timestamp");
    }


    @RequestMapping("/jasonversion")
    public String getJasonVersion(HttpSession session) {
        int counter = 0;

        Integer sessionCounter = (Integer) session.getAttribute("jasoncounter");
        if (sessionCounter != null) {
            counter = sessionCounter.intValue();
            counter++;
        }

        Date now = new Date();
        SimpleDateFormat month = new SimpleDateFormat("MM");
        System.err.println("Month: " + month.format(now));
        SimpleDateFormat year = new SimpleDateFormat("YY");
        System.err.println("Year: " + year.format(now));

        String jasonversion = "5." + year.format(now) + "." + month.format(now) + "." + counter;

        session.setAttribute("jasoncounter", new Integer(counter));

        return jasonversion;
    }

}
