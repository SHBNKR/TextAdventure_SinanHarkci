package com.company.model.database;

import com.company.model.datatypes.Adventure;
import com.company.model.user.RegisteredUser;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

public class JsonReader{

    public static ArrayList<Adventure> readExistingTextAdventuresFileFromSystem() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("adventure.json"));
        ArrayList<Adventure> users = gson.fromJson(reader, new TypeToken<ArrayList<Adventure>>(){}.getType());

        reader.close();
        return users;
    }

    public static ArrayList<RegisteredUser> readExistingRegisteredUsersFileFromSystem() throws IOException {
        Gson gson = new Gson();
        Reader reader = Files.newBufferedReader(Paths.get("registereduser.json"));
        ArrayList<RegisteredUser> users = gson.fromJson(reader, new TypeToken<ArrayList<RegisteredUser>>(){}.getType());

        reader.close();
        return users;
    }


}
