package nl.avans.domain;

import nl.avans.businesslogic.service.ConversionService;

public class Cylinder extends Shape {
    private double height, radius;

    public Cylinder(double height, double radius) {
        this.height = height;
        this.radius = radius;
        this.volume = ConversionService.staticRound(this.calculate(), 2);

    }

    @Override
    public String toString() {
        return "Cylinder " + height + radius + " " + volume;
    }

    private double calculate () {
        return pi * (radius * radius) * height;
    }
}
