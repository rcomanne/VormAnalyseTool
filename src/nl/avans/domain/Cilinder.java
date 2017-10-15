package nl.avans.domain;

public class Cilinder extends Shape {
    private double height, straal;

    public Cilinder(double height, double straal) {
        this.height = height;
        this.straal = straal;
        this.volume = pi * (straal * 2) * height;
    }
}
