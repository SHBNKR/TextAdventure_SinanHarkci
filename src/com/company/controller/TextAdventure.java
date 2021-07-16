package com.company.controller;

import com.company.model.database.Database;
import com.company.model.database.JsonReader;
import com.company.model.database.JsonWriter;
import com.company.model.datatypes.Adventure;
import com.company.model.user.RegisteredUser;
import com.company.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class TextAdventure {

    private Adventure adventure;

    //starts the application
    public void startTextAdventure() throws IOException {
        handleUserInputFromStart(View.showInitialMenu());
    }

    //main menu
    private void handleUserInputFromStart(int input) throws IOException {
        switch (input) {
            //[1]: search for TA
            case (1):
                handleSearchTextAdventureMask(View.showSearchTextAdventureMask());
                break;
            //[2]: show TA Overview
            case (2):
                handleTextAdventureOverviewMask();
                break;
            //[3]: login & after
            case (3):
                String[] credentials = View.showLoginMask();
                RegisteredUser user = JsonReader.readExistingRegisteredUserFileFromSystem();
                if (credentials[0].equals(RegisteredUser.getAdminUsername())) {
                    if (Database.checkPassword(credentials[1], true)) {
                        handleAdminMenu(View.showAdminMask());
                    } else {
                        handleLoginError();
                    }
                } else if(credentials[0].equals(user.getUsername())){
                    if(credentials[1].equals(user.getPassword())){
                        handleAdminMenu(View.showAdminMask());
                    } else {
                        handleLoginError();
                    }
                }
                else {
                    handleLoginError();
                }
                break;
            // [4]: register & goto logged in menu
            case (4):
                handleUserRegister(View.showUserRegisterMask());
                handleAdminMenu(View.showAdminMask());
                break;
            // [5]: exit TextAdventure
            default:
                System.exit(0);
                break;
        }

    }


    // [1] geklickt: TextAdventure suchen --> TextAdventure starten
    private void handleSearchTextAdventureMask(String textAdventureTitle) throws IOException {

       // ArrayList<Adventure> adventures = Database.getInstance().get
        //load TextAdventure title from JSON file
        Adventure add = JsonReader.readExistingTextAdventureFileFromSystem();

        //check for title
        if (textAdventureTitle.equals(add.getTitle())) {

            startToPlayTextAdventure(View.startToPlay(textAdventureTitle), add);
        }
        else {
            handleTextAdventureNotFoundMask(View.showNotFoundTextAdventure());
        }



    }

    private void handleTextAdventureNotFoundMask(int userInputAfterNotFound) throws  IOException {
        if(userInputAfterNotFound == 1){
            handleUserInputFromStart(1);
        } else if( userInputAfterNotFound == 2){
            startTextAdventure();
        }
    }

    // [2] geklickt: Übersicht anzeigen lassen --< TextAdventure starten
    private void handleTextAdventureOverviewMask() {


    }

    // [3] geklickt: als Admin anmelden
    private void handleAdminMenu(int i) throws IOException {
        //add TextAdventure
        if (i == 1) {

            Adventure createAdventure = View.showCreateTextAdventureMask();
            if (createAdventure.getStartPosX() < createAdventure.getRows() || createAdventure.getStartPosY() < createAdventure.getColums()) {
               //  Startpunkt im Spielfeld definieren!
            }
            View.drawMap(createAdventure.getRows(), createAdventure.getColums(), createAdventure.getStartPosX(), createAdventure.getStartPosY(), createAdventure.getLocationNames());

            JsonWriter.writeAdventureFileToSystem(createAdventure);
        }
        //show statistics
        else if (i == 2) {
            handleShowStatisticsInput(View.showTextAdventureStatisticsMask());
        } else if (i == 0){
            startTextAdventure();
        }
    }

    private void handleShowStatisticsInput(int i) throws IOException {
        //return how often his TA was played
        if (i == 1) {

        }
        //return how often durchschnittlich his TA was played
        else if (i == 2) {

        }
    }

    private void handleLoginError() throws IOException {

        if (View.showLoginError().equals("t")) {
            handleUserInputFromStart(3);
        } else {
            startTextAdventure();
        }
    }

    // [4] geklickt: registrieren

    private void handleUserRegister(String[] userData) throws IOException {
        final Pattern pattern = Pattern.compile("^[a-zA-Z0-9_]*$");

        if(!pattern.matcher(userData[0]).matches()) {
            handleRegisterError();
        } else {
            RegisteredUser newUser = new RegisteredUser(userData);

            JsonWriter.writeRegisteredUserFileToSystem(newUser);
        }
    }

    private void handleRegisterError() throws IOException {

        if(View.showRegisterError().equals("t")) {
            handleUserInputFromStart(4);
        } else {
            startTextAdventure();
        }
    }

    //TextAdventure starten

    private void startToPlayTextAdventure(boolean wantToPlay, Adventure adventure) throws IOException {
        if (wantToPlay) {
            View.startTextAdventureText();
            View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
            String direction = "";
            while (!direction.equals("exit")) {
                direction = handleUserDirection(View.showSelectedDirectionOutput(), adventure);
            }
            startTextAdventure();
        } else{
            System.err.println("exit");
        }
    }


    private String handleUserDirection(String richtung, Adventure adventure) throws IOException {
        if (richtung.equals("Osten") && adventure.getStartPosY() != adventure.getColums() - 1) {
                adventure.setStartPosY(adventure.getStartPosY() + 1); //rechts
                View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
                adventure.incrementCountpermove();

        } else if (richtung.equals("Westen") && adventure.getStartPosY() != 0) { //links

            adventure.setStartPosY(adventure.getStartPosY() - 1);
            View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
            adventure.incrementCountpermove();

        } else if (richtung.equals("Süden") && adventure.getStartPosX() != adventure.getColums() - 1) {    //unten

            adventure.setStartPosX(adventure.getStartPosX() + 1);
            View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
            adventure.incrementCountpermove();

        } else if (richtung.equals("Norden") && adventure.getStartPosX() != 0) {

            adventure.setStartPosX(adventure.getStartPosX() - 1);
            View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
            adventure.incrementCountpermove();

        } else if (richtung.equals("exit")) {
            System.out.println("Danke dass du TextAdventure gespielt hast...");
            return "exit";
        } else {
            System.out.println("Es tut mir leid, du bist am tRand der Karte angekommen. Der Weg nach: " + richtung +" endet hier ... .. .");
        }
        return "";
    }


}
