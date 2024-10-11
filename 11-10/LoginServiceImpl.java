package com.demo.services;

public class LoginServiceImpl implements LoginService{
    public int whoIsThis(String n,String p){
        if (n.equals("user1") && p.equals("user1")) return 1;
        else if(n.equals("admin") && p.equals("admin")) return 2;
        return 3;
    }
}
