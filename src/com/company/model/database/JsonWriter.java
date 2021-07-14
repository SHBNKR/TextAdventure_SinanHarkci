package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {

    public static boolean writeAdventureFileToSystem(Adventure adventureToWriteToJSON){
        //creates a file with a given title string
        try(FileWriter file = new FileWriter("adventure.json")){
            JsonObject jsonObject = new JsonObject();





            file.write(jsonObject.toString());
            System.out.println("TextAdventure was successfully added");

            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
