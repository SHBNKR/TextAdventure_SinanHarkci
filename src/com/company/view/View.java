package com.company.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    public static int showInitialMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("---- Welcome to Text Adventure ---");
        System.out.println("---- 1.) Nach einem TextAdventure suchen ---");
        System.out.println("---- 2.) TextAdventure Übersicht anzeigen ---");
        System.out.println("---- 3.) In der Anwendung anmelden ---");
        System.out.println("---- 4.) In der Anwendung registrieren ---");

        try{
            return Integer.parseInt(br.readLine());
        } catch(NumberFormatException nfe){
            System.exit(0);
        }

        return 0;
    }

    public static int showAdminMask(){
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
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
        else if(i==4){
            System.out.println("Indiana Jones läuft nach Norden: ... ");
        }
        return 0;
    }

    public String showMapSize(int rows, int columns){
        return "Das Spielfeld hat: " + rows + " Reihen & " + columns + " Zeilen";
    }

    //draws the clear map with x & y
    public void drawMap(int rows, int columns) {
        String[][] map;
        for(int i=0; i<rows; i++){
            for(int o=0; o<columns; o++){
                System.out.print("| o |");
            }
            System.out.println("");
        }

    }


    public void showAddTextAdventureMask(){
        System.out.println("---- Sie möchten ein TextAdventure hinzufügen: ");
        BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));
        System.out.println("Bitte geben Sie ihrem TextAdenvture einen Titel: ");

        System.out.println("Bitte geben Sie die Anzahl ihrer Reihen an: ");

        System.out.println("Bitte geben Sie die Anzahl ihrer Spalten an: ");

        System.out.println("Bitte bestimmen Sie den Startpunkt Ihres Spiels");

        System.out.println("Bitte fügen Sie ihrem TextAdventure Standortnamen hinzu: ");
        //Input Zweidimensionales Array über key mit String verbinden

        System.out.println("Möchten Sie Ihr TextAdventure freigeben?: ");
        //boolean freigabe setzen & jenachdem in Übersicht ausblenden

        System.out.println("...... laden ... .. ...");
        System.out.println("Das TextAdventure mit dem Titel wurde erstellt:");
        System.out.println("Sinan Harkci wünscht Ihnen Viel Spaß beim spielen");
    }

    public String showSeachTextAdventureMask() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Bitte geben Sie den Titel des TextAdventure an zum suchen: ");

        return br.readLine();
    }



}
