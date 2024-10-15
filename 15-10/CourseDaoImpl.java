package com.demo.dao;
import com.demo.bean.Course;

import java.util.HashMap;
import java.util.Map;
public class CourseDaoImpl implements CourseDao{
    static Map<String, Course> map;
    static {
        map= new HashMap<>();
        map.put("CS",new Course("CS",60000.23,75,230,new String[] {"Yogita","daku"},new String[] {"M1","CS","M2","M3","SNS","AI","ML"}));
        map.put("IT",new Course("IT",50000.00,60,210,new String[] {"Omen","someone","everyone"},new String[] {"OS","ML","DL","TOC","IOT","M1","M2","M3","PA"} ));
        map.put("MAC",new Course("MAC",40000.23,50,230,new String[] {"James","Soily"},new String[] {"M1","CAR","M2","M3","BIKE","Robo","MECH-T"}));
        map.put("ENTC",new Course("ENTC",50000.00,60,210,new String[] {"Rock","Asta","Naruto"},new String[] {"Electronics","Modeling","Circuits","Embedded","IOT","M1","M2","M3","HardWare"} ));
    }

    public boolean addCourse(String cname,Course c){
        map.put(cname,c);
        return true;
    }

    public Course findByName(String s){
        return map.get(s);
    }


    public Map<String, Course> findByDur(int duration) {
        Map<String,Course> ans = new HashMap<>();

    }


    public Map<String, Course> displayAll() {
        return map;
    }
    public Course findCourse(String s){
        Course cours = map.get(s);
        return cours;
    }

    public void deleteCourse(String nm,Course course) {
        map.remove(nm,course);
    }


}
