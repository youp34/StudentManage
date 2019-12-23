package com.student.manage.controller;

import com.student.manage.pojo.Information;
import com.student.manage.pojo.Login;
import com.student.manage.pojo.Sign_in;
import com.student.manage.service.InformationserviceImpl;
import com.student.manage.service.LoginserviceImpl;
import com.student.manage.service.NoticeserviceImpl;
import com.student.manage.service.SignserviceImpl;
import com.student.manage.tool.time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


@Controller
public class IndexController {
    @Autowired
    InformationserviceImpl informationservice;
    @Autowired
    LoginserviceImpl loginservice;
    @Autowired
    SignserviceImpl signservice;
    @Autowired
    NoticeserviceImpl noticeservice;

    time time = new time();
    @RequestMapping(value = "/index")
    public String index(Model model, HttpSession session){                                                              //首页
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        List people = informationservice.queryAll();
        model.addAttribute("sumpeople",people.size());             //实验室总人数
        List<Sign_in> list = signservice.queryAll();
        int attendance = 0;
        int absence = 0;
        int sick = 0;
        for (int i=0;i<list.size();i++){
            Sign_in day = list.get(i);
            time time = new time();
            String a = day.getSign_time();
            String[]  o = a.split("\\.");
            String[] ti = time.getTime().split("\\.");
            int w = Integer.parseInt(o[2]);
            int w1 = Integer.parseInt(o[1]);
            int x = Integer.parseInt(ti[1]);
            int r = Integer.parseInt(ti[2]);
            if (w1 == x && w == r) {
                if (day.getSick().equals("1")) {
                    sick = sick + 1;
                }
                if (day.getAttendance().equals("1")) {
                    attendance = attendance + 1;
                }
                if (day.getAbsence().equals("1")) {
                    absence = absence + 1;
                }
            }
        }
        model.addAttribute("attendance",attendance);
        model.addAttribute("sick",sick);
        model.addAttribute("absence",absence);
        String notice = noticeservice.find_notice();
        model.addAttribute("notice",notice);
        return "index";
    }
    @RequestMapping(value = "/tables",method = RequestMethod.GET)
    public String tables(Model model,HttpSession session){                                                              //实验室成员
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        List<Information> list = informationservice.queryAll();
         model.addAttribute("list",list);         //遍历前端页面
        return"tables";
    }
    @RequestMapping(value = "/calendar",method = RequestMethod.GET)
    public String calendar(HttpSession session,Model model){                                                            //我的出勤
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        List<Sign_in> list = signservice.queryAll();
        int sick = 0;
        int attendance = 0;
        int absence = 0;
        List<Sign_in> list1=new ArrayList<>();
        String q = time.getTime();
        String[] w = q.split("\\.");
        for (int i = 0; i<list.size();i++){                                                  //今日出勤
            String[] l = list.get(i).getSign_time().split("\\.");
            if (list.get(i).getName().equals(name) && w[2].equals(l[2])){
               String time = list.get(i).getSign_time();
                String[]  tim = time.split("\\.");
                String  a = tim[3]+":"+tim[4];
                Sign_in sign_in = new Sign_in();
                sign_in.setAbsence(list.get(i).getAbsence());
                sign_in.setAttendance(list.get(i).getAttendance());
                sign_in.setName(list.get(i).getName());
                sign_in.setSick(list.get(i).getSick());
                sign_in.setSign_time(a);
                list1.add(sign_in);
            }
        }
        model.addAttribute("list1",list1);
        int attendance_month = 0;
        int sick_month = 0;
        int absence_month = 0;
        for (int i = 0; i<list.size();i++){                                                   //本月出勤次数
            String  ti = time.getTime();
            String[]  tim = ti.split("\\.");
            String[] temp = list.get(i).getSign_time().split("\\.");
            if (temp[1].equals(tim[1]) && list.get(i).getName().equals(name)){
                if (list.get(i).getAbsence().equals("1")){
                    absence_month = absence_month + 1;
                }
                if (list.get(i).getAttendance().equals("1")){
                    attendance_month = attendance_month + 1;
                }
                if (list.get(i).getSick().equals("1")){
                    sick_month = sick_month + 1;
                }
            }
        }
        model.addAttribute("absence_month",absence_month);
        model.addAttribute("sick_month",sick_month);
        model.addAttribute("attendance_month",attendance_month);
        return"calendar";
    }
    @RequestMapping(value = "/chart",method = RequestMethod.GET)
    public String chart(HttpSession session,Model model){                                                               //实验室出勤
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return "chart";
    }
    @RequestMapping(value = "/table-list",method = RequestMethod.GET)
    public String tablelist(HttpSession session,Model model){                                                           //修改资料
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return"table-list";
    }
    @RequestMapping(value = "/table-list",method = RequestMethod.POST)
    public String post_tablelist(HttpSession session,Model model,@RequestParam("college")String college,@RequestParam("classes")String classes,@RequestParam("telephonenumber")String telephonenumber){
        String sess = (String) session.getAttribute("student");
        Login login = loginservice.findloginuser(sess);        //通过student_id 查询数据库表
        String name = login.getName();
        informationservice.updatestudent(name,classes,sess,college,telephonenumber);
        model.addAttribute("editer","修改成功！");
        return "table_list";
    }
    @RequestMapping(value = "/table-list-img",method = RequestMethod.GET)
    public String tablelistimg(HttpSession session,Model model){                                                        //修改密码
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/

        return"table-list-img";
    }
    @RequestMapping(value = "/video",method = RequestMethod.GET)
    public String video(HttpSession session,Model model){                                                               //空白页
        String student_id = (String) session.getAttribute("student_id");   //通过session获得Email
        Login login = new Login();
        login = loginservice.findloginuser(student_id);        //通过student_id 查询数据库表
        String name = login.getName();                    //获取name
        model.addAttribute("name",name);
        model.addAttribute("email",student_id);
        /*------------表格操作---------------*/
        return"404";
    }
}
