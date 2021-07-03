package com.company;


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
            System.out.print("Indiana Jones läuft Richtung Süden: .... \\U+2193 ");
        }


    }




}
