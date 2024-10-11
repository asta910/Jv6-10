package com.demo.services;

import com.demo.bean.Accounts;

public interface AccountService {
    boolean createAccount(char c);
    void showAll();
    boolean displayBalance(String ac,int pin);
    int withdrawCash(String a,int p,int amount);
    boolean depositAmount(String s,int pin,int amount);
    int fundTransfer(String s,int pin,int amount,String otherId);
}
