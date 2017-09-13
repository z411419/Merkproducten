package be.oak3.model;

public abstract class Deodorant extends Product {

    private enum DeoType {VAPO,STICK};
    private DeoType soort;

    public Deodorant(int productNummer, String merk, String naam, int volume, double prijs, DeoType soort) {
        super(productNummer, merk, naam, volume, prijs);
        this.soort = soort;
    }

    @Override
    public String toString() {
        return super.toString() + "\t" + soort;
    }



}
