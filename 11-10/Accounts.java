package com.demo.bean;
import java.util.*;

public class Accounts {
    private static int count;
    private String accountId;
    private String name;
    private int pin;
    private String question;
    private String ans;
    private int balance;

    private String generateAccountId(String n,int count,int p){
        String str = "";
        str = n.substring(0,2);
        str = str + count + p % 100;
        return str;
    }

    Accounts(){}
    public Accounts(String name, int pin, String question, String ans, int balance) {
        this.accountId = generateAccountId(name,count,pin);
        this.name = name;
        this.pin = pin;
        this.question = question;
        this.ans = ans;
        this.balance = balance;
        count++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public static int getCount() {
        return count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        Accounts accounts = (Accounts) o;
        return pin == accounts.pin && name.equals(accounts.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountId, name, pin);
    }

    @Override
    public String toString() {
        return " Accounts " +
                "accountId = " + accountId + '\'' +
                ", name'" + name + '\'' +
                ", pin= " + pin +
                ", question='" + question + '\'' +
                ", ans='" + ans + '\'' +
                ", balance=" + balance ;
    }
}
