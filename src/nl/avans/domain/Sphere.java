package nl.avans.domain;

import nl.avans.businesslogic.service.ConversionService;

public class Sphere extends Shape {
    private double radius;
    private static final double CONSTANT = (double) 4/3;

    public Sphere(double radius) {
        this.radius = radius;
        this.volume = ConversionService.staticRound(this.calculate());
    }

    @Override
    public String toString() {
        return "Sphere " + radius + " " + volume;
    }

    private double calculate () {
        return (CONSTANT * pi * (radius * 3));
    }
}
