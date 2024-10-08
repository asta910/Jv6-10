package com.demo.interfaces;
import java.util.Scanner;

public class AccountImpl implements AccountInterface{
    Scanner sc = new Scanner(System.in);
    static Accounts[] accounts;
    static int count;


    static {
        accounts = new Accounts[100];
        count = 0;
        accounts[count++] = new Accounts(1,"Omen",99000,1234);
        accounts[count++] = new Accounts(2,"Breach",122000,7890);
        accounts[count++] = new Accounts(3,"Reyna",39000,1111);
        accounts[count++] = new Accounts(4,"Asta",11111,4321);
    }
    //1. add account
    public boolean addNewAccount(){
        System.out.println("Enter Id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter Name : ");
        String name = sc.nextLine();
        System.out.println("Enter Balance : ");
        int balance = sc.nextInt();
        System.out.println("Enter Pin : ");
        int pin = sc.nextInt();
        accounts[count++] = new Accounts(id,name,balance,pin);
        if (accounts[count - 1].getId() == id){
            return true;
        }
        return false;
    }

    //2. show balance
    public void showBalance() {
        System.out.print("Enter id: ");
        int id  = sc.nextInt();
        int index = findPosition(id);

        if(index == -1){
            System.out.println("Wrong id, No such account with this id ");
            return;
        }

        System.out.print("Enter pin :");
        int pin = sc.nextInt();
        int res = -1;
        if(accounts[index].getPin() == pin){
            res = accounts[index].getBalance();
        }

        if(res != -1){
            System.out.println("Balance is : " + res);
        }else{
            System.out.println("Wrong PINNN...");
        }
    }

    //3. withdraw
    public boolean withdrawMoney(){
        System.out.print("Enter id : ");
        int id = sc.nextInt();
        int index = findPosition(id);
        if (index == -1){
            System.out.println("Invalid id");
            return false;
        }
        System.out.print("Enter pin : ");
        int pin  = sc.nextInt();
        if(accounts[index].getPin() == pin){
            System.out.print("Enter the amount you want to withdraw : ");
            int withdraw = sc.nextInt();
            int curr = accounts[index].getBalance();
            if(curr - withdraw > Accounts.getMinBalance()){
                accounts[index].setBalance(curr-withdraw);
                return true;
            }else{
                System.out.println("Insufficient balance..");
                return false;
            }
        }

        return false;
    }

    //4. transfer money
    public boolean fundTransfer(){
        System.out.print("Enter your : ");
        int myId = sc.nextInt();
        int index = findPosition(myId);
        if (index == -1){
            System.out.println("Invalid id");
            return false;
        }
        System.out.print("Enter your pin : ");
        int yourPin  = sc.nextInt();
        if(accounts[index].getPin() == yourPin) {
            System.out.print("Enter the amount you want to transfer : ");
            int transfer = sc.nextInt();
            int current = accounts[index].getBalance();

            if(current-transfer>Accounts.getMinBalance()){
                System.out.println("Enter id of the person you want to transfer money : ");
                int idnew = sc.nextInt();
                int index1=findPosition(idnew);
                if(index1 != -1){
                    int res = accounts[index1].getBalance()+transfer;
                    accounts[index1].setBalance(res);
                    return true;
                }else{
                    System.out.println("No other user with this id ");
                }
            }
        }
        return false;
    }

    //5. Deposit amount
    public boolean depositAmt(){
        System.out.print("Enter your id : ");
        int myId = sc.nextInt();
        int index = findPosition(myId);
        if (index == -1){
            System.out.println("Invalid id");
            return false;
        }
        System.out.print("Enter your pin : ");
        int yourPin  = sc.nextInt();
        if(accounts[index].getPin() == yourPin) {
            System.out.print("Enter the amount you want to deposit : ");
            int depo = sc.nextInt();

        }
        return false;
    }

































    //7 delete
    public boolean deleteAccount(){
        System.out.print("Enter your id : ");
        int myId = sc.nextInt();
        int index = findPosition(myId);
        if (index == -1){
            System.out.println("Invalid id");
            return false;
        }
        System.out.print("Enter your pin : ");
        int yourPin  = sc.nextInt();
        sc.nextLine();
        if(accounts[index].getPin() == yourPin) {
            System.out.println("Are you sure you want to delete account permanently ?");
            System.out.println("1. Yes ");
            System.out.println("2. No  ");
            int c = sc.nextInt();
            boolean sure = false;
            if(c == 1) sure=true;
            if(sure){
                for (int i = index; i < count; i++){
                    accounts[i] = accounts[i+1];
                }
                accounts[count--]=null;
                return true;
            }else{
                System.out.println("Glad you selected no here ");
            }
        }
        return false;
    }


    public int getCount(){
        return count;
    }

    private int findPosition(int id){
        for (int i=0; i < count; i++){
            if(accounts[i].getId() == id) return i;
        }
        return -1;
    }
}