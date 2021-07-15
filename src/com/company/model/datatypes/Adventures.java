package com.company.model.datatypes;

import java.util.ArrayList;
import java.util.List;

public class Adventures {

    public ArrayList<Adventure> adventures;

    public  Adventures() {
        adventures = new ArrayList<>();
    }

    public List<Adventure> getAdventures(){
        return adventures;
    }

}
