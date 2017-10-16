package nl.avans.domain;

import nl.avans.businesslogic.service.ConversionService;

public class Cone extends Shape {
    private double radius, height;
    private static final double CONSTANT = (double)1/3;

    public Cone(double radius, double height) {
        this.radius = radius;
        this.height = height;
        this.volume = ConversionService.staticRound(this.calculate());
    }

    @Override
    public String toString() {
        return "Kegel " + radius + " " + height + " " + volume;
    }

    double calculate () {
        return (CONSTANT * pi * (radius*radius) * height);
    }
}
