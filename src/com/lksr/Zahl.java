package com.lksr;

public class Zahl {
    private int wert = 0;

    public Zahl(int a) {
        this.wert = a;
    }

    public void add(int b) {
        wert += b;
    }

    public int getWert() {
        return wert;
    }
}
