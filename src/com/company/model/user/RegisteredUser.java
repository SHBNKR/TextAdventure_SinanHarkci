package com.company.model.user;

import java.util.concurrent.atomic.AtomicInteger;

public class RegisteredUser{

    private static final AtomicInteger uniqueId = new AtomicInteger();
    private  int ID;
    private String username;
    private String password;

    private static String adminUsername = "admin";
    private static String adminPassword = "admin";


    public RegisteredUser(String[] userData) {
     //   ID = uniqueId.getAndIncrement();
        this.username = userData[0];
        this.password = userData[1];
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public  String getUsername() {
        return username;
    }
    public  String getPassword() {
        return password;
    }

    public int getID() { return ID; }

    public static String getAdminUsername() {
        return adminUsername;
    }
    public static String getAdminPassword() {
        return adminPassword;
    }
}
