package be.oak3.model;

public abstract class Aftershave extends Product {

    private enum Soort {VAPO, GEL};
    private Soort soort;

    public Aftershave(int productNummer, String merk, String naam, int volume, double prijs, Soort soort) {
        super(productNummer, merk, naam, volume, prijs);
        this.soort = soort;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + soort;
    }
}
