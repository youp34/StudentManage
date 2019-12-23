package com.student.manage.pojo;

import com.student.manage.service.InformationserviceImpl;
import com.student.manage.service.SignserviceImpl;
import com.student.manage.tool.time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpSession;
@Controller
public class Finger_mess {
    @Autowired
    InformationserviceImpl informationservice;
    @Autowired
    HttpSession session;
    @Autowired
    SignserviceImpl signservice;
    private String  mess ;
    private String finger_c ;
    private String message;

    public String getFinger_c() {
        if (finger_c == null){
            finger_c ="1";
        }
        return finger_c;
    }
    public void setFinger_c(String finger_c) { this.finger_c = finger_c; }

    public String getMess() { return mess; }
    public void setMess(String mess) {
        if (!mess.equals("flase")) {
            System.out.println(mess);
            //Information information = informationservice.findsign(mess);
            System.out.println("stop!");
            time time = new time();
            signservice.finger_sign(informationservice.findsign("00f").getName(), time.getTime(), "0", "0", "1");
        }
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
