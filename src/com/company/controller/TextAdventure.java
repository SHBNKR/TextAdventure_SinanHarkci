package com.company.controller;

import com.company.model.database.Database;
import com.company.model.database.JsonReader;
import com.company.model.datatypes.Adventure;
import com.company.model.user.RegisteredUser;
import com.company.model.user.RegisteredUsers;
import com.company.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class TextAdventure {


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
                handleUserLogin(View.showLoginMask());

                break;
            // [4]: register & goto logged in menu
            case (4):
                handleUserRegister(View.showUserRegisterMask());
                //   handleUserInputFromStart(3); goto login after register
                handleRegisteredUserMenu(View.showRegisteredUserMask());
                break;
            // [5]: exit TextAdventure
            default:
                System.exit(0);
                break;
        }

    }


    // [1] geklickt: TextAdventure suchen --> TextAdventure starten
    private void handleSearchTextAdventureMask(String textAdventureTitle) throws IOException {

        //check for title
        if (Database.getInstance().checkIfTextAdventureTitleIsMatching(textAdventureTitle)) {
            Adventure adventure = Database.getInstance().searchForTextAdventure(textAdventureTitle);

            startToPlayTextAdventure(View.startToPlay(textAdventureTitle), adventure);
        } else {
            handleTextAdventureNotFoundMask(View.showNotFoundTextAdventure());
        }


    }

    private void handleTextAdventureNotFoundMask(String userInputAfterNotFound) throws IOException {
        if (userInputAfterNotFound.equals("t")) {
            handleUserInputFromStart(1);
        } else {
            startTextAdventure();
        }
    }

    // [2] geklickt: Übersicht anzeigen lassen --< TextAdventure starten
    private void handleTextAdventureOverviewMask() throws IOException {
        ArrayList<Adventure> adventures = Database.getInstance().loadTextAdventuresList();
        int i = 0;      // 0 because List starts at 0
        int pageSize = 5;       // 4 because List starts at 0
        int pageCount = 1;

        if (adventures != null) {
            pageCount = (adventures.size() / 5) + 1;


            // Creates Overview site for the count o
            for (int x = 0; x <= pageCount; x++) {

                ArrayList<Adventure> newadventures = new ArrayList<>(adventures.subList(i, pageSize));
                for (int y = 0; y < 5; y++) {
                    System.out.println(newadventures.get(y).getTitle());
                }
                System.out.println(newadventures.get(i).getTitle());
                pageSize += 5;
                i += 5;
                if (i == 5) {
                    String input = View.showTextAdventureOverViewMask();
                    if (input.equals("weiter")) {

                    } else if (input.equals("wählen")) {

                    } else {
                        startTextAdventure();
                    }
                }

            }
        } else {
            startTextAdventure();
        }
    }

    // [3] geklickt: als Registrierter User anmelden

    private void handleUserLogin(String[] loginData) throws IOException {


        if ((Database.getInstance().checkIfUserIsExisting(loginData[0]))) {
            if ((Database.getInstance().checkIfPasswordEquals(loginData[1], loginData[0]))) {
                handleRegisteredUserMenu(View.showRegisteredUserMask());
            } else {
                handleLoginError();
            }
        }

        if (loginData[0].equals(RegisteredUser.getAdminUsername())) {
            if (Database.checkPassword(loginData[1], true)) {
                handleRegisteredUserMenu(View.showRegisteredUserMask());
            } else {
                handleLoginError();
            }
        } else {
            handleLoginError();
        }

    }

    private void handleRegisteredUserMenu(int i) throws IOException {
        //create TextAdventure
        if (i == 1) {

            Adventure createAdventure = View.showCreateTextAdventureMask();

            //valid that startPosition is in Map!
            while (!(createAdventure.getStartPosX() < createAdventure.getRows() && createAdventure.getStartPosY() < createAdventure.getColums())) {
                int[] newStartPositions = View.showInvalidTextAdventureInputMask(2);
                createAdventure.setStartPosX(newStartPositions[0]);
                createAdventure.setStartPosY(newStartPositions[1]);
            }

            View.showSuccessFullAdded(createAdventure.getTitle());
            View.drawMap(createAdventure.getRows(), createAdventure.getColums(), createAdventure.getStartPosX(), createAdventure.getStartPosY(), createAdventure.getLocationNames());

            //Check if textadventure with title is already existing

          /*  if(Database.getInstance().checkIfTextAdventureIsExisting(createAdventure.getTitle())) {
                System.err.println("TextAdventure is already existing");
            }*/

            Database.getInstance().addTextAdventure(createAdventure);
            handleSearchTextAdventureMask(createAdventure.getTitle());
        }
        //show statistics
        else if (i == 2) {
            handleShowStatisticsInput(View.showTextAdventureStatisticsMask());
        } else if (i == 0) {
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

        if (!pattern.matcher(userData[0]).matches()) {
            invalidUserNameError();
        } else {

            if (Database.getInstance().checkIfUserIsExisting(userData[0])) {
                userAlreadyExistsError();
            } else {
                RegisteredUser newUser = new RegisteredUser(userData);
                Database.getInstance().addUser(newUser);
            }
        }
    }

    private void invalidUserNameError() throws IOException {

        if (View.invalidUserNameError().equals("t")) {
            handleUserInputFromStart(4);
        } else {
            startTextAdventure();
        }
    }

    private void userAlreadyExistsError() throws IOException {
        if (View.showUserAlreadyExistsError().equals("t")) {
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
        } else {
            startTextAdventure();
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
            View.showSelectedDirectionOutputAfterInput("exit");
            return "exit";
        } else {
            View.showSelectedDirectionOutputAfterInput(richtung);
        }
        return "";
    }
}
