package nl.avans.domain;

import nl.avans.businesslogic.service.ConversionService;

public class Cylinder extends Shape {
    private double height, radius;

    public Cylinder(double radius, double height) {
        this.height = height;
        this.radius = radius;
        this.volume = ConversionService.staticRound(this.calculate());
    }

    public double getHeight() {
        return height;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return "Cylinder " + height + " " + radius + " " + volume;
    }

    private double calculate () {
        return pi * (radius * radius) * height;
    }
}
