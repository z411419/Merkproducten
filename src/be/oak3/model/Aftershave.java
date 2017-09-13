package be.oak3.model;

public class AfterShave extends Product {

    private Soort soort;

    public AfterShave(int productNummer, String merk, String naam, int volume, double prijs, Soort soort) {
        super(productNummer, merk, naam, volume, prijs);
        this.soort = soort;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Product o1, Product o2) {
        return 0;
    }

    @Override
    public String toString() {

        return super.toString() + '\t' + soort;
    }

    public enum Soort {VAPO, GEL}
}
