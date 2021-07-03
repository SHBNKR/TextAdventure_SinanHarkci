package com.company.model.database;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;

public class JsonWriter {

    public static boolean writeAdventureFileToSystem(JsonArray adventuresToWriteToJSON){
        //creates a file with a given title string
        try(FileWriter file = new FileWriter("adventures.json")){
            JsonObject jsonObject = new JsonObject();
            jsonObject.add("adventures", adventuresToWriteToJSON);

            file.write(jsonObject.toString());

            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
