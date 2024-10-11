package com.demo.bean;


public class CurrentAccount extends Accounts{
    private static int min_balance;
    private static int interest_rate;
    private int min_no_transactions;

    static {
        interest_rate = 1;
        min_balance = 1000;
    }

    @Override
    public String toString() {
        return super.toString() + " " +
                "no_of_transactions : " + min_no_transactions;
    }

    CurrentAccount(){}

    public CurrentAccount(String name, int pin, String question, String ans, int balance) {
        super(name, pin, question, ans, balance);
        this.min_no_transactions = 0;
    }

    public static int getMin_balance() {
        return min_balance;
    }

    public static void setMin_balance(int min_balance) {
        CurrentAccount.min_balance = min_balance;
    }

    public static int getInterest_rate() {
        return interest_rate;
    }

    public static void setInterest_rate(int interest_rate) {
        CurrentAccount.interest_rate = interest_rate;
    }

    public int getMin_no_transactions() {
        return min_no_transactions;
    }

    public void setMin_no_transactions(int min_no_transactions) {
        this.min_no_transactions = min_no_transactions;
    }

}
