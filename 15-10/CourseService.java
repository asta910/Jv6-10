package com.demo.service;

public interface CourseService {
    boolean addCourse(String nm,double dd,int cap, int dur,String[] arf,String[] arm);
    void displayAll();
    boolean deleteCourse(String nm, int id);
    boolean searchByName(String courseName);
    boolean updateCourse(char ch,int i,String c);
    boolean updateCourseString(char ch,String[] arr,String s);

    void displayBasedOnDur(int d);
}
