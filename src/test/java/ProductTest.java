import be.oak3.model.AfterShave;
import be.oak3.model.Deodorant;
import be.oak3.model.Parfum;
import be.oak3.model.Product;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ProductTest {

    @Test
    public void testProduct() {
        Product parfum = new Parfum(0, "Dolce & Gabbana", "Light Blue", 100, 66.72);
        assertThat(0).isEqualTo(parfum.getProductNummer());
        assertThat("Dolce & Gabbana").isEqualToIgnoringCase(parfum.getMerk());
        assertThat("Light Blue").isEqualToIgnoringCase(parfum.getNaam());
        assertThat(100).isEqualTo(parfum.getVolume());
        assertThat(66.72).isEqualTo(parfum.getPrijs());
    }

    @Test
    public void testProductCode() {
        Product deo = new Deodorant(0, "DKNY", "Be Delicious Women", 100, 33.65,
                Deodorant.DeoType.STICK);
        assertThat("DKNBE_100").isEqualTo(deo.getProductCode());
    }

    @Test
    public void testAftershave() {
        Product aftershave = new AfterShave(0, "Yves Saint Laurent", "Jazz", 50, 39.84,
                AfterShave.Soort.VAPO);
        assertThat(aftershave).hasFieldOrProperty("soort");
        assertThat(aftershave).isInstanceOf(Product.class);

    }

    @Test
    public void testDeodorant() {
        Product deo = new Deodorant(0, "DKNY", "Be Delicious Women", 50, 25.65,
                Deodorant.DeoType.STICK);
        assertThat(deo).hasFieldOrProperty("soort");
        assertThat(deo).isInstanceOf(Product.class);
    }

}
