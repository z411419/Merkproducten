package be.oak3.model;

import be.oak3.persistence.Bestelling;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BestellingImpl implements Bestelling {

    private static int productNummer = 1000;
    private static final Logger logger = LogManager.getLogger();
    private List<Product> bestelling = Lists.newArrayList();

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
        bestelling.stream().sorted(Comparator.comparing(Product::getProductNummer)).forEach(logger::info);
    }

    @Override
    public void sorteerOpMerk() {
        bestelling.stream().sorted(Product.sorteerOpMerknaam()).forEach(logger::info);
    }

    @Override
    public void sorteerOpVolume() {
        bestelling.stream().sorted(Comparator.comparingInt(Product::getVolume)).forEach(logger::info);
    }

    @Override
    public void toonPerMerk(String merk) {

        bestelling.stream().filter(product -> product.getMerk().equals(merk)).forEach(logger::info);

    }

    @Override
    public void toonGoedkopeProducten() {
        bestelling.stream().filter(product -> product.getPrijs() < 50).forEach(logger::info);
    }


    public Product zoekDuursteProduct() {

        return Collections.max(bestelling, Comparator.comparing(Product::getPrijs));
    }

    @Override
    public Double totalePrijs() {
        return bestelling.stream().mapToDouble(Product::getPrijs).sum();
    }

    @Override
    public void toonParfums() {
        bestelling.stream().filter(
                product -> product instanceof Parfum).forEach(logger::info);

    }

}
