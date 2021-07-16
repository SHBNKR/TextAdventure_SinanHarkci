package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.datatypes.Adventures;
import com.company.model.user.RegisteredUser;
import com.company.model.user.Gamer;
import com.google.gson.JsonArray;

import java.io.IOException;
import java.util.ArrayList;

public class Database {

    //singleton pattern
    static Database database = new Database();

    public static Database getInstance() {

        return database;
    }
    //singleton pattern

    Adventure adventure;
    Adventures adventures;
    RegisteredUser registeredUser;
    ArrayList<RegisteredUser> registeredUsers = new ArrayList<>();



    public void addTextAdventure(Adventure adventure){

        JsonArray textAdventureToJSON = new JsonArray();

        try{

            adventure = JsonReader.readExistingTextAdventureFileFromSystem();




        } catch (IOException e) {
            e.printStackTrace();
        }


      // return JsonWriter.writeAdventureFileToSystem(adventure);

    }


    //[4]: registrieren

    public void addUser(RegisteredUser user){
        //   RegisteredUsers registeredUsers = JsonReader.readExistingRegisteredUserFileFromSystem();

            registeredUsers.add(user);
            JsonWriter.writeRegisteredUserFileToSystem(registeredUsers);


    }

    public boolean checkIfUserIsExisting(RegisteredUser user) {
        boolean userExists = false;

        try{
            for(int i=0; i<registeredUsers.size(); i++) {
                if(user.getUsername().equals(registeredUsers.get(i).getUsername())){
                    userExists = true;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    return userExists;
    }



    public static boolean checkPassword(String password, boolean isAdmin) {

        if(isAdmin) {
            return password.equals(RegisteredUser.getAdminPassword());
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
