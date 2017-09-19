import be.oak3.model.AfterShave;
import be.oak3.model.BestellingImpl;
import be.oak3.model.Product;
import be.oak3.persistence.Bestelling;
import be.oak3.persistence.Data;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
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

        assertThat(product).extracting(Product::getMerk).contains("Yves Saint Lauren");
    }

    @Test
    public void sorteerTest() {
        bestelling.sorteer();
        List<Product> temp = new ArrayList<>();

        for (Product p : (ArrayList<Product>) bestelling) {

            temp.add(p);
        }


    }


}
