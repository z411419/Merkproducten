package be.oak3.persistence;

import be.oak3.model.Product;

import java.util.stream.DoubleStream;

public interface Bestelling extends Berekenbaar {
    void voegProductToe(Product product);

    void sorteer();

    void sorteerOpMerk();

    void sorteerOpVolume();

    void toonPerMerk(String merk);

    void toonGoedkopeProducten();

    Product zoekDuursteProduct();

    void toonParfums();

    DoubleStream totalePrijs();


}
