package be.oak3.model;

public class Parfum extends Product {


    public Parfum(int productNummer, String merk, String naam, int volume, double prijs) {
        super(productNummer, merk, naam, volume, prijs);

    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public int compare(Product o1, Product o2) {
        return 0;
    }
}
