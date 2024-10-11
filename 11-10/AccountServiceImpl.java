// add pin change
package com.demo.services;

import java.util.*;
import com.demo.bean.Accounts;
import com.demo.bean.CurrentAccount;
import com.demo.bean.SavingAccount;
import com.demo.dao.AccountDaoImpl;

import com.demo.dao.AccountDao;

import java.util.Scanner;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountsDao;
    Scanner scanner = new Scanner(System.in);
    public AccountServiceImpl(){
        accountsDao = new AccountDaoImpl();
    }

    //1. create account
    public boolean createAccount(char option){
        System.out.print("Enter user name : ");
        String nm = scanner.next();
        System.out.print("Enter user pin : ");
        int pin = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Question : ");
        String qs = scanner.nextLine();
        System.out.print("Enter Answer : ");
        String ans = scanner.next();
        System.out.print("Enter balance: ");
        int bal = scanner.nextInt();

        if (option == 'S'){
            Accounts a = new SavingAccount(nm,pin,qs,ans,bal);
            return accountsDao.createAccount(a);
        }
        else if(option == 'C'){
            Accounts a = new CurrentAccount(nm,pin,qs,ans,bal);
            return accountsDao.createAccount(a);
        }
        return false;
    }

    //2. Display balance
    public boolean displayBalance(String accountId,int pin){
        Accounts account = accountsDao.getAccount(accountId,pin);
        if (account != null){
            System.out.println("Your current balance : " + account.getBalance());
            return true;
        }
        return false;
    }

    //3
    public int withdrawCash(String s,int pin,int amount){
        Accounts account = accountsDao.getAccount(s,pin);
        if (account != null){
            int min = account.getBalance() - amount;
            if (account instanceof CurrentAccount){
                if ( min > CurrentAccount.getMin_balance()){
                    account.setBalance(min);
                    return 1;
                }else{
                    return 2;
                }
            }
            if (account instanceof SavingAccount){
                if (min > SavingAccount.getMin_balance()){
                    account.setBalance(min);
                    return 1;
                }else{
                    return 2;
                }
            }
        }
        return 3;
    }

    //4 deposit
    public boolean depositAmount(String s,int pin,int amount){
        Accounts account = accountsDao.getAccount(s,pin);
        if (account != null) {
            int max = account.getBalance() + amount;
            account.setBalance(max);
            return true;
        }
        return false;
    }

    //5. Fund transfer
    public int fundTransfer(String s,int pin,int amount,String otherId){
        Accounts account1 = accountsDao.getAccount(s,pin);
        Accounts otherAccount = accountsDao.getOtherUsersAccount(otherId);
        if (otherAccount == null) return 4; //no other user found
        if (account1 != null){
            int min = account1.getBalance() - amount;
            if (account1 instanceof CurrentAccount){
                if ( min > CurrentAccount.getMin_balance()){
                    account1.setBalance(min);
                    int secondAccountNewBalance = otherAccount.getBalance() + amount;
                    otherAccount.setBalance(secondAccountNewBalance);
                    return 1;
                }else{
                    return 2;
                }
            }
            if (account1 instanceof SavingAccount){
                if (min > SavingAccount.getMin_balance()){
                    account1.setBalance(min);
                    int secondAccountNewBalance = otherAccount.getBalance() + amount;
                    otherAccount.setBalance(secondAccountNewBalance);
                    return 1;
                }else{
                    return 2;//low balance
                }
            }
        }
            return 3;//wrong credentials
    }

    //6. change pin
    public boolean changePin(String s){
        Accounts account = accountsDao.getOtherUsersAccount(s);

        System.out.println("How would you like to change pin : ");
        System.out.println("1. With older pin \n2. Use Question ans method \n Enter choice : ");

        int choice = scanner.nextInt();
        if (choice == 1){
            System.out.print("Enter current pin : ");
            int currentPin = scanner.nextInt();
            if (currentPin == account.getPin()){
                System.out.println("Enter new Pin : ");
                int newPin1 = scanner.nextInt();
                System.out.println("Confirm new Pin : ");
                int newPin2 = scanner.nextInt();
                if (newPin1 == newPin2){
                    account.setPin(newPin1);
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }if (choice == 2){
            String qs = account.getQuestion();
            String ansReal = account.getAns();
            System.out.println(qs);
            System.out.println("Enter you ans : ");
            String newAns = scanner.next();
            if (ansReal.equals(newAns)){
                System.out.println("Enter new Pin : ");
                int newPin1 = scanner.nextInt();
                System.out.println("Confirm new Pin : ");
                int newPin2 = scanner.nextInt();
                if (newPin1 == newPin2){
                    account.setPin(newPin1);
                    return true;
                }else{
                    return false;
                }
            }else{
                return false;
            }
        }
        return false;
    }

    //10. show all accounts
    public void showAll(){
        Set<Accounts> ans = accountsDao.showAll();
        for (Accounts a : ans){
            System.out.println(a);
        }
    }



}
