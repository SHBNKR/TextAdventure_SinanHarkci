package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.user.RegisteredUser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

public class JsonWriter {

    public static boolean writeAdventureFileToSystem(ArrayList<Adventure> adventures){
        //creates a file with a given title string
        try(Writer writer = new FileWriter("adventure.json")){

            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = builder.create();

            gson.toJson(adventures, writer);

            writer.flush();
            writer.close();

            System.out.println("TextAdventure was successfully added");

            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }

    public static boolean writeRegisteredUserFileToSystem(ArrayList<RegisteredUser> registeredUsers){
        //creates a file with a given title string
        try(Writer writer = new FileWriter("registereduser.json")){

            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = builder.create();

            gson.toJson(registeredUsers, writer);

            writer.flush();
            writer.close();

            System.out.println("User was successfully registered");


            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
