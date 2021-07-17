package com.company.model.datatypes;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Adventure {

    private static final AtomicInteger uniqueId = new AtomicInteger();
    private  int ID;
    private final String titel;
    private int countperplay = 0;
    private int countpermove = 0;
    private int row;
    private int column;
    private int startPosX;
    private int startPosY;
    private boolean isActive;
    private String[][] locationNames;


    public Adventure(String titel, int row, int column, int startPosX, int startPosY, boolean isActive, String[][] locationNames){
        ID = uniqueId.getAndIncrement();
        this.titel = titel;
        this.row = row;
        this.column = column;
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.isActive = isActive;
 //       this.map = new String[row][column];
        this.locationNames = locationNames;
    }


    public int getID() {
        return ID;
    }

    public String getTitle() {
        return titel;
    }

    public int getCountperplay() {
        return countperplay;
    }
    public int getCountpermove() {
        return countpermove;
    }

    public void incrementCountperPlay() {
        this.countperplay = countperplay++;
    }
    public void incrementCountpermove() {
        this.countpermove = countpermove++;
    }

    public int getRows(){ return row; }
    public int getColums() { return column; }

    public void setRow(int row) { this.row = row; }
    public void setColumn(int column) { this.column = column; }

    public boolean isActive() { return isActive; }

    public void setStartPosX(int startPosX) { this.startPosX = startPosX; }
    public void setStartPosY(int startPosY) { this.startPosY = startPosY; }

    public int getStartPosX() { return startPosX; }
    public int getStartPosY() { return startPosY; }

    public String[][] getLocationNames() { return locationNames; }


}
