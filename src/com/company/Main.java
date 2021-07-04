package com.company;


import com.company.controller.TextAdventure;
import com.company.model.datatypes.Adventure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        TextAdventure adventure = new TextAdventure();
        adventure.startTextAdventure();

     //   Adventure test = new Adventure( "test1", 15, 35, 2, 3);
      //  System.out.print(test.getMap());
      //  String[][] input = {{"platz1", "platz2", "platz3"}, {"platz4", "platz5", "platz6"}};

       /* BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < test.getRows(); i++) {
            for (int j = 0; j < test.getColums(); j++) {
                test.getMap()[i][j] = br.readLine();
            }
        }

        for (int i = 0; i < test.getRows(); i++) {
            for (int j = 0; j < test.getColums(); j++) {
                System.out.print(test.getMap()[i][j] + "\t");
            //    System.out.print("| o |");        //Map Output
            }
            System.out.println("");
        }   */

    }

}
