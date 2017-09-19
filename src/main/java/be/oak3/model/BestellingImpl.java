package be.oak3.model;

import be.oak3.persistence.Bestelling;
import com.google.common.collect.Lists;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BestellingImpl implements Bestelling {

    private static int productNummer = 1000;
    private static final Logger logger = LogManager.getLogger();
    private List<Product> bestelling = Lists.newArrayList();

    public BestellingImpl() {
    }

    @Override
    public void voegProductToe(Product artikel) {
        artikel.setProductNummer(productNummer += 1);
        bestelling.add(artikel);
    }

    @Override
    public void sorteer() {
        //Collections.sort(bestelling, Comparator.naturalOrder());
        bestelling.stream().sorted(Comparator.comparing(Product::getProductNummer)).forEach(logger::info);
        //logger.info(productNummer);
    }

    @Override
    public void sorteerOpMerk() {
        bestelling.stream().sorted(Product.sorteerOpMerknaam()).forEach(logger::info);
    }

    @Override
    public void sorteerOpVolume() {
        bestelling.stream().sorted(Comparator.comparingInt(Product::getVolume)).forEach(logger::info);
    }

/*    @Override
    public void toonPerMerk(String merk) {
        bestelling.stream().filter(product -> product.getMerk().equals(merk)).forEach(logger::info);
    }*/

/*    @Override
    public void toonGoedkopeProducten() {
        bestelling.stream().filter(product -> product.getPrijs() < 50).forEach(logger::info);
    }*/


    public Product zoekDuursteProduct() {

        return Collections.max(bestelling, Comparator.comparing(Product::getPrijs));
    }

    @Override
    public Double totalePrijs() {
        return bestelling.stream().mapToDouble(Product::getPrijs).sum();
    }

    @Override
    public List<Product> lijstVanBepaaldMerk(String merk) {
        List<Product> result = bestelling.stream().filter(product -> product.equals(merk)).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Product> lijstVanParfums() {
        List<Product> result = bestelling.stream().filter(product -> product instanceof Parfum).collect(Collectors.toList());
        return result;
    }

    @Override
    public List<Product> lijstVanGoedkopeProducten() {
        List<Product> result = bestelling.stream().filter(product -> product.getPrijs() < 50).collect(Collectors.toList());
        return result;
    }

 /*   @Override
    public void toonParfums() {
        bestelling.stream().filter(
                product -> product instanceof Parfum).forEach(logger::info);

    }*/

}
