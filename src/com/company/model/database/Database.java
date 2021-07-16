package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.user.RegisteredUser;
import com.company.model.user.Gamer;

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

    public Adventure searchForTextAdventure(String title) {
        int ID = 0;
        try{
            for (Adventure value : adventures) {
                if (title.equals(value.getTitle())) {
                    adventure = value;
                    break;
                } else {
                    System.err.println("not found");
                }
            }

        } catch (Exception e){
            e.printStackTrace();
        }

        return adventure;
    }


    public boolean checkIfTextAdventureTitleIsMatching(String title) {
        boolean textAdventureExists = false;

        try{
            for (Adventure value : adventures) {
                if (title.equals(value.getTitle())) {
                    textAdventureExists = true;
                    break;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return textAdventureExists;
    }



    //[4]: registrieren

    public void addUser(RegisteredUser user){
        //   RegisteredUsers registeredUsers = JsonReader.readExistingRegisteredUserFileFromSystem();

            registeredUsers.add(user);
            JsonWriter.writeRegisteredUserFileToSystem(registeredUsers);

    }

    public boolean checkIfUserIsExisting(String userName) {
        boolean userExists = false;

        try{
            for (RegisteredUser user : registeredUsers) {
                if (userName.equals(user.getUsername())) {
                    userExists = true;
                    break;
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

    }




}
