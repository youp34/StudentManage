package com.student.manage.tool;

import java.util.Calendar;
import java.util.Date;

public class time {
    public String getTime() {
        String[] weeks = new String[] { "1","2","3","4","5","6","7" };
        Calendar c = Calendar.getInstance();//可以用set()对每个时间域单独修改
        int year = c.get(Calendar.YEAR);
//一般month都需要+1才表示当前月份
        int month = c.get(Calendar.MONTH);
        month = month + 1;
        int date = c.get(Calendar.DATE);
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        //int second = c.get(Calendar.SECOND);
        int weekly = c.getFirstDayOfWeek();
        c.set(Calendar.DAY_OF_MONTH, date);
        int weekday = c.get(Calendar.DAY_OF_WEEK)-1;
        String nowTime = year + "." + month + "."+ date + "."+ hour + "."+ minute + "."+ weekday;
        //System.out.println(nowTime);
        return nowTime;
    }
    public static void main(String[] args) {
        time a = new time();
        String s = a.getTime();
        String[] b = s.split("\\.");
        System.out.println(b[3]+b[4]);
        System.out.println(s);
    }
}