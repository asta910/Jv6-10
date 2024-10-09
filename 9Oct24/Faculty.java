package com.demo.beans;

import java.util.Arrays;

public class Faculty extends Person {
    private int sal;
    private String specialSubject;
    private String[] skills;

    public Faculty(String specialSubject, String[] skills, int sal) {
        this.specialSubject = specialSubject;
        this.skills = skills;
        this.sal = sal;
    }

    public Faculty(int id, String name, String address, String specialSubject, String[] skills, int sal) {
        super(id, name, address);
        this.specialSubject = specialSubject;
        this.skills = skills;
        this.sal = sal;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String[] getSkills() {
        return skills;
    }

    public void setSkills(String[] skills) {
        this.skills = skills;
    }

    public String getSpecialSubject() {
        return specialSubject;
    }

    public void setSpecialSubject(String specialSubject) {
        this.specialSubject = specialSubject;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "sal=" + sal +
                ", specialSubject='" + specialSubject + '\'' +
                ", skills=" + Arrays.toString(skills) +
                '}';
    }
}
