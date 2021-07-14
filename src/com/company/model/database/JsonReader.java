package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.datatypes.Adventures;
import com.google.gson.Gson;

import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader{

    public static Adventure readExistingTextAdventureFileFromSystem() throws IOException {
        String file = "adventure.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        return new Gson().fromJson(json, Adventure.class);
    }

    public static Adventures readExistingTextAdventuresFileFromSystem() throws IOException {
        String file = "adventures.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        return new Gson().fromJson(json, Adventures.class);
    }


}
