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
        System.out.println("---- Willkommen bei Text Adventure ---");
        System.out.println("---- Tippe  [1] : Nach einem TextAdventure suchen ---");
        System.out.println("---- Tippe  [2] : TextAdventure Übersicht anzeigen ---");
        System.out.println("---- Tippe  [3] : In der Anwendung anmelden ---");
        System.out.println("---- Tippe  [4] : In der Anwendung registrieren ---");
        System.out.println("---- Tippe  [irgendwas anderes] : Um die Anwendung zu beenden ---");
        try{
            return parseInt(br.readLine());
        } catch(NumberFormatException nfe){
            System.out.println("Sie möchten die Anwendung beenden." +
                    " \nVielen Dank dass Sie TextAdventure gespielt haben. Auf Wiedersehen");
            System.exit(0);
        }
        return 0;
    }

    // [1]: Nach TextAdventure suchen

    public static String showSearchTextAdventureMask() throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("[1]: Sie möchten nach einem TextAdventure suchen: \n"
                + "[1]: Geben Sie den Titel in die Konsoleneingabe ein: ");
        String input = br.readLine();
        System.out.println("[1]: Du suchst ein TextAdventure mit dem Titel: " + input );

        return input;
    }

    public static int showNotFoundTextAdventure() throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.err.println("[1]: Dein gesuchtes TextAdventure wurde nicht gefunden " +
                "\nTippe [1] um es erneut zu suchen \nTippe [2] um zum Hauptmenü zu gelangen");

        return parseInt(br.readLine());
    }

    // [2]: TextAdventure Übersicht anzeigen
    public static String showTextAdventureOverViewMask() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[2]: Sie möchten eine Übersicht aller TextAdventure's erhalten");
        System.out.println("[2]: Tippe [weiter] um weitere 5 TextAdventures zu laden .. ");
        System.out.println("[2]: Tippe [wählen] um ein TextAdventure zu starten .. ");
        System.out.println("[2]: Tippe [irgendwas anderes] um ins Hauptmenü zu gelangen ");

        return br.readLine();

    }

    // [3]: Eingeloggt Menü:
    public static int showAdminMask() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("[3]: Du bist als Admin eingeloggt:");
        System.out.println("[3]: ---- Tippe [1] : Ein TextAdventure erstellen ---");
        System.out.println("[3]: ---- Tippe [2] : In deine Statistiken einsehen ---");
        System.out.println("[3]: ---- Tippe [irgendwas] : Um zum Hauptmenü zu gelangen ---");

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

        System.out.println("[3.1]: ---- Sie möchten ein TextAdventure erstellen: ");
        System.out.println("Bitte geben Sie ihrem TextAdventure einen Titel: ");
        String titel = br.readLine();
        System.out.println("---- Die Größe des Spielfeldes wird durch ein X * Y Feld erstellt!  ---");
        System.out.println("Bitte geben Sie die Anzahl ihrer Reihen an: ");
        int rows = parseInt(br.readLine());
        System.out.println("Bitte geben Sie die Anzahl ihrer Spalten an: ");
        int colums = parseInt(br.readLine());
        System.out.print("Bitte bestimmen Sie den Startpunkt Ihres Spiels." +
                "\nDas erste Feld ist [0;0] ! " +
                "\nStartpunkt Reihe : ");
        int startPosX = parseInt(br.readLine());
        System.out.print("Startpunkt Spalte : " );
        int startPosY = parseInt(br.readLine());
        System.out.println("Bitte fügen Sie ihrem TextAdventure Standortnamen hinzu: ");
        //Input Zweidimensionales Array über key mit String verbinden
        String[][] locationNames = new String[rows][colums];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < colums; j++) {
                System.out.print("Standortname für : [" + i + ";" + j + "] => : ");
                locationNames[i][j] = br.readLine();
            }
        }
        System.out.println("Möchten Sie Ihr TextAdventure freigeben?: (true) oder (false) ");
        //boolean freigabe setzen & jenachdem in Übersicht ausblenden
        boolean isActiveTextAdventure = parseBoolean(br.readLine());
        System.out.println("...... laden ... .. ...");


        //make startPosX and startPosY -1 for make startPosition at  [0;0];
        return new Adventure(titel , rows,  colums,  startPosX,  startPosY,  isActiveTextAdventure, locationNames);
    }

    //
    public static int[] showInvalidTextAdventureInputMask(int i) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int row;
        int column;
        int startPosX;
        int startPosY;

        //Rows and Columns < 10
        if(i == 1) {
            System.err.println("Bitte Werte für Reihe & Spalte bis 8 eingeben um die Übersicht zu behalten");
            System.out.println("Bitte geben Sie die Anzahl ihrer Reihen an: ");
            row = parseInt(br.readLine());
            System.out.println("Bitte geben Sie die Anzahl ihrer Spalten an: ");
            column = parseInt(br.readLine());
            return new int[]{row, column};
        } else if(i==2) {
            System.out.println("Bitte die Startposition im Spielfeld halten: ");
            System.out.print("Bitte bestimmen Sie den Startpunkt Ihres Spiels. Das erste Feld ist [0;0] ! \nStartpunkt Reihe : ");
            startPosX = parseInt(br.readLine());
            System.out.print("Startpunkt Spalte : " );
            startPosY = parseInt(br.readLine());
            return new int[]{startPosX,startPosY};
        }

        return new int[0];
    }

    public static int showTextAdventureStatisticsMask() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[3.2]: TextAdventure Statistiken anzeigen: \n Tippe [1] um einzusehen wie viele Spieler dein TextAdventure schon gespielt haben:  \n  Tippe [2] um einzusehen wie viele Züge durchschnittlich auf deinem TextAdventure gemacht wurde: ");
        return parseInt(br.readLine());
    }


    // [4]: registrieren
    public static String[] showUserRegisterMask() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[4]: Sie möchten sich registrieren \n" + "Bitte geben Sie Ihren gewünschten Usernamen ein: ");
        String username = br.readLine().trim();
        System.out.println("[4]: Bitte geben Sie Ihr gewünschtes Passwort ein: ");
        String passwort = br.readLine().trim();

        return new String[]{username, passwort};

    }

    //play TextAdventure

    public static boolean startToPlay(String textAdventureTitle) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("[GAME]: TextAdventure mit dem Titel: " + textAdventureTitle + " starten?: " +
                "\n[GAME]: Tippe [true] um TextAdventure zu starten " +
                "\n[GAME]: Tippe [etwas anderes] um zum Hauptmenü zu gelangen");

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
                System.out.print("Standort: [" + i + ";" + j + "] => " + locationNames[i][j]);
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
        System.out.println("Herzlich Wilkommen in : " + locationNames[startPosX][startPosY]);
    }

    //Richtung einlesen
    public static String showSelectedDirectionOutput() throws IOException {
        System.out.println("In welche Himmelsrichtung möchtest du laufen?: \t [etwas anderes] zum beenden");
        System.out.println("-------norden------");
        System.out.println("westen--------osten");
        System.out.println("-------süden-------");
        System.out.println("Tippe deine Himmelsrichtung ein: ");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String direction = "";
        direction = br.readLine();

        // rechts check with trim if whitespace
        if(direction.trim().equals("osten") || direction.trim().equals("Osten")){
            System.out.println("Indiana Jones läuft Richtung Osten: -->....");
            return "Osten";
        }
        //links
        else if(direction.trim().equals("westen") || direction.trim().equals("Westen")){
            System.out.println("Indiana Jones bewegt sich Richtung Westen: ....<-- ");
            return "Westen";
        }
        //unten
        else if(direction.trim().equals("süden") || direction.trim().equals("Süden")){
            System.out.println("Indiana Jones läuft Richtung Süden: .... ");
            return "Süden";
        }
        //oben
        else if(direction.trim().equals("norden") || direction.trim().equals("Norden")){
            System.out.println("Indiana Jones läuft nach Norden: ... ");
            return "Norden";
        } else {
            return "exit";
        }
    }



    //Error's & Exceptions

    public static String showLoginError() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.err.println("Falscher username oder password!" +
                " \nTippe [t] um es erneut zu probieren oder" +
                " \n[irgendwas anders] um zurück zu kehren");

        return br.readLine();
    }
    //Register error zusammenfassen
    public static String invalidUserNameError() throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.err.println("Bitte nur alphanumerische Zeichen als Usernamen!" +
                " \nTippe [t] um es erneut zu probieren: " +
                " \nTippe [irgendwas anders] um zurück zu kehren: ");

        return br.readLine();
    }

    public static String showUserAlreadyExistsError() throws  IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.err.println("Dieser Username existiert bereits! Bitte wähle ein anderes!" +
                " \nTippe [t] um es erneut zu probieren: " +
                " \nTippe [irgendwas anders] um zurück zu kehren: ");

        return br.readLine();
    }


    //SideStuff:

    public String showMapSize(int rows, int columns){
        return "Das Spielfeld hat: " + rows + " Reihen & " + columns + " Zeilen";
    }

    public static void showSuccessFullAdded(String titel){
        System.out.println("Das TextAdventure mit dem Titel: " + titel + " wurde erstellt:");
        System.out.println("Sinan Harkci wünscht Ihnen Viel Spaß beim spielen");
    }


}
