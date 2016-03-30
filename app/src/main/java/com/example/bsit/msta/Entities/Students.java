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
    private int    mImageId;


    public Students( String name, String course, String password ,int mImageId) {
        this.mImageId = mImageId;
        this.name = name;
        this.password = password;
        this.course = course;
    }

    public Students(String name, String course, int mImageId) {
        this.name = name;
        this.mImageId = mImageId;
        this.course = course;
    }

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


    public int getmImageId() {
        return mImageId;
    }

    public void setmImageId(int mImageId) {
        this.mImageId = mImageId;
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



    public Students setImageId(int imageId) {
        mImageId = imageId;
        return this;
    }
    public Students setStudentListCourse(String mCourse) {
        course = mCourse;
        return this;
    }
    public Students setStudentListName(String mName) {
        name = mName;
        return this;
    }

    public Students setSchedule(String sched) {
        password = sched;
        return this;
    }



}
