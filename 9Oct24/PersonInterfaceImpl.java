package com.demo.dao;

import com.demo.beans.Graduation;
import com.demo.beans.Masters;
import com.demo.beans.Person;
import com.demo.beans.Student;

import java.util.*;

public class PersonInterfaceImpl implements PersonInterface{
    static List<Person> personArray;
    Scanner sc = new Scanner(System.in);

    static{
        personArray = new ArrayList<>();
        personArray.add(new Graduation(2,"Omen","LA Galaxy",new int[]{80,90,90},99));
        personArray.add(new Masters(3,"Rock","Jamaica",new int[]{81,59,70},"WWE",84));

        personArray.add(new Graduation(4,"Devid Beckham","Manchester",new int[]{91,81,91},78));
        personArray.add(new Masters(1,"Krishna Ronaldo","Madira",new int[]{99,99,40},"Football",99));
    }

    //1 add student
    public boolean addStudent(){
        System.out.println("Enter which type of student you want to add : ");
        System.out.println("1. Graduation \n2. Masters \n3. get back");
        System.out.print("Enter you choice : ");
        int choice = sc.nextInt();

        if(choice == 1){
            System.out.print("Enter id : ");
            int gid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter student name : ");
            String gName = sc.nextLine();
            System.out.println("Enter student address : ");
            String gAddress = sc.nextLine();

            System.out.print("Enter marks for subject 1 : ");
            int m1 = sc.nextInt();
            System.out.print("Enter marks for subject 2 : ");
            int m2 = sc.nextInt();
            System.out.print("Enter marks for subject 3 : ");
            int m3 = sc.nextInt();
            int[] m = {m1,m2,m3};

            System.out.print("Enter special subject marks : ");
            int gssub = sc.nextInt();
            personArray.add(new Graduation(gid,gName,gAddress,m,gssub));
            return true;
        }else if(choice == 2){
            System.out.print("Enter id : ");
            int gid = sc.nextInt();
            sc.nextLine();
            System.out.println("Enter student name : ");
            String gName = sc.nextLine();
            System.out.println("Enter student address : ");
            String gAddress = sc.nextLine();

            System.out.print("Enter marks for subject 1 : ");
            int m1 = sc.nextInt();
            System.out.print("Enter marks for subject 2 : ");
            int m2 = sc.nextInt();
            System.out.print("Enter marks for subject 3 : ");
            int m3 = sc.nextInt();
            int[] m = {m1,m2,m3};
            sc.nextLine();
            System.out.print("Enter thesis subject Name : ");
            String mtsub = sc.nextLine();
            System.out.print("Enter thesis subject marks : ");
            int gssub = sc.nextInt();
            personArray.add(new Masters(gid,gName,gAddress,m,mtsub,gssub));
            return true;
        }
        return false;
    }

    //2 delete student
    public boolean deleteStudent(){
        System.out.print("Enter id of student you want to delete : ");
        int id = sc.nextInt();

        for(int i =0; i < personArray.size(); i++){
            if(personArray.get(i).getId() == id){
                personArray.remove(personArray.get(i));
            }
            return true;
        }
        return false;
    }

    //3 modify marks
    public boolean modifyMarks(){
        System.out.print("Enter id of student who's marks you want to modify : ");
        int gid = sc.nextInt();

        System.out.print("Enter updated marks for subject 1 : ");
        int m1 = sc.nextInt();
        System.out.print("Enter updated marks for subject 2 : ");
        int m2 = sc.nextInt();
        System.out.print("Enter updated marks for subject 3 : ");
        int m3 = sc.nextInt();
        int[] m = {m1,m2,m3};

        for(int i =0; i < personArray.size(); i++){
            if(personArray.get(i).getId() == gid){
                ((Student) personArray.get(i)).setMarks(m);
            }
            return true;
        }
        return false;
    }
    
    //4 searcg by id
    public boolean searchById(){
        System.out.print("Enter id of student : ");
        int gid = sc.nextInt();

        for(int i =0; i < personArray.size(); i++){
            if(personArray.get(i).getId() == gid){
                System.out.println(personArray.get(i));
                return true;
            }
        }
        return false;
    }

    //5 display marks
    public void displayByMarks(){
        System.out.println("how many students got marks above, .... out of 300 ? ");
        int minMarks = sc.nextInt();

        for(int i =0; i < personArray.size(); i++){

            int id = personArray.get(i).getId();
            String name = personArray.get(i).getName();

            int[] marks = ((Student) personArray.get(i)).getMarks();
            int sum = 0;
            for(int m : marks) sum+= m;

            if( sum >= minMarks){
                System.out.println(id + ". " + name + " maths : " +  marks[0] + " science : " + marks[1] + " english : " + marks[2]  + " total : " + sum);
            }
        }
    }

    //6 sort by id
    public void sortById(){
       int[] marks = new int[personArray.size()];
       for (int i = 0; i < marks.length; i++){
           int id = personArray.get(i).getId();
           marks[i] = id;
       }
       for (int i =0; i < personArray.size(); i++){
           int maxIndex = i;
           int maxval = marks[i];

           for (int j = 0; j < marks.length - i; j++){
               if(maxval < marks[j]){
                   maxIndex = j;
                   maxval = marks[j];
               }
           }
           int temp = marks[maxIndex];
           marks[maxIndex] = marks[marks.length - i - 1];
           marks[marks.length - i - 1] = temp;

           Person tempPerson = personArray.get(maxIndex);
           personArray.set(maxIndex, personArray.get(i));
           personArray.set(i,tempPerson);
       }
       Collections.reverse(personArray);
       showAll();
    }


    //7. Sort by name
    public void sortByName(){
        int[] names = new int[personArray.size()];
        String maxCharz = "AAAAAAAAAAA";
        for (int i = 0; i < names.length; i++) {
            String currentname = personArray.get(i).getName();
            int value = currentname.compareTo(maxCharz);
            names[i] = value;
        }

        for (int i = 0; i < personArray.size(); i++) {
            int maxIndex = i;

            for (int j = i + 1; j < names.length; j++) {
                if (names[j] > names[maxIndex]) {
                    maxIndex = j;
                }
            }

            int tempMark = names[maxIndex];
            names[maxIndex] = names[i];
            names[i] = tempMark;

            Person tempPerson = personArray.get(maxIndex);
            personArray.set(maxIndex, personArray.get(i));
            personArray.set(i, tempPerson);
        }
        Collections.reverse(personArray);
        showAll();
    }

    //8 sort by marks
    public boolean sortByMarks() {
        int[] marks = new int[personArray.size()];

        for (int i = 0; i < marks.length; i++) {
            int[] currentMarks = ((Student) personArray.get(i)).getMarks();
            int marksSum = 0;

            for (int m : currentMarks) {
                marksSum += m;
            }
            marks[i] = marksSum;
        }

        for (int i = 0; i < personArray.size(); i++) {
            int maxIndex = i;

            for (int j = i + 1; j < marks.length; j++) {
                if (marks[j] > marks[maxIndex]) {
                    maxIndex = j;
                }
            }

            int tempMark = marks[maxIndex];
            marks[maxIndex] = marks[i];
            marks[i] = tempMark;

            Person tempPerson = personArray.get(maxIndex);
            personArray.set(maxIndex, personArray.get(i));
            personArray.set(i, tempPerson);
        }
        showAll();
        return true;
    }

    //10. showAll
    public void showAll(){
        for (Person p : personArray){
            System.out.println(p);
        }
    }
}
