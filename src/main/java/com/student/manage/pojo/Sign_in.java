package com.student.manage.pojo;

public class Sign_in {
    private Integer id;
    private String name;
    private String sign_time;
    //private String finger_id;
    private String sick;
    private String attendance;
    private String absence;

    //public String getFinger_id() { return finger_id; }
    //public void setFinger_id(String finger_id) {this.finger_id = finger_id; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() {return name; }
    public void setName(String name) { this.name = name; }

    public String getSign_time() { return sign_time; }
    public void setSign_time(String sign_time) { this.sign_time = sign_time; }

    public String getAttendance() { return attendance; }
    public void setAttendance(String attendance) { this.attendance = attendance; }

    public String getSick() { return sick; }
    public void setSick(String sick) { this.sick = sick; }

    public String getAbsence() { return absence; }
    public void setAbsence(String absence) { this.absence = absence; }
}
