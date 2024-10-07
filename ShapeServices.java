package com.demo.services;
import com.demo.beans.Circle;
import com.demo.beans.Rectangle;
import com.demo.beans.Shape;
import com.demo.beans.Triangle;

import java.util.Scanner;

public class ShapeServices {
    static Shape[] sarr;
    static int cnt;

    static{
        sarr = new Shape[10];
        cnt =0;
    }

    public static void addData(int choice)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter color: ");
        switch(choice){
            case 1:
                System.out.println("Enter base: ");
                int b = sc.nextInt();
                System.out.println("Enter height: ");
                int h = sc.nextInt();
                System.out.println("Enter s1: ");
                int s1 = sc.nextInt();
                System.out.println("Enter s2: ");
                int s2 = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter color : ");
                String color = sc.nextLine();
                sarr[cnt] = new Triangle(color,b,h,s1,s2);
                break;

            case 2:
                System.out.println("Enter radius: ");
                int r = sc.nextInt();
                System.out.println("Enter color : ");
                color = sc.nextLine();
                sarr[cnt] = new Circle(color,r);
                break;

            case 3:
                System.out.println("Enter length: ");
                int l = sc.nextInt();
                System.out.println("Enter breadth: ");
                int br = sc.nextInt();
                System.out.println("Enter color : ");
                 color = sc.nextLine();
                sarr[cnt] = new Rectangle(color,l,br);
                break;

            default:
                break;
        }
        cnt++;
    }
    public static void ShapeDetails(int pos){
        System.out.println(sarr[pos].calcArea());
        System.out.println(sarr[pos].calcParameter());

    }

    public static Shape[] getAllShapes(){
        return sarr;
    }


    }
