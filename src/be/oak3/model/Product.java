package be.oak3.model;

import java.util.Comparator;

public abstract class Product {
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

    public void setProductNummer(int productNummer) {
        this.productNummer = productNummer;
    }

    public String getMerk() {
        return merk;
    }

    public int getVolume() {
        return volume;
    }

    public double getPrijs() {
        return prijs;
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
//        return  productNummer + " merk:'" + merk + '\t' +
//                "naam:" + naam + '\t' + "volume: " + volume +
//                "\t prijs:" + prijs + "\t Code:" + getProductCode() + "\n" ;

        return String.format("%-15d merk: %-20s naam: %-25s volume: %5dml \t prijs: %-10.2f Code: %-10s",
                productNummer, merk, naam, volume, prijs, getProductCode());

    }
}
