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

    // [1]: Nach TextAdventure suchen
    public static String searchTextAdventureMask() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[1]: Sie möchten nach einem TextAdventure suchen \n"
                + "Geben Sie den Titel in die Konsoleneingabe ein: ");

        return br.readLine();
    }

    public static String showSearchTextAdventureMask() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Tippen Sie den Titel zum suchen ein: ");
        return br.readLine();
    }

    // [2]: TextAdventure Übersicht anzeigen
    public static String showTextAdventureOverViewMask() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[2]: Sie möchten eine Übersicht der TextAdventure's erhalten");
        String searchTextAdventure = View.showSearchTextAdventureMask();
        searchTextAdventure = searchTextAdventure.substring(0,1).toUpperCase() + searchTextAdventure.substring(1).toLowerCase();
        System.out.println(searchTextAdventure);

        return br.readLine();

    }

    // [3]: Eingeloggt Menü:
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

    // [3]: login
    public static String[] showLoginMask() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[3]: Sie möchten sich einloggen \n" + "Bitte geben Sie Ihren Usernamen ein: ");
        String username = br.readLine();

        System.out.println("[3]: Bitte geben Sie Ihr Passwort ein: ");
        String password = br.readLine();

        return new String[]{username, password};
    }

    // [3]: TextAdventure erstellen
    public static Adventure showCreateTextAdventureMask() throws IOException {
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

    public static int showTextAdventureStatisticsMask() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[3]: TextAdventure Statistiken anzeigen: \n Tippe [1] um einzusehen wie viele Spieler dein TextAdventure schon gespielt haben:  \n  Tippe [2] um einzusehen wie viele Züge durchschnittlich auf deinem TextAdventure gemacht wurde: ");
        return parseInt(br.readLine());
    }


    // [4]: registrieren
    public static String[] showUserRegisterMask() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("[4]: Sie möchten sich registrieren \n" + "Bitte geben Sie Ihren gewünschten Usernamen ein: ");
        String username = br.readLine();
        System.out.println("[4]: Bitte geben Sie Ihr gewünschtes Passwort ein: ");
        String passwort = br.readLine();

        return new String[]{username, passwort};

    }

    //play TextAdventure

    public static boolean startToPlay(String textAdventureTitle) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("TextAdventure mit dem Titel: " + textAdventureTitle + " starten?: \n Tippe [true] zum starten Tippe [etwas anderes] um zum Hauptmenü zu gelangen");

        return parseBoolean(br.readLine());
    }

    //show start
    public static void startTextAdventureText() throws IOException{
        System.out.println("Das TextAdventure startet.... ... .. .");
        System.out.println("X: stellt deinen aktuellen Standort dar");
        System.out.println("o: stellt die noch möglichen Standorte dar");
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


    //Richtung einlesen
    public static String handleInputDirection() throws IOException {
        System.out.println("In welche Himmelsrichtung möchtest du laufen?: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        return br.readLine();
    }


    //Richtung einlesen
    public static String showSelectedDirectionOutput() throws IOException {
        System.out.println("In welche Himmelsrichtung möchtest du laufen?: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String direction = "";
        direction = br.readLine();

        // rechts
        if(direction.equals("osten")){
            System.out.println("Indiana Jones läuft Richtung Osten: -->....");
            return "osten";
        }
        //links
        else if(direction.equals("westen")){
            System.out.println("Indiana Jones bewegt sich Richtung Westen: ....<-- ");
            return "westen";
        }
        //unten
        else if(direction.trim().equals("süden")){
            System.out.println("Indiana Jones läuft Richtung Süden: .... ");
            return "süden";
        }
        //oben
        else if(direction.trim().equals("norden")){
            System.out.println("Indiana Jones läuft nach Norden: ... ");
            return "norden";
        } else {
            return "exit";
        }

    }



    //Error's & Exceptions

    public static String showLoginError() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.err.println("Falscher username oder password! Tippe (t) um es erneut zu probieren oder etwas anderes um zurück zu kehren");
        return br.readLine();
    }




    //SideStuff:

    public String showMapSize(int rows, int columns){
        return "Das Spielfeld hat: " + rows + " Reihen & " + columns + " Zeilen";
    }






    public static void showExitApplication(){
        System.out.println("[0]: Sie möchten die Anwendung beenden \n" + "Vielen Dank & Aufwiedersehen");

        System.exit(0);

    }



}
