package com.lksr;

public class Gerade {
    private double a;
    private double b;

    Gerade(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public double getY(double x) {
        return a * x + b;
    }

    public Punkt schnittpunkt(Gerade g) throws Exception {

        if (g.a == a) {
            if (g.b != b) {
                throw new Exception("Es gibt keinen Schnittpunkt!");
            } else {
                throw new Exception("Geraden sind gleich!");
            }
        }
        double x = -(g.b - b) / (g.a - a);
        double y = getY(x);
        Punkt p = new Punkt(x, y);
        return p;
    }
}
