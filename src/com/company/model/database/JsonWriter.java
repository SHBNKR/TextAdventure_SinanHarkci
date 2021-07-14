package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.datatypes.Adventures;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class JsonWriter {

    public static boolean writeAdventureFileToSystem(Adventure adventureToWriteToJSON){
        //creates a file with a given title string
        try(Writer writer = new FileWriter("adventure.json")){

            GsonBuilder builder = new GsonBuilder();
            builder.serializeNulls();
            Gson gson = builder.create();

            gson.toJson(adventureToWriteToJSON, writer);

            writer.flush();
            writer.close();

            System.out.println("TextAdventure was successfully added");

            return true;

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return false;
        }
    }
}
