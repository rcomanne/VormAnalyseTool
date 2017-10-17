package nl.avans.domain;

import nl.avans.businesslogic.service.ConversionService;

public class Cube extends Shape {
    private double length, width, height;

    public Cube(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
        this.volume = ConversionService.staticRound(this.calculate());
    }

    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return "Cube " + length + " " + width + " " + height + " " + volume;
    }

    private double calculate () {
        return length * width * height;
    }
}
