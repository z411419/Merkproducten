package be.oak3.persistence;

import be.oak3.model.Product;

import java.util.List;

public interface Bestelling extends Berekenbaar {
    void voegProductToe(Product product);

    void sorteer();

    void sorteerOpMerk();

    void sorteerOpVolume();

    //void toonPerMerk(String merk);

    //void toonGoedkopeProducten();

    Product zoekDuursteProduct();

    //void toonParfums();

    Double totalePrijs();

    List<Product> lijstVanBepaaldMerk(String merk);

    List<Product> lijstVanParfums();

    List<Product> lijstVanGoedkopeProducten();

    List<Product> getBestelling();


}
