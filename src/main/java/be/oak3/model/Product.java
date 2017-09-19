package be.oak3.model;

import java.util.Comparator;

import static org.apache.commons.lang3.StringUtils.join;
import static org.apache.commons.lang3.StringUtils.left;

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

    public String getMerk() {
        return merk;
    }

    public String getNaam() {
        return naam;
    }

    public int getVolume() {
        return volume;
    }

    public double getPrijs() {
        return prijs;
    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    @Override
    public int hashCode() {
        return productNummer;
    }

    public String getProductCode() {
        //return (merk.substring(0, 3) + naam.substring(0, 3) + volume).toUpperCase().replace(" ", "_");
        return join(left(merk, 3), left(naam, 3), volume)
                .toUpperCase().replace(" ", "_");
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
