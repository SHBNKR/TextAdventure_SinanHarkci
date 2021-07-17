package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.user.RegisteredUser;
import com.company.model.user.Gamer;
import com.company.model.user.RegisteredUsers;

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
    RegisteredUser registeredUser;

    ArrayList<Adventure> adventures = new ArrayList<>();
    ArrayList<RegisteredUser> registeredUsers = new ArrayList<>();


    //[3]: create Textadventure
    public void addTextAdventure(Adventure adventure){
     adventures.add(adventure);
     JsonWriter.writeAdventureFileToSystem(adventures);

    }

    //[1]: search Textadventure
    public Adventure searchForTextAdventure(String title) {
        int ID = 0;
        try{
            for (Adventure value : adventures) {
                if (title.equals(value.getTitle())) {
                    adventure = value;
                    break;
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return adventure;
    }

    public boolean checkIfTextAdventureTitleIsMatching(String title) throws IOException {



        adventures = JsonReader.readExistingTextAdventuresFileFromSystem();

        boolean textAdventureExists = false;

        for (Adventure value : adventures) {
            if (title.equals(value.getTitle())) {
                textAdventureExists = true;
                break;
            }
        }
        return textAdventureExists;
    }

    //[2]: Overview

    public ArrayList<Adventure> loadTextAdventuresList() throws IOException {

         adventures = JsonReader.readExistingTextAdventuresFileFromSystem();


        if(!adventures.isEmpty()){
            return adventures;
        }

        return null;
    }

    //[3]: login

    public boolean checkIfUserIsExisting(String userName) throws IOException {

      //  registeredUsers = JsonReader.readExistingRegisteredUsersFileFromSystem();

        boolean userExists = false;

        try{
            if(registeredUsers != null ) {
                for (RegisteredUser user : registeredUsers) {
                    if (userName.equals(user.getUsername())) {
                        userExists = true;
                        break;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return userExists;
    }

    public boolean checkIfPasswordEquals(String password) throws IOException {


        registeredUsers = JsonReader.readExistingRegisteredUsersFileFromSystem();

        boolean passwordEquals = false;

        try{
            for (RegisteredUser user : registeredUsers) {
                if (password.equals(user.getPassword())) {
                    passwordEquals = true;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwordEquals;
    }





    //[4]: registrieren

    public void addUser(RegisteredUser user) throws IOException {

        registeredUsers = JsonReader.readExistingRegisteredUsersFileFromSystem();



            registeredUsers.add(user);
            JsonWriter.writeRegisteredUserFileToSystem(registeredUsers);

    }





    public static boolean checkPassword(String password, boolean isAdmin) {

        if(isAdmin) {
            return password.equals(RegisteredUser.getAdminPassword());
        } else {
            return password.equals(Gamer.getPassword());
        }
    }

    public void getTextAdventureTitlesAsStrings(){

    }




}
