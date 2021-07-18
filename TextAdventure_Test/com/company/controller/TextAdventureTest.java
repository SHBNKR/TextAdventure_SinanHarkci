package com.company.controller;

import com.company.model.database.JsonReader;
import com.company.model.user.RegisteredUser;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;

import static org.junit.Assert.*;

public class TextAdventureTest {



    //Test vom Regex Input aus
    // Klasse: TextAdventure
    // Zeile: 264
    // Methode: handleUserRegister();

    //true wenn in den Registrierten Nutzern nur Usernamen mit Alphanumerischen Zeichen stehen
    //true wenn in Registrierten

    @Test
    public void startTextAdventure() throws IOException {

        ArrayList<RegisteredUser> registeredUsers = new ArrayList<>();
        final Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]*$");

        registeredUsers = JsonReader.readExistingRegisteredUsersFileFromSystem();

        if(registeredUsers != null) {

            // Test for Existing Username if there was registered a user with unmatched regex
            for (RegisteredUser registeredUser : registeredUsers) {
                String username = registeredUser.getUsername();

                assertTrue(username.matches(String.valueOf(pattern)));
            }

            //Test for Invalid Usernames --> name + $ --> Testing the RegexMatcher
            ArrayList<RegisteredUser> wrongRegisteredUsers = new ArrayList<>();
            for (RegisteredUser registeredUser : registeredUsers) {
                String wronguserNames = registeredUser.getUsername() + "$";

                assertFalse(wronguserNames.matches(String.valueOf(pattern)));
            }
        } else{
            System.err.println("Es sind keine Registrierten Nutzer verfügbar zum testen");
        }



    }
}