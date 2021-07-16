package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.datatypes.Adventures;
import com.company.model.user.RegisteredUser;
import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JsonReader{

    public static Adventure readExistingTextAdventureFileFromSystem() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("adventure.json"));
        Adventure addven = gson.fromJson(reader, Adventure.class);

        reader.close();
        return addven;
    }

    public static Adventures readExistingTextAdventuresFileFromSystem() throws IOException {
        String file = "adventures.json";
        String json = new String(Files.readAllBytes(Paths.get(file)));
        return new Gson().fromJson(json, Adventures.class);
    }

    public static RegisteredUser readExistingRegisteredUserFileFromSystem() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("registereduser.json"));
        RegisteredUser user = gson.fromJson(reader, RegisteredUser.class);

        reader.close();
        return user;
    }


}
