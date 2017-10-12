package nl.avans.shape;

public class Bol extends Vorm {
    double straal;

    public Bol(double straal) {
        this.straal = straal;
        this.inhoud = (4/3) * pi * (straal * 3);
    }
}
