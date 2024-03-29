package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.user.RegisteredUser;

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

    ArrayList<Adventure> adventures;
    ArrayList<RegisteredUser> registeredUsers = new ArrayList<>();


    //[3]: create Textadventure
    public void addTextAdventure(Adventure adventure) throws IOException {

        adventures = JsonReader.readExistingTextAdventuresFileFromSystem();

        if(adventures == null){
            ArrayList<Adventure> adventures = new ArrayList<>();

            adventures.add(adventure);
            JsonWriter.writeAdventureFileToSystem(adventures);
        } else {
            adventure.setID(adventures.size());
            adventures.add(adventure);
            JsonWriter.writeAdventureFileToSystem(adventures);
        }
    }

    //[1]: search Textadventure
    public Adventure searchForTextAdventure(String title) {
        try {
            for (Adventure value : adventures) {
                if (title.equals(value.getTitle())) {
                    adventure = value;
                    break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return adventure;
    }

    public boolean checkIfTextAdventureTitleIsMatching(String title) throws IOException {


        adventures = JsonReader.readExistingTextAdventuresFileFromSystem();

        if(adventures == null)
            return false;

        for (Adventure value : adventures) {
            if (title.equals(value.getTitle())) {
                return true;
            }
        }
        return true;
    }

    //[2]: Overview

    public ArrayList<Adventure> loadTextAdventuresList() throws IOException {

        adventures = JsonReader.readExistingTextAdventuresFileFromSystem();

        if (adventures != null) {
            return adventures;
        }

        return null;
    }

    //[3]: login

    public boolean checkIfUserIsExisting(String userName) throws IOException {

        registeredUsers = JsonReader.readExistingRegisteredUsersFileFromSystem();

        boolean userExists = false;
        String username;

        try {
            if (registeredUsers != null) {
                for (RegisteredUser user : registeredUsers) {
                    if (userName.equals(user.getUsername())) {
                        username = user.getUsername();
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

    public boolean checkIfPasswordEquals(String password, String username) throws IOException {


        registeredUsers = JsonReader.readExistingRegisteredUsersFileFromSystem();

        boolean passwordEquals = false;


        try {
            for (RegisteredUser user : registeredUsers) {
                if (username.equals(user.getUsername())) {
                    int ID = user.getID();
                    if ((username.equals(registeredUsers.get(ID).getUsername()) && (password.equals(registeredUsers.get(ID).getPassword())))) {
                        passwordEquals = true;
                        break;
                    }
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

        if(registeredUsers == null){
            ArrayList<RegisteredUser> registeredUsers = new ArrayList<>();

            registeredUsers.add(user);
            JsonWriter.writeRegisteredUserFileToSystem(registeredUsers);
        } else {
            user.setID(registeredUsers.size());
            registeredUsers.add(user);
            JsonWriter.writeRegisteredUserFileToSystem(registeredUsers);
        }

    }

    public void getTextAdventureTitlesAsStrings() {

    }


}
