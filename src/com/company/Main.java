package com.company;


import com.company.model.datatypes.Adventure;
import com.company.view.View;
import com.google.gson.Gson;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

    //    TextAdventure adventure = new TextAdventure();
    //    adventure.startTextAdventure();

        Adventure test = new Adventure( "test1", 15, 35, 2, 3);
      //  System.out.print(test.getMap());
      //  String[][] input = {{"platz1", "platz2", "platz3"}, {"platz4", "platz5", "platz6"}};

    View.drawMap(2,2);






    }

}
