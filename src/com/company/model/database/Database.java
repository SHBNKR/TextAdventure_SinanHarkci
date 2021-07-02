package com.company.model.database;

import com.company.model.user.Admin;
import com.company.model.user.Gamer;

import java.util.ArrayList;

public class Database {

    static Database database = new Database();

    public static Database getInstance() {
        return database;
    }


    public static boolean checkPassword(String password, boolean isAdmin) {

        if(isAdmin) {
            return password.equals(Admin.getPassword());
        } else {
            return password.equals(Gamer.getPassword());
        }
    }
}
