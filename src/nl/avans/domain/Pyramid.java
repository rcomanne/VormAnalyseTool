package nl.avans.domain;

import nl.avans.businesslogic.service.ConversionService;

public class Pyramid extends Shape {
    private double baseArea, height;
    private static final double CONSTANT = (double) 1/3;

    public Pyramid(double baseArea, double height) {
        this.baseArea = baseArea;
        this.height = height;
        this.volume = ConversionService.staticRound(this.calculate());

    }

    @Override
    public String toString() {
        return "Pyramide " + baseArea + " " + height + " " + volume;
    }

    private double calculate () {
        return (baseArea * height * CONSTANT);
    }
}
