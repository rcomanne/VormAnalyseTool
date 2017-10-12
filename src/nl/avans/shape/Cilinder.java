package nl.avans.shape;

public class Cilinder extends Vorm {
    double hoogte, straal;

    public Cilinder(double hoogte, double straal) {
        this.hoogte = hoogte;
        this.straal = straal;
        this.inhoud = pi * (straal * 2) * hoogte;
    }
}
