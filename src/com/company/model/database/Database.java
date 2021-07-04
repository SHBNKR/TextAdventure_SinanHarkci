package com.company.model.database;

import com.company.controller.TextAdventure;
import com.company.model.datatypes.Adventure;
import com.company.model.user.Admin;
import com.company.model.user.Gamer;
import com.google.gson.JsonArray;

import java.util.ArrayList;

public class Database {

    //singleton pattern
    static Database database = new Database();

    public static Database getInstance() {

        return database;
    }
    //singleton pattern

    Adventure adventure;



    public static boolean checkPassword(String password, boolean isAdmin) {

        if(isAdmin) {
            return password.equals(Admin.getPassword());
        } else {
            return password.equals(Gamer.getPassword());
        }
    }


}
