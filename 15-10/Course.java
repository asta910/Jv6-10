package com.demo.bean;

import java.util.Arrays;
import java.util.Objects;

public class Course {
    private int cid;
    private String cname;
    private double fees;
    private int capacity;
    private int duration;
    private String[] facultyNames;
    private String[] modules;

    private static int generateId() {
        int num = (int) (Math.random() * 1000000) % 100000;
        return num;
    }

    public Course(){}
    public Course(String c,double f,int cap,int dur,String[] fcn,String[] mod){
        this.cid = generateId();
        this.cname = c;
        this.fees = f;
        this.capacity = cap;
        this.duration = dur;
        this.facultyNames = fcn;
        this.modules = mod;
    }

    public double getFees() {
        return fees;
    }

    public void setFees(double fees) {
        this.fees = fees;
    }

    public int getCid() {
        return cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String[] getFacultyNames() {
        return facultyNames;
    }

    public void setFacultyNames(String[] facultyNames) {
        this.facultyNames = facultyNames;
    }

    public String[] getModules() {
        return modules;
    }

    public void setModules(String[] modules) {
        this.modules = modules;
    }

    @Override
    public String toString() {
        return  "course Id " + this.cid  +
                " course name : '" + cname +
                  '\'' +
                ", fees : " + fees +
                ", capacity : " + capacity +
                ", duration : " + duration +
                ", facultyNames : " + Arrays.toString(facultyNames) +
                ", modules : " + Arrays.toString(modules);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Course course = (Course) o;
        return Objects.equals(cname, course.cname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cname);
    }
}
