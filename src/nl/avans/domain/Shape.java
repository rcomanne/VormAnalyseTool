package nl.avans.domain;

public abstract class Shape {
    double volume;
    double pi = Math.PI;

    public double getVolume() {
        return volume;
    }
}
