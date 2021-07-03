package com.company;


import com.company.model.datatypes.Adventure;
import com.google.gson.Gson;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

    //    TextAdventure adventure = new TextAdventure();
    //    adventure.startTextAdventure();

         System.out.println("Das TextAdventure startet.... ... .. .");
        System.out.println("X: stellt deine aktuelle Standorte dar");
        System.out.println("o: stellt die noch möglichen Standorte dar");
        System.out.println("Bewege dich mit den Pfeiltasten um in eine Richtung zu laufen");
        System.out.println("| X | o | o |");
        System.out.println("| o | o | o |");
        System.out.println("| o | o | o |");

        direction(3);

        Adventure test = new Adventure( "test1", 15, 35);

        Gson gson = new Gson();





    }
    public static void direction(int i){
        //rechts
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
    }




}
