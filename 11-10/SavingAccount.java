package com.demo.bean;

public class SavingAccount extends Accounts{
    private static int min_balance;
    private static int interest_rate;
    private long check_book_no;

    static {
        interest_rate = 2;
        min_balance = 4000;
    }
    private long generateBankBookNo(){
        long num = (long) (Math.random()*10*10*10*10*10*10) % 1000000;
        return num;
    }

    @Override
    public String toString() {
        return  super.toString() + " " +
                " check_book_no : " + check_book_no;
    }

    public SavingAccount(String name, int pin, String question, String ans, int balance) {
        super(name, pin, question, ans, balance);
        check_book_no = generateBankBookNo();
    }

    public static int getMin_balance() {
        return min_balance;
    }

    public static void setMin_balance(int min_balance) {
        SavingAccount.min_balance = min_balance;
    }

    public static int getInterest_rate() {
        return interest_rate;
    }

    public static void setInterest_rate(int interest_rate) {
        SavingAccount.interest_rate = interest_rate;
    }

    public long getCheck_book_no() {
        return check_book_no;
    }

    public void setCheck_book_no(int check_book_no) {
        this.check_book_no = check_book_no;
    }
}
