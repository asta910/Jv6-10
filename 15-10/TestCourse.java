package com.demo.test;

import com.demo.service.CourseService;
import com.demo.service.CourseServiceImpl;

import java.util.Scanner;

public class TestCourse{
    public static void main(String[] args) {
        CourseService courseService = new CourseServiceImpl();

        System.out.println("Welcome to NEDVED Academy.........");

        int choice =0;
        Scanner sc = new Scanner(System.in);

        while(choice!=12){
            System.out.println("1. Add new course \n2. Delete Course \n3. Update Course \n4. Display All \n5. Display by name \n6. Display based on duration \n7. Display course name in sorted order \n8. Display in sorted order of duration \n9. Sort by fees \n10. Show faculty name \n11. Show modules \n12. Exit..");
            System.out.print("Enter your choice : ");
            choice = sc.nextInt();

            switch(choice){

                case 1 -> {
                    System.out.println("Enter your course name : ");
                    String cname = sc.next();
                    System.out.println("Enter course fees : ");
                    double fees = sc.nextDouble();
                    System.out.println("Enter course capacity : ");
                    int cap = sc.nextInt();
                    System.out.println("Enter course duration : ");
                    int dur = sc.nextInt();
                    System.out.println("How many faculties do you want to add? ");
                    int n = sc.nextInt();
                    String[] farr = new String[n];
                    for (int i=0;i<n;i++){
                        farr[i] = sc.next();
                    }
                    System.out.println("How many subjects do you want to add? ");
                    n = sc.nextInt();
                    String[] sarr = new String[n];
                    for (int i=0;i<n;i++){
                        sarr[i] = sc.next();
                    }
                    boolean res = courseService.addCourse(cname,fees,cap,dur,farr,sarr);
                    if(res){
                        System.out.println("Course added successfully");
                    }
                    else{
                        System.out.println("Operation failed..");
                    }

                }
                case 2 -> {
                    System.out.println("Enter Course name");
                    String nm = sc.next();
                    System.out.println("Enter course id");
                    int id = sc.nextInt();
                    boolean res=courseService.deleteCourse(nm,id);
                    if (res){
                        System.out.println("Course deleted successfully");
                    }else{
                        System.out.println("Operation failed..");
                    }
                }
                case 3 -> {
                    System.out.println("Enter name of course you want to update");
                    String cn = sc.next();
                    System.out.println("1. Course duration \n2. Course fees \n3. Course Faculty \n4. Course modules \n5. Course capacity");
                    int updation = sc.nextInt();
                    boolean ans = false;
                    if (updation == 1){
                        System.out.println("Enter new duration : ");
                        int new_dur = sc.nextInt();
                        ans = courseService.updateCourse('D',new_dur ,cn);
                    }
                    else if (updation == 2){
                        System.out.println("Enter new fees : ");
                        int new_dur = sc.nextInt();
                        ans = courseService.updateCourse('F',new_dur ,cn);
                    }
                    else if (updation == 3){
                        System.out.println("Enter how many faculties you want to add : ");
                        int n = sc.nextInt();
                        String[] arr = new String[n] ;
                        for(int i=0;i<n;i++){
                            int num = i+1;
                            System.out.println("Enter" +  num  + "faculty name");
                            arr[i] = sc.next();
                        }
                        ans = courseService.updateCourseString('F',arr ,cn);
                    }
                    else if (updation == 4){
                        System.out.println("Enter how many Course Modules you want to add : ");
                        int n = sc.nextInt();
                        String[] arrm = new String[n] ;
                        for(int i=0;i<n;i++){
                            int num = i+1;
                            System.out.println("Enter " + num +" module name ");
                            arrm[i] = sc.next();
                        }
                        ans = courseService.updateCourseString('M',arrm ,cn);
                    }
                    else if (updation == 5){
                        System.out.println("Enter new course capacity : ");
                        int cap = sc.nextInt();
                        ans = courseService.updateCourse('F',cap ,cn);
                    }
                    if (ans){
                        System.out.println("Operation Successfull....");
                    }else{
                        System.out.println("Operation failed..");
                    }
                }

                case 4 -> {
                    courseService.displayAll();
                }
                case 5 -> {
                    System.out.println("Enter name of course you want to search ? ");
                    String courseName = sc.next();
                    boolean res = courseService.searchByName(courseName);
                    if (!res){
                        System.out.println("No such course found");
                    }
                }
                case 6 -> {
                    System.out.println("Enter minimum duration : ");
                    int duration = sc.nextInt();
                    boolean res = courseService.displayBasedOnDur(duration);
                    if (!res){
                        System.out.println("Operation failed..");
                    }
                }
                case 7 -> {}
                case 8 -> {}
                case 9 -> {}
                case 10 -> {}
                case 11 -> {}
                default -> {}


            }
        }
    }
}
