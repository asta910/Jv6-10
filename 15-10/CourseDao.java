package com.demo.dao;


import com.demo.bean.Course;

import java.util.Map;

public interface CourseDao {
    boolean addCourse(String cname, Course c);
    Map<String,Course> displayAll();
    Course findCourse(String s);
    void deleteCourse(String n,Course course);
    Course findByName(String s);

    Map<String, Course> findByDur(int duration);
}
