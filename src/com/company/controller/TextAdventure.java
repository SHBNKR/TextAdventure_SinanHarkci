package com.company.controller;

import com.company.model.database.Database;
import com.company.model.datatypes.Adventure;
import com.company.model.user.Admin;
import com.company.view.View;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Locale;

public class TextAdventure {

    private Adventure adventure;

    public void startTextAdventure() throws IOException {
        handleUserInputFromStart(View.showInitialMenu());
    }

    //handle Input from user
   private void handleUserInputFromStart(int input) throws IOException{
        switch(input){
            case(1):
                System.out.println("[1]: Sie möchten nach einem TextAdventure suchen \n"
                        + "Geben Sie den Titel in die Konsoleneingabe ein: ");
                break;
            case(2):
                System.out.println("[2]: Sie möchten eine Übersicht der TextAdventur's erhalten");
                String searchTextAdventure = View.showSearchedTextAdventureMask();
                searchTextAdventure = searchTextAdventure.substring(0,1).toUpperCase() + searchTextAdventure.substring(1).toLowerCase();
                System.out.println(searchTextAdventure);
                break;
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
            case(4):
                System.out.println("[4]: Sie möchten sich registrieren \n" + "Bitte geben Sie Ihren gewünschten Usernamen ein: ");
                break;
            default:
                System.out.println("[0]: Sie möchten die Anwendung beenden \n" + "Vielen Dank & Aufwiedersehen");
                System.exit(0);
                break;
        }

   }

    private void handleLoginError() throws IOException {

        if(View.showLoginError().equals("t")) {
            handleUserInputFromStart(3);
        } else{
            startTextAdventure();
        }
    }

    //
   private void handleAdminMenu(int i) throws IOException {
       //add TextAdventure
       if (i == 1) {
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           Adventure createAdventure = View.showAddTextAdventureMask();
           View.drawMap(createAdventure.getRows(), createAdventure.getColums(), createAdventure.getStartPosX(), createAdventure.getStartPosY(), createAdventure.getLocationNames());
           String richtung = br.readLine().trim();
           if(richtung.equals("osten")){
               createAdventure.setStartPosY(createAdventure.getStartPosY()+1);  //verschiebung um 1 nach rechts, but y+1?
           }
           View.drawMap(createAdventure.getRows(), createAdventure.getColums(), createAdventure.getStartPosX(), createAdventure.getStartPosY(), createAdventure.getLocationNames());

       }
       //show statistics
       else if (i == 2) {

       }
   }


   private void searchForTextAdventure(String titel) throws IOException{
        titel = titel.substring(0,1).toUpperCase() + titel.substring(1);



   }


}
