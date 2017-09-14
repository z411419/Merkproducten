package be.oak3.model;

import be.oak3.persistence.Bestelling;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

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


    public Product zoekDuursteProduct() {

        return Collections.max(bestelling, Comparator.comparing(p -> p.getPrijs()));
    }

    @Override
    public Double totalePrijs() {
        return bestelling.stream().mapToDouble(Product::getPrijs).sum();
    }

    @Override
    public void toonParfums() {
        bestelling.stream().filter(
                product -> product instanceof Parfum).forEach(System.out::println);

    }

}
