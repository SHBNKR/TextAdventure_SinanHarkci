package com.company.controller;

import com.company.model.database.Database;
import com.company.model.user.Admin;
import com.company.view.View;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

public class TextAdventure {

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

   //
   private void handleAdminMenu(int i) throws IOException {
        //add TextAdventure
        if(i == 1){

        }
   }

   private void searchForTextAdventure(String titel) throws IOException{
        titel = titel.substring(0,1).toUpperCase() + titel.substring(1);



   }


}
