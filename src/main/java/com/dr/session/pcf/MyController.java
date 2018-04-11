package com.dr.session.pcf;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Calendar;
import java.util.Date;

@RestController
public class MyController {

    @RequestMapping("/now")
    public String add(HttpSession session) {
        String timestamp = String.valueOf(Calendar.getInstance().getTimeInMillis());
        session.setAttribute("timestamp",timestamp);
        return timestamp;
    }

    @RequestMapping("/value")
    public Object get(HttpSession session) {
        return session.getAttribute("timestamp");
    }
}
