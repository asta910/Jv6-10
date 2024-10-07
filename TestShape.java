package com.demo.test;
import java.util.Scanner;

public class TestShape {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        for(int i=0;i<10;i++){
            System.out.println("1.Triangle \n 2.Circle \n 3.Rectangle \n 4.Exit");
            int choice = 0;
            choice = sc.nextInt();
            switch (choice){
                case 1:

                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    break;
            }
        }
        sc.close();
    }

}
