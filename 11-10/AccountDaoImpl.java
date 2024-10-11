package com.demo.dao;

import java.util.*;
import com.demo.bean.Accounts;
import com.demo.bean.CurrentAccount;
import com.demo.bean.SavingAccount;

public class AccountDaoImpl implements AccountDao{
    static Set<Accounts> set;
    static{
        set = new HashSet<>();
        set.add(new CurrentAccount("Yogesh",9999,"Who is best ?","I am",100000));
        set.add(new SavingAccount("Omen",1000,"Who are you ? ","Controller ",20000));
        set.add(new SavingAccount("Reyna",1234,"Who are you ? ","Initiator ",90000));
        set.add(new CurrentAccount("Asta",1112,"Who is best ?","Asta",990000));
    }

    public boolean createAccount(Accounts a){
        set.add(a);
        return true;
    }

    public Set<Accounts> showAll(){
        return set;
    }

    public Accounts getAccount(String ac,int pin){
        for(Accounts a : set){
            if (a.getAccountId().equals(ac) && a.getPin() == pin){
                return a;
            }
        }
        return null;
    }

    public Accounts getOtherUsersAccount(String ac){
        for (Accounts a : set){
            if (a.getAccountId().equals(ac)){
                return a;
            }
        }
        return null;
    }

}
