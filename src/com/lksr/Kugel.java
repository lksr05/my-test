package com.lksr;

public class Kugel {
    //Attribute
    private int radius;
    private Punkt mittelpunkt;


    //Methoden
    Kugel(int kugelradius) { //Konstruktor zur Erzeugung des Objektes
        radius = kugelradius; //hat den gleichen Namen wie die Klasse
        mittelpunkt = new Punkt(0, 0);
    }

    public static boolean isKugel(Object obj) {
        return obj instanceof Kugel;
    }

    public double rauminhalt() {
        return 4 * radius * radius * radius * Math.PI / 3;
    }

    public boolean equals(Object o) {
        if (isKugel(o)) {
            Kugel k = (Kugel) o;
            return k.radius == radius;
        } else {
            return false;
        }
    }
}