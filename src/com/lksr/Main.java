package com.lksr;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welche Steigung hat die Gerade? ");
        double a = sc.nextDouble();
        System.out.println("Wo schneidet die Gerade die y-Achse? ");
        double sy = sc.nextDouble();
        Gerade g1 = new Gerade(a, sy);
        System.out.println("Welche Steigung hat die 2. Gerade? ");
        double a2 = sc.nextDouble();
        System.out.println("Wo schneidet die 2. Gerade die y-Achse? ");
        double sy2 = sc.nextDouble();
        Gerade g2 = new Gerade(a2, sy2);
        try {
            Punkt p = g1.schnittpunkt(g2);
            System.out.println("Der Schnittunkt liegt bei: " + p);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main2(String[] args) {
        String s = "a";
        Kugel k1 = new Kugel(1);
        Kugel k2 = new Kugel(1);
        Zahl z = new Zahl(2);
        System.out.println("zahl: " + z.getWert());
        z.add(3);
        z.add(5);
        System.out.println("zahl: " + z.getWert());
        System.out.println("K1: " + k1.rauminhalt());
        System.out.println("K2: " + k2.rauminhalt());
        System.out.println("k2 ist Kugel: " + Kugel.isKugel(k2));
        System.out.println("k1 = k2: " + k1.equals(k2));
        System.out.println("2+4: " + z.getWert());
    }
}
