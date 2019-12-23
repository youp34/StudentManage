package com.student.manage.controller;

import com.student.manage.pojo.*;
import com.student.manage.service.InformationserviceImpl;
import com.student.manage.service.LoginserviceImpl;
import com.student.manage.service.SignserviceImpl;
import com.student.manage.socket.finger_client;
import com.student.manage.tool.time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

import static com.student.manage.socket.finger_client.*;

@Controller
public class AjaxController {
    @Autowired
    SignserviceImpl signservice;
    @Autowired
    LoginserviceImpl loginservice;
    @Autowired
    InformationserviceImpl informationservice;

    time time = new time();
    @RequestMapping(value = "/attendance_today")
    @ResponseBody
    public List<Sign_in1> attendance_today(){                                                                           //每天
        List<Sign_in1> list=new ArrayList<>();
        List<Sign_in> list_today = signservice.queryAll();
        int attendance1 = 0;
        int sick1 = 0;
        int absence1 = 0;
        int attendance2 = 0;
        int sick2 = 0;
        int absence2 = 0;
        int attendance3 = 0;
        int sick3 = 0;
        int absence3 = 0;
        int attendance4 = 0;
        int sick4 = 0;
        int absence4 = 0;
        int attendance5 = 0;
        int sick5 = 0;
        int absence5 = 0;
        int attendance6 = 0;
        int sick6 = 0;
        int absence6 = 0;
        int attendance7 = 0;
        int sick7 = 0;
        int absence7 = 0;
        for (int i = 0; i<list_today.size(); i++){
            Sign_in day = list_today.get(i);
            String a = day.getSign_time();
            String[]  o = a.split("\\.");
            String[] ti = time.getTime().split("\\.");
            int w = Integer.parseInt(o[3]);
            int j = Integer.parseInt(o[4]);
            if (ti[2].equals(o[2])) {
                int q = w*100+j;
                if (q <=750) {
                    if (day.getSick().equals("1")) {
                        sick1 = sick1 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence1 = absence1 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance1 = attendance1 + 1;
                    }
                }
                if (q > 750 && q<=1010) {
                    if (day.getSick().equals("1")) {
                        sick2 = sick2 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence2 = absence2 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance2 = attendance2 + 1;
                    }
                }
                if (q <= 1210 && q>1010) {
                    if (day.getSick().equals("1")) {
                        sick3 = sick3 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence3 = absence3 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance3 = attendance3 + 1;
                    }
                }
                if (q <= 1510  && q>1210) {
                    if (day.getSick().equals("1")) {
                        sick4 = sick4 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence4 = absence4 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance4 = attendance4 + 1;
                    }
                }
                if (q < 1650 && q > 1510) {
                    if (day.getSick().equals("1")) {
                        sick5 = sick5 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence5 = absence5 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance5 = attendance5 + 1;
                    }
                }
                if (q < 2000 && q >= 1650) {
                    if (day.getSick().equals("1")) {
                        sick6 = sick6 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence6 = absence6 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance6 = attendance6 + 1;
                    }
                }
                if (q >= 2000) {
                    if (day.getSick().equals("1")) {
                        sick7 = sick7 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence7 = absence7 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance7 = attendance7 + 1;
                    }
                }
            }
        }
        Sign_in1 sign_in1 = new Sign_in1();
        sign_in1.setAbasence(absence1);
        sign_in1.setAttendance(attendance1);
        sign_in1.setSick(sick1);
        list.add(sign_in1);

        Sign_in1 sign_in2 = new Sign_in1();
        sign_in2.setAbasence(absence2);
        sign_in2.setAttendance(attendance2);
        sign_in2.setSick(sick2);
        list.add(sign_in2);

        Sign_in1 sign_in3 = new Sign_in1();
        sign_in3.setAbasence(absence3);
        sign_in3.setAttendance(attendance3);
        sign_in3.setSick(sick3);
        list.add(sign_in3);

        Sign_in1 sign_in4 = new Sign_in1();
        sign_in4.setAbasence(absence4);
        sign_in4.setAttendance(attendance4);
        sign_in4.setSick(sick4);
        list.add(sign_in4);

        Sign_in1 sign_in5 = new Sign_in1();
        sign_in5.setAbasence(absence5);
        sign_in5.setAttendance(attendance5);
        sign_in5.setSick(sick5);
        list.add(sign_in5);

        Sign_in1 sign_in6 = new Sign_in1();
        sign_in6.setAbasence(absence6);
        sign_in6.setAttendance(attendance6);
        sign_in6.setSick(sick6);
        list.add(sign_in6);

        Sign_in1 sign_in7 = new Sign_in1();
        sign_in7.setAbasence(absence7);
        sign_in7.setAttendance(attendance7);
        sign_in7.setSick(sick7);
        list.add(sign_in7);
        return list;
    }
    @RequestMapping(value = "/attendance_weekly")
    @ResponseBody
    public List<Sign_in1> attendance_weekly(){                                                                          //每周
        List<Sign_in1> list=new ArrayList<>();
        List<Sign_in> list_today = signservice.queryAll();
        int attendance1 = 0;
        int sick1 = 0;
        int absence1 = 0;
        int attendance2 = 0;
        int sick2 = 0;
        int absence2 = 0;
        int attendance3 = 0;
        int sick3 = 0;
        int absence3 = 0;
        int attendance4 = 0;
        int sick4 = 0;
        int absence4 = 0;
        int attendance5 = 0;
        int sick5 = 0;
        int absence5 = 0;
        int attendance6 = 0;
        int sick6 = 0;
        int absence6 = 0;
        int attendance7 = 0;
        int sick7 = 0;
        int absence7 = 0;
        for (int i = 0; i<list_today.size(); i++){
            Sign_in day = list_today.get(i);
            String a = day.getSign_time();
            String[]  o = a.split("\\.");
            String[] ti = time.getTime().split("\\.");
            int w = Integer.parseInt(o[2]);
            int x = Integer.parseInt(ti[5]);
            int r = Integer.parseInt(ti[2]);
            if (w>(r-x)) {
                if (o[5].equals("1")) {
                    if (day.getSick().equals("1")) {
                        sick1 = sick1 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence1 = absence1 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance1 = attendance1 + 1;
                    }
                }
                if (o[5].equals("2")) {
                    if (day.getSick().equals("1")) {
                        sick2 = sick2 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence2 = absence2 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance2 = attendance2 + 1;
                    }
                }
                if (o[5].equals("3")) {
                    if (day.getSick().equals("1")) {
                        sick3 = sick3 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence3 = absence3 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance3 = attendance3 + 1;
                    }
                }
                if (o[5].equals("4")) {
                    if (day.getSick().equals("1")) {
                        sick4 = sick4 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence4 = absence4 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance4 = attendance4 + 1;
                    }
                }
                if (o[5].equals("5")) {
                    if (day.getSick().equals("1")) {
                        sick5 = sick5 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence5 = absence5 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance5 = attendance5 + 1;
                    }
                }
                if (o[5].equals("6")) {
                    if (day.getSick().equals("1")) {
                        sick6 = sick6 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence6 = absence6 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance6 = attendance6 + 1;
                    }
                }
                if (o[5].equals("7")) {
                    if (day.getSick().equals("1")) {
                        sick7 = sick7 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence7 = absence7 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance7 = attendance7 + 1;
                    }
                }
            }
        }
        Sign_in1 sign_in1 = new Sign_in1();
        sign_in1.setAbasence(absence1);
        sign_in1.setAttendance(attendance1);
        sign_in1.setSick(sick1);
        list.add(sign_in1);

        Sign_in1 sign_in2 = new Sign_in1();
        sign_in2.setAbasence(absence2);
        sign_in2.setAttendance(attendance2);
        sign_in2.setSick(sick2);
        list.add(sign_in2);

        Sign_in1 sign_in3 = new Sign_in1();
        sign_in3.setAbasence(absence3);
        sign_in3.setAttendance(attendance3);
        sign_in3.setSick(sick3);
        list.add(sign_in3);

        Sign_in1 sign_in4 = new Sign_in1();
        sign_in4.setAbasence(absence4);
        sign_in4.setAttendance(attendance4);
        sign_in4.setSick(sick4);
        list.add(sign_in4);

        Sign_in1 sign_in5 = new Sign_in1();
        sign_in5.setAbasence(absence5);
        sign_in5.setAttendance(attendance5);
        sign_in5.setSick(sick5);
        list.add(sign_in5);

        Sign_in1 sign_in6 = new Sign_in1();
        sign_in6.setAbasence(absence6);
        sign_in6.setAttendance(attendance6);
        sign_in6.setSick(sick6);
        list.add(sign_in6);

        Sign_in1 sign_in7 = new Sign_in1();
        sign_in7.setAbasence(absence7);
        sign_in7.setAttendance(attendance7);
        sign_in7.setSick(sick7);
        list.add(sign_in7);
        return list;
    }
    @RequestMapping(value = "/attendance_month")
    @ResponseBody
    public List<Sign_in1> attendance_month(){                                                                           //每月
        List<Sign_in1> list=new ArrayList<>();
        List<Sign_in> list_today = signservice.queryAll();
        int attendance1 = 0;
        int sick1 = 0;
        int absence1 = 0;
        int attendance2 = 0;
        int sick2 = 0;
        int absence2 = 0;
        int attendance3 = 0;
        int sick3 = 0;
        int absence3 = 0;
        int attendance4 = 0;
        int sick4 = 0;
        int absence4 = 0;
        int attendance5 = 0;
        int sick5 = 0;
        int absence5 = 0;
        int attendance6 = 0;
        int sick6 = 0;
        int absence6 = 0;
        int attendance7 = 0;
        int sick7 = 0;
        int absence7 = 0;
        int attendance8 = 0;
        int sick8 = 0;
        int absence8 = 0;
        int attendance9 = 0;
        int sick9 = 0;
        int absence9 = 0;
        int attendance10 = 0;
        int sick10 = 0;
        int absence10 = 0;
        int attendance11 = 0;
        int sick11 = 0;
        int absence11 = 0;
        int attendance12 = 0;
        int sick12 = 0;
        int absence12 = 0;
        int attendance13 = 0;
        int sick13 = 0;
        int absence13 = 0;
        int attendance14 = 0;
        int sick14 = 0;
        int absence14 = 0;
        int attendance15 = 0;
        int sick15 = 0;
        int absence15 = 0;
        int attendance16 = 0;
        int sick16 = 0;
        int absence16 = 0;
        int attendance17 = 0;
        int sick17 = 0;
        int absence17 = 0;
        int attendance18 = 0;
        int sick18 = 0;
        int absence18 = 0;
        int attendance19 = 0;
        int sick19 = 0;
        int absence19 = 0;
        int attendance20 = 0;
        int sick20 = 0;
        int absence20 = 0;
        int attendance21 = 0;
        int sick21 = 0;
        int absence21 = 0;
        int attendance22 = 0;
        int sick22 = 0;
        int absence22 = 0;
        int attendance23 = 0;
        int sick23 = 0;
        int absence23 = 0;
        int attendance24 = 0;
        int sick24 = 0;
        int absence24 = 0;
        int attendance25 = 0;
        int sick25 = 0;
        int absence25 = 0;
        int attendance26 = 0;
        int sick26 = 0;
        int absence26 = 0;
        int attendance27 = 0;
        int sick27 = 0;
        int absence27 = 0;
        int attendance28 = 0;
        int sick28 = 0;
        int absence28 = 0;
        int attendance29 = 0;
        int sick29 = 0;
        int absence29 = 0;
        int attendance30 = 0;
        int sick30 = 0;
        int absence30 = 0;
        int attendance31 = 0;
        int sick31= 0;
        int absence31 = 0;
        for (int i = 0; i<list_today.size(); i++){
            Sign_in day = list_today.get(i);
            String a = day.getSign_time();
            String[]  o = a.split("\\.");
            int w = Integer.parseInt(o[2]);
                if (w==1) {
                    if (day.getSick().equals("1")) {
                        sick1 = sick1 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence1 = absence1 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance1 = attendance1 + 1;
                    }
                }
                if (w==2) {
                    if (day.getSick().equals("1")) {
                        sick2 = sick2 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence2 = absence2 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance2 = attendance2 + 1;
                    }
                }
                if (w==3) {
                    if (day.getSick().equals("1")) {
                        sick3 = sick3 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence3 = absence3 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance3 = attendance3 + 1;
                    }
                }
                if (w==4) {
                    if (day.getSick().equals("1")) {
                        sick4 = sick4 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence4 = absence4 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance4 = attendance4 + 1;
                    }
                }
                if (w==5) {
                    if (day.getSick().equals("1")) {
                        sick5 = sick5 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence5 = absence5 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance5 = attendance5 + 1;
                    }
                }
                if (w==6) {
                    if (day.getSick().equals("1")) {
                        sick6 = sick6 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence6 = absence6 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance6 = attendance6 + 1;
                    }
                }
                if (w==7) {
                    if (day.getSick().equals("1")) {
                        sick7 = sick7 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence7 = absence7 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance7 = attendance7 + 1;
                    }
                }
                if (w==8) {
                    if (day.getSick().equals("1")) {
                        sick8 = sick8 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence8 = absence8 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance8 = attendance8 + 1;
                    }
                }
                if (w==9) {
                    if (day.getSick().equals("1")) {
                        sick9 = sick9 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence9 = absence9 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance9 = attendance9 + 1;
                    }
                }
                if (w==10) {
                    if (day.getSick().equals("1")) {
                        sick10 = sick10 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence10 = absence10 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance10 = attendance10 + 1;
                    }
                }
                if (w==11) {
                    if (day.getSick().equals("1")) {
                        sick11 = sick11 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence11 = absence11 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance11 = attendance11 + 1;
                    }
                }
                if (w==12) {
                    if (day.getSick().equals("1")) {
                        sick12 = sick12 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence12 = absence12 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance12 = attendance12 + 1;
                    }
                }
                if (w==13) {
                    if (day.getSick().equals("1")) {
                        sick13 = sick13 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence13 = absence13 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance13 = attendance13 + 1;
                    }
                }
                if (w==14) {
                    if (day.getSick().equals("1")) {
                        sick14 = sick14 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence14 = absence14 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance14 = attendance14 + 1;
                    }
                }
                if (w==15) {
                    if (day.getSick().equals("1")) {
                        sick15 = sick15 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence15 = absence15 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance15 = attendance15 + 1;
                    }
                }
                if (w==16) {
                    if (day.getSick().equals("1")) {
                        sick16 = sick16 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence16 = absence16 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance16 = attendance16 + 1;
                    }
                }
                if (w==17) {
                    if (day.getSick().equals("1")) {
                        sick17 = sick17 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence17 = absence17 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance17 = attendance17 + 1;
                    }
                }
                if (w==18) {
                    if (day.getSick().equals("1")) {
                        sick18 = sick18 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence18 = absence18 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance18 = attendance18 + 1;
                    }
                }
                if (w==19) {
                    if (day.getSick().equals("1")) {
                        sick19 = sick19 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence19 = absence19 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance19 = attendance19 + 1;
                    }
                }
                if (w==20) {
                    if (day.getSick().equals("1")) {
                        sick20 = sick20 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence20 = absence20 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance20 = attendance20 + 1;
                    }
                }
                if (w==21) {
                    if (day.getSick().equals("1")) {
                        sick21 = sick21 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence21 = absence21 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance21 = attendance21 + 1;
                    }
                }
                if (w==22) {
                    if (day.getSick().equals("1")) {
                        sick22 = sick22 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence22 = absence22 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance22 = attendance22 + 1;
                    }
                }
                if (w==23) {
                    if (day.getSick().equals("1")) {
                        sick23 = sick23 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence23 = absence23 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance23 = attendance23 + 1;
                    }
                }
                if (w==24) {
                    if (day.getSick().equals("1")) {
                        sick24 = sick24 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence24 = absence24 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance24 = attendance24 + 1;
                    }
                }
                if (w==25) {
                    if (day.getSick().equals("1")) {
                        sick25 = sick25 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence25 = absence25 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance25 = attendance25 + 1;
                    }
                }
                if (w==26) {
                    if (day.getSick().equals("1")) {
                        sick26 = sick26 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence26 = absence26 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance26 = attendance26 + 1;
                    }
                }
                if (w==27) {
                    if (day.getSick().equals("1")) {
                        sick27 = sick27 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence27 = absence27 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance27 = attendance27 + 1;
                    }
                }
                if (w==28) {
                    if (day.getSick().equals("1")) {
                        sick28 = sick28 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence28 = absence28 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance28 = attendance28 + 1;
                    }
                }
                if (w==29) {
                    if (day.getSick().equals("1")) {
                        sick29 = sick29 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence29 = absence29 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance29 = attendance29 + 1;
                    }
                }
                if (w==30) {
                    if (day.getSick().equals("1")) {
                        sick30 = sick30 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence30 = absence30 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance30 = attendance30 + 1;
                    }
                }
                if (w==31) {
                    if (day.getSick().equals("1")) {
                        sick31 = sick31 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence31 = absence31 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance31 = attendance31 + 1;
                    }
                }
            }
        Sign_in1 sign_in1 = new Sign_in1();
        sign_in1.setAbasence(absence1);
        sign_in1.setAttendance(attendance1);
        sign_in1.setSick(sick1);
        list.add(sign_in1);

        Sign_in1 sign_in2 = new Sign_in1();
        sign_in2.setAbasence(absence2);
        sign_in2.setAttendance(attendance2);
        sign_in2.setSick(sick2);
        list.add(sign_in2);

        Sign_in1 sign_in3 = new Sign_in1();
        sign_in3.setAbasence(absence3);
        sign_in3.setAttendance(attendance3);
        sign_in3.setSick(sick3);
        list.add(sign_in3);

        Sign_in1 sign_in4 = new Sign_in1();
        sign_in4.setAbasence(absence4);
        sign_in4.setAttendance(attendance4);
        sign_in4.setSick(sick4);
        list.add(sign_in4);

        Sign_in1 sign_in5 = new Sign_in1();
        sign_in5.setAbasence(absence5);
        sign_in5.setAttendance(attendance5);
        sign_in5.setSick(sick5);
        list.add(sign_in5);

        Sign_in1 sign_in6 = new Sign_in1();
        sign_in6.setAbasence(absence6);
        sign_in6.setAttendance(attendance6);
        sign_in6.setSick(sick6);
        list.add(sign_in6);

        Sign_in1 sign_in7 = new Sign_in1();
        sign_in7.setAbasence(absence7);
        sign_in7.setAttendance(attendance7);
        sign_in7.setSick(sick7);
        list.add(sign_in7);

        Sign_in1 sign_in8 = new Sign_in1();
        sign_in8.setAbasence(absence8);
        sign_in8.setAttendance(attendance8);
        sign_in8.setSick(sick8);
        list.add(sign_in8);

        Sign_in1 sign_in9 = new Sign_in1();
        sign_in9.setAbasence(absence9);
        sign_in9.setAttendance(attendance9);
        sign_in9.setSick(sick9);
        list.add(sign_in9);

        Sign_in1 sign_in10 = new Sign_in1();
        sign_in10.setAbasence(absence10);
        sign_in10.setAttendance(attendance10);
        sign_in10.setSick(sick10);
        list.add(sign_in10);

        Sign_in1 sign_in11 = new Sign_in1();
        sign_in11.setAbasence(absence11);
        sign_in11.setAttendance(attendance11);
        sign_in11.setSick(sick11);
        list.add(sign_in11);

        Sign_in1 sign_in12 = new Sign_in1();
        sign_in12.setAbasence(absence12);
        sign_in12.setAttendance(attendance12);
        sign_in12.setSick(sick12);
        list.add(sign_in12);

        Sign_in1 sign_in13 = new Sign_in1();
        sign_in13.setAbasence(absence13);
        sign_in13.setAttendance(attendance13);
        sign_in13.setSick(sick13);
        list.add(sign_in13);

        Sign_in1 sign_in14 = new Sign_in1();
        sign_in14.setAbasence(absence14);
        sign_in14.setAttendance(attendance14);
        sign_in14.setSick(sick14);
        list.add(sign_in14);

        Sign_in1 sign_in15 = new Sign_in1();
        sign_in15.setAbasence(absence15);
        sign_in15.setAttendance(attendance15);
        sign_in15.setSick(sick15);
        list.add(sign_in15);

        Sign_in1 sign_in16 = new Sign_in1();
        sign_in16.setAbasence(absence16);
        sign_in16.setAttendance(attendance16);
        sign_in16.setSick(sick16);
        list.add(sign_in16);

        Sign_in1 sign_in17 = new Sign_in1();
        sign_in17.setAbasence(absence17);
        sign_in17.setAttendance(attendance17);
        sign_in17.setSick(sick17);
        list.add(sign_in17);

        Sign_in1 sign_in18 = new Sign_in1();
        sign_in18.setAbasence(absence18);
        sign_in18.setAttendance(attendance18);
        sign_in18.setSick(sick18);
        list.add(sign_in18);

        Sign_in1 sign_in19 = new Sign_in1();
        sign_in19.setAbasence(absence19);
        sign_in19.setAttendance(attendance19);
        sign_in19.setSick(sick19);
        list.add(sign_in19);

        Sign_in1 sign_in20 = new Sign_in1();
        sign_in20.setAbasence(absence20);
        sign_in20.setAttendance(attendance20);
        sign_in20.setSick(sick20);
        list.add(sign_in20);

        Sign_in1 sign_in21 = new Sign_in1();
        sign_in21.setAbasence(absence21);
        sign_in21.setAttendance(attendance21);
        sign_in21.setSick(sick21);
        list.add(sign_in21);

        Sign_in1 sign_in22 = new Sign_in1();
        sign_in22.setAbasence(absence22);
        sign_in22.setAttendance(attendance22);
        sign_in22.setSick(sick22);
        list.add(sign_in22);

        Sign_in1 sign_in23 = new Sign_in1();
        sign_in23.setAbasence(absence23);
        sign_in23.setAttendance(attendance23);
        sign_in23.setSick(sick23);
        list.add(sign_in23);

        Sign_in1 sign_in24 = new Sign_in1();
        sign_in24.setAbasence(absence24);
        sign_in24.setAttendance(attendance24);
        sign_in24.setSick(sick24);
        list.add(sign_in24);

        Sign_in1 sign_in25 = new Sign_in1();
        sign_in25.setAbasence(absence25);
        sign_in25.setAttendance(attendance25);
        sign_in25.setSick(sick25);
        list.add(sign_in25);

        Sign_in1 sign_in26 = new Sign_in1();
        sign_in26.setAbasence(absence26);
        sign_in26.setAttendance(attendance26);
        sign_in26.setSick(sick26);
        list.add(sign_in26);

        Sign_in1 sign_in27 = new Sign_in1();
        sign_in27.setAbasence(absence27);
        sign_in27.setAttendance(attendance27);
        sign_in27.setSick(sick27);
        list.add(sign_in27);

        Sign_in1 sign_in28 = new Sign_in1();
        sign_in28.setAbasence(absence28);
        sign_in28.setAttendance(attendance28);
        sign_in28.setSick(sick28);
        list.add(sign_in28);

        Sign_in1 sign_in29 = new Sign_in1();
        sign_in29.setAbasence(absence29);
        sign_in29.setAttendance(attendance29);
        sign_in29.setSick(sick29);
        list.add(sign_in29);

        Sign_in1 sign_in30 = new Sign_in1();
        sign_in30.setAbasence(absence30);
        sign_in30.setAttendance(attendance30);
        sign_in30.setSick(sick30);
        list.add(sign_in30);

        Sign_in1 sign_in31 = new Sign_in1();
        sign_in31.setAbasence(absence31);
        sign_in31.setAttendance(attendance31);
        sign_in31.setSick(sick31);
        list.add(sign_in31);
        return list;
    }
    @RequestMapping(value = "/attendance_personal")
    @ResponseBody
    public List<Sign_in1> attendance_personal(HttpSession session){                                                     //单个人出勤
        List<Sign_in1> list=new ArrayList<>();
        List<Sign_in> list_today = signservice.queryAll();
        int attendance1 = 0;
        int sick1 = 0;
        int absence1 = 0;
        int attendance2 = 0;
        int sick2 = 0;
        int absence2 = 0;
        int attendance3 = 0;
        int sick3 = 0;
        int absence3 = 0;
        int attendance4 = 0;
        int sick4 = 0;
        int absence4 = 0;
        int attendance5 = 0;
        int sick5 = 0;
        int absence5 = 0;
        int attendance6 = 0;
        int sick6 = 0;
        int absence6 = 0;
        int attendance7 = 0;
        int sick7 = 0;
        int absence7 = 0;
        int attendance8 = 0;
        int sick8 = 0;
        int absence8 = 0;
        int attendance9 = 0;
        int sick9 = 0;
        int absence9 = 0;
        int attendance10 = 0;
        int sick10 = 0;
        int absence10 = 0;
        int attendance11 = 0;
        int sick11 = 0;
        int absence11 = 0;
        int attendance12 = 0;
        int sick12 = 0;
        int absence12 = 0;
        int attendance13 = 0;
        int sick13 = 0;
        int absence13 = 0;
        int attendance14 = 0;
        int sick14 = 0;
        int absence14 = 0;
        int attendance15 = 0;
        int sick15 = 0;
        int absence15 = 0;
        int attendance16 = 0;
        int sick16 = 0;
        int absence16 = 0;
        int attendance17 = 0;
        int sick17 = 0;
        int absence17 = 0;
        int attendance18 = 0;
        int sick18 = 0;
        int absence18 = 0;
        int attendance19 = 0;
        int sick19 = 0;
        int absence19 = 0;
        int attendance20 = 0;
        int sick20 = 0;
        int absence20 = 0;
        int attendance21 = 0;
        int sick21 = 0;
        int absence21 = 0;
        int attendance22 = 0;
        int sick22 = 0;
        int absence22 = 0;
        int attendance23 = 0;
        int sick23 = 0;
        int absence23 = 0;
        int attendance24 = 0;
        int sick24 = 0;
        int absence24 = 0;
        int attendance25 = 0;
        int sick25 = 0;
        int absence25 = 0;
        int attendance26 = 0;
        int sick26 = 0;
        int absence26 = 0;
        int attendance27 = 0;
        int sick27 = 0;
        int absence27 = 0;
        int attendance28 = 0;
        int sick28 = 0;
        int absence28 = 0;
        int attendance29 = 0;
        int sick29 = 0;
        int absence29 = 0;
        int attendance30 = 0;
        int sick30 = 0;
        int absence30 = 0;
        int attendance31 = 0;
        int sick31= 0;
        int absence31 = 0;
        for (int i = 0; i<list_today.size(); i++){
            Information information = informationservice.finger_exist((String) session.getAttribute("student_id"));
            Sign_in day = list_today.get(i);
            String a = day.getSign_time();
            String[]  o = a.split("\\.");
            int w = Integer.parseInt(o[2]);

            if (day.getName().equals(information.getName())) {
                if (w==1) {
                    if (day.getSick().equals("1")) {
                        sick1 = sick1 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence1 = absence1 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance1 = attendance1 + 1;
                    }
                }
                if (w==2) {
                    if (day.getSick().equals("1")) {
                        sick2 = sick2 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence2 = absence2 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance2 = attendance2 + 1;
                    }
                }
                if (w==3) {
                    if (day.getSick().equals("1")) {
                        sick3 = sick3 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence3 = absence3 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance3 = attendance3 + 1;
                    }
                }
                if (w==4) {
                    if (day.getSick().equals("1")) {
                        sick4 = sick4 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence4 = absence4 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance4 = attendance4 + 1;
                    }
                }
                if (w==5) {
                    if (day.getSick().equals("1")) {
                        sick5 = sick5 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence5 = absence5 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance5 = attendance5 + 1;
                    }
                }
                if (w==6) {
                    if (day.getSick().equals("1")) {
                        sick6 = sick6 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence6 = absence6 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance6 = attendance6 + 1;
                    }
                }
                if (w==7) {
                    if (day.getSick().equals("1")) {
                        sick7 = sick7 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence7 = absence7 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance7 = attendance7 + 1;
                    }
                }
                if (w==8) {
                    if (day.getSick().equals("1")) {
                        sick8 = sick8 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence8 = absence8 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance8 = attendance8 + 1;
                    }
                }
                if (w==9) {
                    if (day.getSick().equals("1")) {
                        sick9 = sick9 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence9 = absence9 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance9 = attendance9 + 1;
                    }
                }
                if (w==10) {
                    if (day.getSick().equals("1")) {
                        sick10 = sick10 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence10 = absence10 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance10 = attendance10 + 1;
                    }
                }
                if (w==11) {
                    if (day.getSick().equals("1")) {
                        sick11 = sick11 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence11 = absence11 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance11 = attendance11 + 1;
                    }
                }
                if (w==12) {
                    if (day.getSick().equals("1")) {
                        sick12 = sick12 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence12 = absence12 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance12 = attendance12 + 1;
                    }
                }
                if (w==13) {
                    if (day.getSick().equals("1")) {
                        sick13 = sick13 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence13 = absence13 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance13 = attendance13 + 1;
                    }
                }
                if (w==14) {
                    if (day.getSick().equals("1")) {
                        sick14 = sick14 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence14 = absence14 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance14 = attendance14 + 1;
                    }
                }
                if (w==15) {
                    if (day.getSick().equals("1")) {
                        sick15 = sick15 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence15 = absence15 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance15 = attendance15 + 1;
                    }
                }
                if (w==16) {
                    if (day.getSick().equals("1")) {
                        sick16 = sick16 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence16 = absence16 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance16 = attendance16 + 1;
                    }
                }
                if (w==17) {
                    if (day.getSick().equals("1")) {
                        sick17 = sick17 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence17 = absence17 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance17 = attendance17 + 1;
                    }
                }
                if (w==18) {
                    if (day.getSick().equals("1")) {
                        sick18 = sick18 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence18 = absence18 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance18 = attendance18 + 1;
                    }
                }
                if (w==19) {
                    if (day.getSick().equals("1")) {
                        sick19 = sick19 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence19 = absence19 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance19 = attendance19 + 1;
                    }
                }
                if (w==20) {
                    if (day.getSick().equals("1")) {
                        sick20 = sick20 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence20 = absence20 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance20 = attendance20 + 1;
                    }
                }
                if (w==21) {
                    if (day.getSick().equals("1")) {
                        sick21 = sick21 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence21 = absence21 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance21 = attendance21 + 1;
                    }
                }
                if (w==22) {
                    if (day.getSick().equals("1")) {
                        sick22 = sick22 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence22 = absence22 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance22 = attendance22 + 1;
                    }
                }
                if (w==23) {
                    if (day.getSick().equals("1")) {
                        sick23 = sick23 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence23 = absence23 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance23 = attendance23 + 1;
                    }
                }
                if (w==24) {
                    if (day.getSick().equals("1")) {
                        sick24 = sick24 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence24 = absence24 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance24 = attendance24 + 1;
                    }
                }
                if (w==25) {
                    if (day.getSick().equals("1")) {
                        sick25 = sick25 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence25 = absence25 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance25 = attendance25 + 1;
                    }
                }
                if (w==26) {
                    if (day.getSick().equals("1")) {
                        sick26 = sick26 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence26 = absence26 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance26 = attendance26 + 1;
                    }
                }
                if (w==27) {
                    if (day.getSick().equals("1")) {
                        sick27 = sick27 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence27 = absence27 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance27 = attendance27 + 1;
                    }
                }
                if (w==28) {
                    if (day.getSick().equals("1")) {
                        sick28 = sick28 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence28 = absence28 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance28 = attendance28 + 1;
                    }
                }
                if (w==29) {
                    if (day.getSick().equals("1")) {
                        sick29 = sick29 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence29 = absence29 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance29 = attendance29 + 1;
                    }
                }
                if (w==30) {
                    if (day.getSick().equals("1")) {
                        sick30 = sick30 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence30 = absence30 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance30 = attendance30 + 1;
                    }
                }
                if (w==31) {
                    if (day.getSick().equals("1")) {
                        sick31 = sick31 + 1;
                    }
                    if (day.getAbsence().equals("1")) {
                        absence31 = absence31 + 1;
                    }
                    if (day.getAttendance().equals("1")) {
                        attendance31 = attendance31 + 1;
                    }
                }
            }
        }
        Sign_in1 sign_in1 = new Sign_in1();
        sign_in1.setAbasence(absence1);
        sign_in1.setAttendance(attendance1);
        sign_in1.setSick(sick1);
        list.add(sign_in1);

        Sign_in1 sign_in2 = new Sign_in1();
        sign_in2.setAbasence(absence2);
        sign_in2.setAttendance(attendance2);
        sign_in2.setSick(sick2);
        list.add(sign_in2);

        Sign_in1 sign_in3 = new Sign_in1();
        sign_in3.setAbasence(absence3);
        sign_in3.setAttendance(attendance3);
        sign_in3.setSick(sick3);
        list.add(sign_in3);

        Sign_in1 sign_in4 = new Sign_in1();
        sign_in4.setAbasence(absence4);
        sign_in4.setAttendance(attendance4);
        sign_in4.setSick(sick4);
        list.add(sign_in4);

        Sign_in1 sign_in5 = new Sign_in1();
        sign_in5.setAbasence(absence5);
        sign_in5.setAttendance(attendance5);
        sign_in5.setSick(sick5);
        list.add(sign_in5);

        Sign_in1 sign_in6 = new Sign_in1();
        sign_in6.setAbasence(absence6);
        sign_in6.setAttendance(attendance6);
        sign_in6.setSick(sick6);
        list.add(sign_in6);

        Sign_in1 sign_in7 = new Sign_in1();
        sign_in7.setAbasence(absence7);
        sign_in7.setAttendance(attendance7);
        sign_in7.setSick(sick7);
        list.add(sign_in7);

        Sign_in1 sign_in8 = new Sign_in1();
        sign_in8.setAbasence(absence8);
        sign_in8.setAttendance(attendance8);
        sign_in8.setSick(sick8);
        list.add(sign_in8);

        Sign_in1 sign_in9 = new Sign_in1();
        sign_in9.setAbasence(absence9);
        sign_in9.setAttendance(attendance9);
        sign_in9.setSick(sick9);
        list.add(sign_in9);

        Sign_in1 sign_in10 = new Sign_in1();
        sign_in10.setAbasence(absence10);
        sign_in10.setAttendance(attendance10);
        sign_in10.setSick(sick10);
        list.add(sign_in10);

        Sign_in1 sign_in11 = new Sign_in1();
        sign_in11.setAbasence(absence11);
        sign_in11.setAttendance(attendance11);
        sign_in11.setSick(sick11);
        list.add(sign_in11);

        Sign_in1 sign_in12 = new Sign_in1();
        sign_in12.setAbasence(absence12);
        sign_in12.setAttendance(attendance12);
        sign_in12.setSick(sick12);
        list.add(sign_in12);

        Sign_in1 sign_in13 = new Sign_in1();
        sign_in13.setAbasence(absence13);
        sign_in13.setAttendance(attendance13);
        sign_in13.setSick(sick13);
        list.add(sign_in13);

        Sign_in1 sign_in14 = new Sign_in1();
        sign_in14.setAbasence(absence14);
        sign_in14.setAttendance(attendance14);
        sign_in14.setSick(sick14);
        list.add(sign_in14);

        Sign_in1 sign_in15 = new Sign_in1();
        sign_in15.setAbasence(absence15);
        sign_in15.setAttendance(attendance15);
        sign_in15.setSick(sick15);
        list.add(sign_in15);

        Sign_in1 sign_in16 = new Sign_in1();
        sign_in16.setAbasence(absence16);
        sign_in16.setAttendance(attendance16);
        sign_in16.setSick(sick16);
        list.add(sign_in16);

        Sign_in1 sign_in17 = new Sign_in1();
        sign_in17.setAbasence(absence17);
        sign_in17.setAttendance(attendance17);
        sign_in17.setSick(sick17);
        list.add(sign_in17);

        Sign_in1 sign_in18 = new Sign_in1();
        sign_in18.setAbasence(absence18);
        sign_in18.setAttendance(attendance18);
        sign_in18.setSick(sick18);
        list.add(sign_in18);

        Sign_in1 sign_in19 = new Sign_in1();
        sign_in19.setAbasence(absence19);
        sign_in19.setAttendance(attendance19);
        sign_in19.setSick(sick19);
        list.add(sign_in19);

        Sign_in1 sign_in20 = new Sign_in1();
        sign_in20.setAbasence(absence20);
        sign_in20.setAttendance(attendance20);
        sign_in20.setSick(sick20);
        list.add(sign_in20);

        Sign_in1 sign_in21 = new Sign_in1();
        sign_in21.setAbasence(absence21);
        sign_in21.setAttendance(attendance21);
        sign_in21.setSick(sick21);
        list.add(sign_in21);

        Sign_in1 sign_in22 = new Sign_in1();
        sign_in22.setAbasence(absence22);
        sign_in22.setAttendance(attendance22);
        sign_in22.setSick(sick22);
        list.add(sign_in22);

        Sign_in1 sign_in23 = new Sign_in1();
        sign_in23.setAbasence(absence23);
        sign_in23.setAttendance(attendance23);
        sign_in23.setSick(sick23);
        list.add(sign_in23);

        Sign_in1 sign_in24 = new Sign_in1();
        sign_in24.setAbasence(absence24);
        sign_in24.setAttendance(attendance24);
        sign_in24.setSick(sick24);
        list.add(sign_in24);

        Sign_in1 sign_in25 = new Sign_in1();
        sign_in25.setAbasence(absence25);
        sign_in25.setAttendance(attendance25);
        sign_in25.setSick(sick25);
        list.add(sign_in25);

        Sign_in1 sign_in26 = new Sign_in1();
        sign_in26.setAbasence(absence26);
        sign_in26.setAttendance(attendance26);
        sign_in26.setSick(sick26);
        list.add(sign_in26);

        Sign_in1 sign_in27 = new Sign_in1();
        sign_in27.setAbasence(absence27);
        sign_in27.setAttendance(attendance27);
        sign_in27.setSick(sick27);
        list.add(sign_in27);

        Sign_in1 sign_in28 = new Sign_in1();
        sign_in28.setAbasence(absence28);
        sign_in28.setAttendance(attendance28);
        sign_in28.setSick(sick28);
        list.add(sign_in28);

        Sign_in1 sign_in29 = new Sign_in1();
        sign_in29.setAbasence(absence29);
        sign_in29.setAttendance(attendance29);
        sign_in29.setSick(sick29);
        list.add(sign_in29);

        Sign_in1 sign_in30 = new Sign_in1();
        sign_in30.setAbasence(absence30);
        sign_in30.setAttendance(attendance30);
        sign_in30.setSick(sick30);
        list.add(sign_in30);

        Sign_in1 sign_in31 = new Sign_in1();
        sign_in31.setAbasence(absence31);
        sign_in31.setAttendance(attendance31);
        sign_in31.setSick(sick31);
        list.add(sign_in31);
        return list;
    }
    @RequestMapping(value = "/finger_input")
    @ResponseBody
    public String finger_input(HttpSession session){                                                                    //指纹录入
        String a = (String) session.getAttribute("student_id");
        Login find = loginservice.findloginuser(a);
        finger_client finger_client = new finger_client();
        finger_c = null;
        int i = 1;
        while (i == 1){
            if (message != null){
                i = 2;
                System.out.println("i=2");
            }
            System.out.println("进入while循环！");
        }
        if (message.equals("flase")){
            String result1 = "指纹识别错误，请重试！";
            finger_c = null;
            return result1;
        }else{
            informationservice.inputFinger_id(find.getName(),message);
            String result2 = "指纹识别成功！";
            finger_c = "1";
            return result2;
        }
    }
    @RequestMapping(value = "/sick")
    public void sick(HttpSession session) {                                                                //请假
        try {
            /*Information in = informationservice.findsign("00f");
            System.out.println(in.getName());*/
            Information information = informationservice.finger_exist((String) session.getAttribute("student_id"));
            signservice.finger_sign(information.getName(), time.getTime(), "1", "0", "0");
        } catch(Exception e){
            System.out.println(e);
        }
    }
}
