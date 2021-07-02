package com.company.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class View {

    public static int showInitialMenu() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("---- Welcome to Text Adventure ---");
        System.out.println("---- 1.) Nach einem TextAdventure suchen ---");
        System.out.println("---- 2.) TextAdventure anzeigen lassen ---");
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


}
