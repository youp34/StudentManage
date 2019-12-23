package com.student.manage.socket;

import com.student.manage.pojo.Information;
import com.student.manage.service.InformationserviceImpl;
import com.student.manage.service.SignserviceImpl;
import com.student.manage.tool.time;

import java.io.*;
import java.net.Socket;

public class finger_client {
     public static String  messe ;
     public static String finger_c;
     public static String message;
    public static void main(String[] args) {
        try {
            InformationserviceImpl informationservice = new InformationserviceImpl();
            time time = new time();
            SignserviceImpl signservice = new SignserviceImpl();
            while (true){
            /*String finger_c = finger_mess.getFinger_c();*/
            String mess = null;
            Socket s = new Socket("192.168.137.217",6666);
            System.out.println("--------------------------------------");
            //构建IO
            InputStream is = s.getInputStream();
            OutputStream os = s.getOutputStream();
            if (finger_c == null){
                finger_c = "0";
            }else{
                finger_c = "1";
            }
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
                //向服务器端发送一条消息
            bw.write(finger_c);
            bw.flush();
            //读取服务器返回的消息
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            mess = br.readLine();
            System.out.println("指纹："+mess);
            if (finger_c.equals("1")){
                if (mess.equals("flase")){
                    //指纹识别失败签到失败
                    System.out.println("签到失败！");
                }else{
                    //存入数据库
                    //Information information = informationservice.findsign(mess);
                    signservice.finger_sign(informationservice.findsign(mess).getName(),time.getTime(),"0", "0", "1");
                }
            } else{
                message = mess;

            }
            //finger_c = null;
            }
        }  catch (IOException e) {
            e.printStackTrace();
            e.printStackTrace();
        }
    }
}