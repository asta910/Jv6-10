package com.demo.services;

import com.demo.dao.PersonInterface;
import com.demo.dao.PersonInterfaceImpl;

public class ServiceInterfaceImpl implements ServiceInterface{
    PersonInterface personInterface = new PersonInterfaceImpl();

    public void createStudent(){
        boolean create = personInterface.addStudent();
        if (create){
            System.out.println("Student added successfully..");
        }else{
            System.out.println("Operation failed");
        }
    }

    public void deleteStudent(){
        boolean del = personInterface.deleteStudent();
        if (del){
            System.out.println("Student deleted successfully..");
        }else{
            System.out.println("Operation failed");
        }
    }

    public void modifyMarks(){
        boolean mod = personInterface.modifyMarks();
        if (mod){
            System.out.println("Marks updated successfully..");
        }else{
            System.out.println("Operation failed");
        }
    }

    public void searchById(){
        boolean search = personInterface.searchById();
        if (!search){
            System.out.println("No such student exist..");
        }
    }

    public void displayByMarks(){
        personInterface.displayByMarks();
    }

    public void sortById(){
        personInterface.sortById();
    }

    public void sortByMarks(){
        personInterface.sortByMarks();
    }

    public void showAll(){
        personInterface.showAll();
    }

    public void sortByName(){
        personInterface.sortByName();
    }


}
