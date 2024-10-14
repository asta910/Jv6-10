package com.demo.dao;

import java.util.*;
import com.demo.bean.Accounts;

public interface AccountDao {
    boolean createAccount(Accounts a);
    Set<Accounts> showAll();
    Accounts getAccount(String ac,int p);
    Accounts getOtherUsersAccount(String ac);
    boolean deleteAccounts(Accounts account);
    boolean changeQuestion(Accounts account, String qs,String ans);
    void changeTransactionNo(Accounts account1,Accounts account2);
    void withdrawNoAndTransfer(Accounts accounts);
}
