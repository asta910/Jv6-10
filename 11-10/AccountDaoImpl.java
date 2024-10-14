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

    public boolean deleteAccounts(Accounts account){
        if (set.contains(account)){
            set.remove(account);
            return true;
        }
        return false;
    }

    public boolean changeQuestion(Accounts account, String qs,String ans){
        account.setQuestion(qs);
        account.setAns(ans);
        return true;
    }

    public void changeTransactionNo(Accounts account1,Accounts account2){
        int m1= ((CurrentAccount) account1).getMin_no_transactions();
        int m2= ((CurrentAccount) account2).getMin_no_transactions();
        m1++;m2++;
        ((CurrentAccount) account1).setMin_no_transactions(m1);
        ((CurrentAccount) account2).setMin_no_transactions(m2);

    }
    public void withdrawNoAndTransfer(Accounts account1){
        int m1= ((CurrentAccount) account1).getMin_no_transactions();
        m1++;
        ((CurrentAccount) account1).setMin_no_transactions(m1);
    }
}
