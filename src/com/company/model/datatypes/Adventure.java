package com.company.model.datatypes;

import java.util.concurrent.atomic.AtomicInteger;

public class Adventure {

    private static final AtomicInteger uniqueId = new AtomicInteger();
    private int ID;
    private final String titel;
    private int countperplay;
    private int countpermove;



    public Adventure(String titel, int countperplay, int countpermove ){
        ID = uniqueId.incrementAndGet();
        this.titel = titel;
        this.countperplay = countperplay;
        this.countpermove = countpermove;
    }


    public int getID() {
        return ID;
    }

    public String getTitel() {
        return titel;
    }

    public int getCountperplay() {
        return countperplay;
    }

    public void setCountperplay(int countperplay) {
        this.countperplay = countperplay;
    }

    public int getCountpermove() {
        return countpermove;
    }

    public void setCountpermove(int countpermove) {
        this.countpermove = countpermove;
    }
}
