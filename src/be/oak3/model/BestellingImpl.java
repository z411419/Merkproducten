package be.oak3.model;

import be.oak3.persistence.Bestelling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.DoubleStream;

public class BestellingImpl implements Bestelling {

    private static int productNummer = 1000;
    private List<Product> bestelling = new ArrayList<>();

    public BestellingImpl() {

    }

    @Override
    public void voegProductToe(Product artikel) {
        artikel.setProductNummer(productNummer += 1);
        //System.out.println(bestelling.toString());
        bestelling.add(artikel);

    }

    @Override
    public void sorteer() {
        //Collections.sort(bestelling, Comparator.naturalOrder());
        bestelling.stream().forEach(System.out::println);
    }

    @Override
    public void sorteerOpMerk() {
        bestelling.stream().sorted(Product.sorteerOpMerknaam()).forEach(System.out::println);
    }

    @Override
    public void sorteerOpVolume() {
        bestelling.stream().sorted((o1, o2) -> o1.getVolume() - o2.getVolume()).forEach(System.out::println);
    }

    @Override
    public void toonPerMerk(String merk) {

        bestelling.stream().filter(product -> product.getMerk().equals(merk)).forEach(System.out::println);

    }

    @Override
    public void toonGoedkopeProducten() {
        bestelling.stream().filter(product -> product.getPrijs() < 50).forEach(System.out::println);
    }

    @Override
    public Product zoekDuursteProduct() {
        return Collections.max(bestelling);
    }

    @Override
    public DoubleStream totalePrijs() {
        return bestelling.stream().mapToDouble(Product::getPrijs);
    }

    @Override
    public void toonParfums() {
        bestelling.stream().forEach(System.out::println);
    }

}
