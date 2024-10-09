package com.demo.test;

import com.demo.services.ServiceInterface;
import com.demo.services.ServiceInterfaceImpl;

import java.util.Scanner;

public class TestPerson {
    public static void main(String[] args) {
        ServiceInterface serviceInterface = new ServiceInterfaceImpl();

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to NEDVED School..");
        int choice = 0;

        while (choice != 11){
            System.out.println("1. Add new student \n2. Delete student \n3. Update marks \n4. Search by id \n5. Display students with marks more than \n6. Sort by id \n7. Sort by name \n8. Sort by marks \n9. Search by name & sorted order \n10. Display all \n11. Exit..");
            System.out.print("Select your choice : ");
            choice = sc.nextInt();

            switch (choice){
                case 1:
                    serviceInterface.createStudent();
                    break;
                case 2:
                    serviceInterface.deleteStudent();
                    break;

                case 3:
                    serviceInterface.modifyMarks();
                    break;

                case 4:
                    serviceInterface.searchById();
                    break;

                case 5:
                    serviceInterface.displayByMarks();
                    break;

                case 6:
                    serviceInterface.sortById();
                    break;

                case 7:
                    serviceInterface.sortByName();
                    break;

                case 8:
                    serviceInterface.sortByMarks();
                    break;

                case 9:

                    break;

                case 10:
                    serviceInterface.showAll();
                    break;
                default:
                    System.out.println("Only 11 options available, invalid choice..");
                    break;
            }
        }
    }
}
