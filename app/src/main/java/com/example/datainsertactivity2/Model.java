package com.example.datainsertactivity2;

public class Model {
    String ID1,Name,Email,Mobile_No,DOB,Password;

    public Model(String ID1, String name, String email, String mobile_No, String DOB, String password) {
        this.ID1=ID1;
        Name = name;
        Email = email;
        Mobile_No = mobile_No;
        this.DOB = DOB;
        Password = password;
    }

    public String getID1() {
        return ID1;
    }

    public void setID1(String ID1) {
        this.ID1 = ID1;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getMobile_No() {
        return Mobile_No;
    }

    public void setMobile_No(String mobile_No) {
        Mobile_No = mobile_No;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
