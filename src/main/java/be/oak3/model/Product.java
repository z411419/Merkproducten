package be.oak3.model;

import java.util.Comparator;

public abstract class Product {
    private int productNummer;
    private String merk;
    private String naam;
    private int volume;
    private double prijs;

    Product(int productNummer, String merk, String naam, int volume, double prijs) {
        this.productNummer = productNummer;
        this.merk = merk;
        this.naam = naam;
        this.volume = volume;
        this.prijs = prijs;
    }

    static Comparator<Product> sorteerOpMerknaam() {
        return Comparator.comparing(Product::getMerk);

    }

    String getMerk() {
        return merk;
    }

    int getVolume() {
        return volume;
    }

    double getPrijs() {
        return prijs;
    }

    int getProductNummer() {
        return productNummer;
    }

    void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    @Override
    public int hashCode() {
        return productNummer;
    }

    private String getProductCode() {
        return (merk.substring(0, 3) + naam.substring(0, 3) + volume).toUpperCase().replace(" ", "_");
    }

    @Override
    public String toString() {
//        return  productNummer + " merk:'" + merk + '\t' +
//                "naam:" + naam + '\t' + "volume: " + volume +
//                "\t prijs:" + prijs + "\t Code:" + getProductCode() + "\n" ;

        return String.format("%-15d merk: %-20s naam: %-25s volume: %5dml \t prijs: %-10.2f Code: %-10s",
                productNummer, merk, naam, volume, prijs, getProductCode());

    }
}
