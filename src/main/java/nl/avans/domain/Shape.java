package nl.avans.domain;

import java.io.Serializable;

public abstract class Shape implements Serializable {
    double volume;
    double pi = Math.PI;

    public double getVolume() {
        return volume;
    }

    public abstract double calculate ();
}
