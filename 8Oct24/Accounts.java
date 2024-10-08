package com.demo.interfaces;

public class Accounts {
    private int id;
    private String name;
    private int pin;
    private int balance;
    private static int minBalance;
    static {
        minBalance = 1000;
    }

    Accounts( int id,String name,int balance, int pin) {
        this.balance = balance;
        this.pin = pin;
        this.name = name;
        this.id = id;
    }

    public static int getMinBalance() {
        return minBalance;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pin=" + pin +
                ", balance=" + balance +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
