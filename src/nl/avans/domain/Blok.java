package nl.avans.domain;

public class Blok extends Shape {
    private double length, width, height;

    public Blok(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = length * width * height;
    }
}
