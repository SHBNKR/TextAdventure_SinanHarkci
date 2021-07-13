package com.company.view;

import com.company.model.datatypes.Adventure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import static java.lang.Boolean.parseBoolean;
import static java.lang.Integer.parseInt;

public class View {

    public static int showInitialMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("---- Welcome to Text Adventure ---");
        System.out.println("---- 1.) Nach einem TextAdventure suchen ---");
        System.out.println("---- 2.) TextAdventure Übersicht anzeigen ---");
        System.out.println("---- 3.) In der Anwendung anmelden ---");
        System.out.println("---- 4.) In der Anwendung registrieren ---");

        try{
            return parseInt(br.readLine());
        } catch(NumberFormatException nfe){
            System.exit(0);
        }

        return 0;
    }

    //Admin Menü
    public static int showAdminMask() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Du bist als Admin eingeloggt:");
        System.out.println("---- 1.) Ein TextAdventure erstellen ---");
        System.out.println("---- 2.) In die Statistiken einsehen ---");

        try {
            return parseInt(br.readLine());
        } catch(NumberFormatException | IOException e){}
            return 0;
    }

    public static String[] showLoginMask() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[3]: Sie möchten sich einloggen \n" + "Bitte geben Sie Ihren Usernamen ein: ");
        String username = br.readLine();

        System.out.println("[3]: Bitte geben Sie Ihr Passwort ein: ");
        String password = br.readLine();

        return new String[]{username, password};
    }

    public static String showSearchedTextAdventureMask() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Tippen Sie den Titel zum suchen ein: ");
        return br.readLine();
    }


    public static int showStartTextAdventureMenu(int i){
        if(i == 1) {
            System.out.println("Das TextAdventure startet.... ... .. .");
            System.out.println("X: stellt deinen aktuellen Standort dar");
            System.out.println("o: stellt die noch möglichen Standorte dar");
            System.out.println("Bewege dich mit den Pfeiltasten um in eine Richtung zu laufen");
            System.out.println("| X | o | o |");
            System.out.println("| o | o | o |");
            System.out.println("| o | o | o |");
        }
        return 0;
    }


    public static int showSelectedDircectionOutput(int i) {
        // rechts
        if(i == 1){
            System.out.println("Indiana Jones läuft Richtung Osten: -->....");
        }
        //links
        else if(i==2){
            System.out.println("Indiana Jones bewegt sich Richtung Westen: ....<-- ");
        }
        //unten
        else if(i==3){
            System.out.print("Indiana Jones läuft Richtung Süden: .... ");
        }
        //oben
        else if(i==4){
            System.out.println("Indiana Jones läuft nach Norden: ... ");
        }
        return 0;
    }

    public static String showLoginError() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.err.println("Falscher username oder password! Tippe (t) um es erneut zu probieren oder etwas anderes um zurück zu kehren");
        return br.readLine();
    }

    public String showMapSize(int rows, int columns){
        return "Das Spielfeld hat: " + rows + " Reihen & " + columns + " Zeilen";
    }



    //draws the clear map with x & y
    public static void drawMap(int rows, int columns, int startPosX, int startPosY, String[][] locationNames) {
        //prints the locationnames
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                System.out.print("Standort: [" + i + ";" + j + "] => " +  locationNames[i][j]);
                System.out.print("\t");
            }
            System.out.println();
        }
        //prints the Map
        for(int i=0; i<rows; i++){
            for(int o=0; o<columns; o++){
                if(i == startPosX && o == startPosY)
                    System.out.print("| X |");
                else
                System.out.print("| o |");
            }
            System.out.println();
        }
        System.out.println("Startpunkt: " + locationNames[startPosX][startPosY]);
    }

    public static Adventure showAddTextAdventureMask() throws IOException {
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

        System.out.println("---- Sie möchten ein TextAdventure hinzufügen: ");
        System.out.println("Bitte geben Sie ihrem TextAdventure einen Titel: ");
        String titel = br.readLine();
        System.out.println("---- Die Größe des Spielfeldes wird durch ein X * Y Feld erstellt!  ---");
        System.out.println("Bitte geben Sie die Anzahl ihrer Reihen an: ");
        int rows = parseInt(br.readLine());
        System.out.println("Bitte geben Sie die Anzahl ihrer Spalten an: ");
        int colums = parseInt(br.readLine());
        System.out.println("Bitte bestimmen Sie den Startpunkt Ihres Spiels");
        int startPosX = parseInt(br.readLine());
        int startPosY = parseInt(br.readLine());
        System.out.println("Bitte fügen Sie ihrem TextAdventure Standortnamen hinzu: ");
        //Input Zweidimensionales Array über key mit String verbinden
        String[][] locationNames = new String[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                locationNames[i][j] = br.readLine();
            }
        }
        System.out.println("Möchten Sie Ihr TextAdventure freigeben?: (true) oder (false) ");
        //boolean freigabe setzen & jenachdem in Übersicht ausblenden
        boolean isActiveTextAdventure = parseBoolean(br.readLine());
        System.out.println("...... laden ... .. ...");
        System.out.println("Das TextAdventure mit dem Titel: " + titel + " wurde erstellt:");
        System.out.println("Sinan Harkci wünscht Ihnen Viel Spaß beim spielen");

        //  return new String[]{titel, String.valueOf(rows), String.valueOf(colums), String.valueOf(startPosX), String.valueOf(startPosY), String.valueOf(isActiveTextAdventure),};
        return new Adventure(titel , rows,  colums,  startPosX,  startPosY,  isActiveTextAdventure, locationNames);
    }

    public String showSeachTextAdventureMask() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bitte geben Sie den Titel des TextAdventure an zum suchen: ");

        return br.readLine();
    }



}
