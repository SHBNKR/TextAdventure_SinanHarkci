package com.company.model.datatypes;

import java.util.concurrent.atomic.AtomicInteger;

public class Adventure {

    private static final AtomicInteger uniqueId = new AtomicInteger();
    private  int ID;
    private final String titel;
    private int countperplay = 0;
    private int countpermove = 0;
    private int row;
    private int column;

    public void setStartPosX(int startPosX) {
        this.startPosX = startPosX;
    }

    public void setStartPosY(int startPosY) {
        this.startPosY = startPosY;
    }

    private int startPosX;
    private int startPosY;
    private boolean isActive = false;


 /*   public String[][] getMap() {
        return map;
    }*/

  //  private String[][] map;

    public String[][] getLocationNames() {
        return locationNames;
    }

    String[][] locationNames;

    public Adventure(String titel, int row, int column, int startPosX, int startPosY, boolean isActive, String[][] locationNames){
        ID = uniqueId.incrementAndGet();
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
    public void setCountperplay(int countperplay) {
        this.countperplay = countperplay;
    }

    public int getCountpermove() {
        return countpermove;
    }
    public void setCountpermove(int countpermove) {
        this.countpermove = countpermove;
    }

    public int getStartPosX() { return startPosX; }
    public int getStartPosY() { return startPosY; }

    public boolean isActive() { return isActive; }

    public int getRows(){ return row; }
    public int getColums() { return column; }


}
