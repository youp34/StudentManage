package com.student.manage.pojo;

public class Information {
    private Integer id;
    private String name;
    private String student_id;
    private String classes;
    private String college;
    private String phonenumber;
    private String finger_id;

    public String getClasses() { return classes; }
    public void setClasses(String classes) { this.classes = classes; }

    public String getCollege() { return college; }
    public void setCollege(String college) { this.college = college; }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPhonenumber() { return phonenumber; }
    public void setPhonenumber(String phonenumber) { this.phonenumber = phonenumber; }

    public String getStudent_id() { return student_id; }
    public void setStudent_id(String student_id) { this.student_id = student_id; }

    public String getFinger_id() { return finger_id; }
    public void setFinger_id(String finger_id) { this.finger_id = finger_id; }
}
