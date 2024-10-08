package com.demo.interfaces;

public interface AccountInterface {
    boolean addNewAccount();
    int getCount();
    void showBalance();

    boolean withdrawMoney();
    boolean fundTransfer();
    boolean depositAmt();
    boolean deleteAccount();
}
