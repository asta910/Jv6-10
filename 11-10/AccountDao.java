package com.demo.dao;

import java.util.*;
import com.demo.bean.Accounts;

public interface AccountDao {
    boolean createAccount(Accounts a);
    Set<Accounts> showAll();
    Accounts getAccount(String ac,int p);
    Accounts getOtherUsersAccount(String ac);
}
