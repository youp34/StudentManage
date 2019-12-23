package com.student.manage.pojo;

public class Login {
    private int id;
    private String student_id;
    private String password;
    private String name;
    private String permission;

    public String getStudent_id() { return student_id; }
    public void setStudent_id(String student_id) { this.student_id = student_id; }

    public int  getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getPermission() { return permission; }
    public void setPermission(String permission) { this.permission = permission; }
}
