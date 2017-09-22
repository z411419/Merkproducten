import be.oak3.model.AfterShave;
import be.oak3.model.BestellingImpl;
import be.oak3.model.Parfum;
import be.oak3.model.Product;
import be.oak3.persistence.Bestelling;
import be.oak3.persistence.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BestellingImplTest {

    private Bestelling bestelling;


    @Before
    public void init() {
        List<Product> lijst = Data.getData();
        bestelling = new BestellingImpl();
        for (Product artikel : lijst) {
            bestelling.voegProductToe(artikel);
        }
    }

    @Test
    public void voegProductToeTest() {
        Product product = new AfterShave(0, "Yves Saint Lauren", "Jazz", 50, 39.84,
                AfterShave.Soort.VAPO);
        bestelling.voegProductToe(product);

        assertThat(bestelling.getBestelling().get(11)).extracting(Product::getMerk).contains("Yves Saint Lauren");
    }

    @Test
    public void sorteerTest() {
        bestelling.sorteer();
        assertThat(bestelling.getBestelling().get(0)).isNotNull();
        assertThat(bestelling.getBestelling().get(0).getNaam()).isEqualTo("Light Blue");
        assertThat(bestelling.getBestelling().get(1).getNaam()).isEqualTo("BLV");

        //System.out.println(bestelling);
        assertThat(bestelling).isInstanceOf(BestellingImpl.class);
    }

    @Test
    public void sorteerOpMerkTest() {
        bestelling.sorteerOpMerk();

        assertThat(bestelling.getBestelling().get(0).getNaam()).isEqualTo("BLV");
        assertThat(bestelling.getBestelling().get(1).getNaam()).isEqualTo("Anais");

        //System.out.println(bestelling);
        assertThat(bestelling).isInstanceOf(BestellingImpl.class);
    }

    @Test
    public void sorteerOpMerkVolume() {

        bestelling.sorteerOpVolume();

        assertThat(bestelling.getBestelling().get(0).getNaam()).isEqualTo("Code Donna");
        assertThat(bestelling.getBestelling().get(1).getNaam()).isEqualTo("Code Donna");

        //System.out.println(bestelling);
        assertThat(bestelling).isInstanceOf(BestellingImpl.class);
    }


    @Test
    public void zoekDuursteProductTest() {
        assertThat(bestelling.zoekDuursteProduct().getPrijs()).isEqualTo(76.0);
    }

    @Test
    public void totalePrijsTest() {
        assertThat(bestelling.totalePrijs()).isEqualTo(579.05);
    }

    @Test
    public void lijstVanBepaaldMerkTest() {
        //System.out.println(bestelling.lijstVanBepaaldMerk("BVLGARI"));
        //System.out.println(bestelling.lijstVanParfums());
        assertThat(bestelling.lijstVanBepaaldMerk("BVLGARI")).isNotNull();
        assertThat(bestelling.lijstVanBepaaldMerk("BVLGARI")).isNotEmpty();
        assertThat(bestelling.lijstVanBepaaldMerk("Georgio Armani")).extracting(Product::getMerk).containsOnly("Georgio Armani");
    }

    @Test
    public void lijstVanParfumsTest() {
        assertThat(bestelling.lijstVanParfums()).isNotNull();
        int i = 0;
        List<Product> temp = bestelling.getBestelling();
        for (Product product : temp) if (product instanceof Parfum) i++;
        assertThat(bestelling.lijstVanParfums()).hasSize(i);
        assertThat(bestelling.lijstVanParfums()).hasOnlyElementsOfType(Parfum.class);
        assertThat(bestelling.lijstVanParfums().get(0)).isInstanceOf(Parfum.class);

        long temp1 = bestelling.getBestelling().stream().filter(product -> product.getMerk().equalsIgnoreCase("Georgio Armani")).count();
        System.out.println(temp1);
    }

    @Test
    public void lijstVanGoedkopeProducten() {
        assertThat(bestelling.lijstVanGoedkopeProducten()).isNotNull();

        assertThat(bestelling.lijstVanGoedkopeProducten().get(0).getPrijs() < 50);

    }


}
