package be.oak3.model;

public class Deodorant extends Product {


    @Override
    public String toString() {

        return super.toString() + '\t' + soort;
    }
    private DeoType soort;

    public Deodorant(int productNummer, String merk, String naam, int volume, double prijs, DeoType soort) {
        super(productNummer, merk, naam, volume, prijs);
        this.soort = soort;
    }


    public enum DeoType {VAPO, STICK}



}
