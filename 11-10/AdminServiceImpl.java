package com.demo.services;

import com.demo.bean.CurrentAccount;
import com.demo.bean.SavingAccount;

public class AdminServiceImpl implements AdminService{
    public boolean setInterest(char ch,int intter){
        if(ch=='C'){
            CurrentAccount.setInterest_rate(intter);
            return true;
        }
        else if(ch=='S'){
            SavingAccount.setInterest_rate(intter);
            return true;
        }
        return false;
    }
}
