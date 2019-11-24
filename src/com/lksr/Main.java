package com.lksr;
import java.lang.Math;

public class Main {
    public static void main(String[] args) {
	    int a = 2;
	    int b = 7;
        int c = a + b;
        // test
        double d = Math.sqrt(c);
        String message = String.format("Die Summe von %d und %d ist %d - %s.", a, b, c, d);
	    System.out.println(message);
    }
}
