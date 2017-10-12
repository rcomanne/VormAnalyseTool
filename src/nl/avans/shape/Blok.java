package nl.avans.shape;

public class Blok extends Vorm {
    double lengte, breedte, hoogte;

    public Blok(double lengte, double breedte, double hoogte) {
        this.lengte = lengte;
        this.breedte = breedte;
        this.hoogte = hoogte;
        this.inhoud = lengte * breedte * hoogte;
    }
}
