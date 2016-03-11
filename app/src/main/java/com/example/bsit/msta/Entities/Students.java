package com.example.bsit.msta.Entities;

/**
 * Created by BSIT on 3/10/2016.
 */
public class Students  {
    private String name;
    private String password;
    private String id;
    private String course;
    private String advisor;
    private String yearLevel;


//    public Students(String name, String password, String id, String string, String cursorString, String s) {
//        this.name = name;
//        this.password = password;
//        this.id = id;
//        this.course = course;
//        this.advisor = advisor;
//        this.yearLevel = yearLevel;
//
//    }


    public Students(String name, String password, String id, String course, String advisor, String yearLevel) {
        this.name = name;
        this.password = password;
        this.id = id;
        this.course = course;
        this.advisor = advisor;
        this.yearLevel = yearLevel;
    }


    public Students() {
    }

    public Students(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAdvisor() {
        return advisor;
    }

    public void setAdvisor(String advisor) {
        this.advisor = advisor;
    }

    public String getYearLevel() {
        return yearLevel;
    }

    public void setYearLevel(String yearLevel) {
        this.yearLevel = yearLevel;
    }

}
