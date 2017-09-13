package be.oak3.model;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public abstract class Product implements Comparator<Product> {
    private int productNummer;
    private String merk;
    private String naam;
    private int volume;
    private double prijs;

    public Product(int productNummer, String merk, String naam, int volume, double prijs) {
        this.productNummer = productNummer;
        this.merk = merk;
        this.naam = naam;
        this.volume = volume;
        this.prijs = prijs;
    }

    public int getProductNummer() {
        return productNummer;
    }

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getMerk() {
        return merk;
    }

    public void setMerk(String merk) {
        this.merk = merk;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product producten = (Product) o;

        return productNummer == producten.productNummer;
    }

    @Override
    public int hashCode() {
        return productNummer;
    }

    public String getProductCode(){
        return (merk.substring(0,3) + naam.substring(0,3) + volume).toUpperCase().replace(" ","_");
    }


    public static Comparator<Product> sorteerOpMerknaam(){
            return(o1,o2) -> o1.getMerk().compareTo(o2.getMerk());

        }

    @Override
    public String toString() {
        return "Lijst gesorteerd op natuurlijke volgorde:\n" +
                productNummer + " merk:'" + merk + '\t' +
                "naam:" + naam + '\t' + "volume: " + volume +
                "\t prijs:" + prijs + "\t Code:" + getProductCode() ;
    }
}
