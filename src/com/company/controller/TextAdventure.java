package com.company.controller;

import com.company.model.database.Database;
import com.company.model.database.JsonReader;
import com.company.model.database.JsonWriter;
import com.company.model.datatypes.Adventure;
import com.company.model.user.Admin;
import com.company.view.View;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TextAdventure {

    private Adventure adventure;

    //starts the application
    public void startTextAdventure() throws IOException {
        handleUserInputFromStart(View.showInitialMenu());
    }

    //main menu
   private void handleUserInputFromStart(int input) throws IOException{
        switch(input){
            //[1]: search for TA
            case(1):
                    handleSearchTextAdventureMask(View.showSearchTextAdventureMask());
                break;
            //[2]: show TA Overview
            case(2):
                    handleTextAdventureOverviewMask();
                break;
            //[3]: login & after
            case(3):
                String[] credentials = View.showLoginMask();
                if(credentials[0].equals(Admin.getUsername())){
                    if(Database.checkPassword(credentials[1], true)) {
                        handleAdminMenu(View.showAdminMask());
                    } else {
                        handleLoginError();
                    }
                }
                break;
            // [4]: register & goto logged in menu
            case(4):
                handleUserRegister(View.showUserRegisterMask());
                break;
            // [5]: exit TextAdventure
            default:
                View.showExitApplication();
                System.out.println("[0]: Sie möchten die Anwendung beenden \n" + "Vielen Dank & Aufwiedersehen");
                System.exit(0);
                break;
        }

   }


    // [1] geklickt: TextAdventure suchen --> TextAdventure starten
   private void handleSearchTextAdventureMask(String textAdventureTitle) throws IOException{

       Adventure add = JsonReader.readExistingTextAdventureFileFromSystem();
       System.out.println("THE TITLE IS:::");
       System.out.println(add.getTitle());


   }

   // [2] geklickt: Übersicht anzeigen lassen --< TextAdventure starten
    private void handleTextAdventureOverviewMask() {


    }

    // [3] geklickt: als Admin anmelden
   private void handleAdminMenu(int i) throws IOException {
       //add TextAdventure
       if (i == 1) {

           Adventure createAdventure = View.showCreateTextAdventureMask();
           View.drawMap(createAdventure.getRows(), createAdventure.getColums(), createAdventure.getStartPosX(), createAdventure.getStartPosY(), createAdventure.getLocationNames());

           JsonWriter.writeAdventureFileToSystem(createAdventure);
           //  playTextAdventure(View.showSelectedDirectionOutput(),createAdventure);
       }
       //show statistics
       else if (i == 2) {
            handleShowStatisticsInput(View.showTextAdventureStatisticsMask());
       }
   }

    private void handleShowStatisticsInput(int i) throws  IOException {
        //return how often his TA was played
        if(i == 1){

        }
        //return how often durchschnittlich his TA was played
        else if( i == 2){

        }
     }

   // [4] geklickt: registrieren

    private void handleUserRegister(String[] userData) throws IOException {



    }

   //TextAdventure starten
   private void playTextAdventure(String richtung, Adventure adventure){
        while(richtung != null) {
            if (richtung.equals("osten")) {
                adventure.setStartPosY(adventure.getStartPosY() + 1); //rechts
                View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
            } else if (richtung.equals("westen")) { //links
                adventure.setStartPosY(adventure.getStartPosY() - 1);
                View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
            } else if (richtung.equals("süden")) {    //unten
                adventure.setStartPosX(adventure.getStartPosX() + 1);
                View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
            } else if (richtung.equals("norden")) {
                adventure.setStartPosX(adventure.getStartPosX() - 1);
                View.drawMap(adventure.getRows(), adventure.getColums(), adventure.getStartPosX(), adventure.getStartPosY(), adventure.getLocationNames());
            } else {
                System.exit(0);
            }
        }
   }


   // errors & Exceptions
    private void handleLoginError() throws IOException {

        if(View.showLoginError().equals("t")) {
            handleUserInputFromStart(3);
        } else{
            startTextAdventure();
        }
    }


}
