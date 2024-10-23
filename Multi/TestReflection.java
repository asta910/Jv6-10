package com.demo.test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.demo.beans.Course;

public class TestReflection {

	public static void main(String[] args) {
		Course c=new Course("DAC",35000,250,200);
		Class cls=c.getClass();
		Constructor[] carr=cls.getConstructors();
		for(Constructor c1:carr) {
			System.out.println(c1.getParameterCount());
		}
		Method[] marr=cls.getMethods();
		Method mm=null;
		for(Method m:marr) {
			if(m.getName().equals("m1"))
				mm=m;
			System.out.println(m.getName());
			System.out.println(m.getParameterCount());
			
		}
		try {
			mm.invoke(c, 12);  //c.m1(12)
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Field[] farr=cls.getDeclaredFields();
		for(Field f:farr) {
			if(f.getName().equals("cname"))
				f.setAccessible(true);
			System.out.println(f.getName());
		}
		try {
			Field f=cls.getDeclaredField("cname");
			System.out.println("before changing");
			System.out.println(c);
			f.setAccessible(true);
			f.set(c,"xxxxx");//c.setCname("xxx")
			System.out.println("After changing");
			System.out.println(c);
		} catch (NoSuchFieldException | SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
