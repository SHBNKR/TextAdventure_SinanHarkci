package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.datatypes.Adventures;
import com.company.model.user.Admin;
import com.company.model.user.Gamer;
import com.google.gson.JsonArray;

import java.io.IOException;

public class Database {

    //singleton pattern
    static Database database = new Database();

    public static Database getInstance() {

        return database;
    }
    //singleton pattern

    Adventure adventure;
    Adventures adventures;


    public void addTextAdventure(Adventure adventure){

        JsonArray textAdventureToJSON = new JsonArray();

        try{

            adventure = JsonReader.readExistingTextAdventureFileFromSystem();




        } catch (IOException e) {
            e.printStackTrace();
        }


      // return JsonWriter.writeAdventureFileToSystem(adventure);

    }



    public static boolean checkPassword(String password, boolean isAdmin) {

        if(isAdmin) {
            return password.equals(Admin.getPassword());
        } else {
            return password.equals(Gamer.getPassword());
        }
    }

    public void getTextAdventureTitlesAsStrings(){

        try{

            adventures = JsonReader.readExistingTextAdventuresFileFromSystem();
            adventures.adventures.get(0);

        } catch (IOException e) {
            e.printStackTrace();
            //no file
        }
    }




}
