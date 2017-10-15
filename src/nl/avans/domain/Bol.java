package nl.avans.domain;

public class Bol extends Shape {
    private double radius;

    public Bol(double radius) {
        this.radius = radius;
        this.volume = (4/3) * pi * (radius * 3);
    }
}
