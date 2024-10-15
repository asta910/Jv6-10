package com.demo.service;

import com.demo.bean.Course;
import com.demo.dao.CourseDao;
import com.demo.dao.CourseDaoImpl;

import java.util.Arrays;
import java.util.Map;

public class CourseServiceImpl implements CourseService{

    public CourseDao courseDao;

    public CourseServiceImpl(){
        courseDao = new CourseDaoImpl();
    }

    //1. add course
    public boolean addCourse(String nm,double dd,int cap, int dur,String[] arf,String[] arm) {
        Course cs = new Course(nm,dd,cap,dur,arf,arm);
        return courseDao.addCourse(nm,cs);
    }

    //2. delete
    public boolean deleteCourse(String nm, int id) {
        Course course = courseDao.findCourse(nm);
        if (course.getCid() == id){
            courseDao.deleteCourse(nm,course);
            return true;
        }
        return false;
    }

    //3 update course
    public boolean updateCourse(char ch,int i,String s){
        Course course = courseDao.findCourse(s);
        if (ch == 'D'){
            course.setDuration(i);
            return true;
        }else if(ch == 'F'){
            course.setFees(i);
            return true;
        } else if (ch == 'C') {
            course.setCapacity(i);
            return true;
        }
        return false;
    }
    public boolean updateCourseString(char ch,String[] arr,String s){
        Course course = courseDao.findCourse(s);
        if (ch == 'F'){
            String[] faculty = course.getFacultyNames();
            String[] result = new String[faculty.length+arr.length];
            for (int i =0; i < faculty.length;i++){
                result[i]=faculty[i];
            }
            int ct = 0;
            for (int i = faculty.length; i < faculty.length + arr.length;i++){
                result[i]=arr[ct++];
            }
            course.setFacultyNames(result);
            return true;
        } else if (ch=='M') {
            String[] module = course.getModules();
            String[] result = new String[module.length+arr.length];

            for (int i =0; i < module.length;i++){
                result[i]=module[i];
            }
            int ct = 0;
            for (int i = module.length; i < module.length + arr.length;i++){
                result[i]=arr[ct++];
            }
            course.setModules(result);
            return true;
        }
        return false;
    }

    @Override
    public void displayBasedOnDur(int duration) {
        Map<String,Course> map = courseDao.findByDur(duration);

    }


    //4. display all
    public void displayAll(){
        Map<String,Course> map = courseDao.displayAll();
        int count = 1;

        for (Map.Entry<String,Course> entry : map.entrySet()){
            System.out.println(count + ". " +  entry.getValue());
            count++;
        }
    }

    //5
    public boolean searchByName(String courseName){
        Course course = courseDao.findByName(courseName);
        if (course != null){
            System.out.println(course);
            return true;
        }
        return false;
    }




}
