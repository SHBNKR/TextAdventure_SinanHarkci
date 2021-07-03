package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.google.gson.Gson;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader{

    public static Adventure readExistingTextAdventureFileFromSystem() throws IOException {
        String file = "adventure.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        return new Gson().fromJson(json, Adventure.class);
    }


}
