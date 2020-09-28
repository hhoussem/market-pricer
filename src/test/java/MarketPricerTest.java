import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MarketPricerTest {

    @Test
    public void calculateNormalPrice() {
        Product product = new Product();
        product.setName("Bottle 1L Milk");
        product.setUnitPrice(new BigDecimal(2));
        product.setDeal(null);

        Assert.assertEquals(new BigDecimal(12),MarketPricer.calculatePrice(product, 6));
    }

    @Test
    public void calculateFixedPriceQuantityDeal() {
        FixedPriceQuantityDeal fpqDeal = new FixedPriceQuantityDeal();
        fpqDeal.setQuantity(3);
        fpqDeal.setPrice(new BigDecimal("5.99"));

        Product product = new Product();
        product.setName("Cake 120g");
        product.setUnitPrice(new BigDecimal("2.50"));
        product.setDeal(fpqDeal);

        Assert.assertTrue(new BigDecimal("16.98").compareTo(MarketPricer.calculatePrice(product, 8)) == 0);
    }

    @Test
    public void calculateFreeQuantityDeal() {
        FreeQuantityDeal fqDeal = new FreeQuantityDeal();
        fqDeal.setConditionalQuantity(3);
        fqDeal.setFreeQuantity(2);

        Product product = new Product();
        product.setName("Yogurt pack 8 * 125g");
        product.setUnitPrice(new BigDecimal(2));
        product.setDeal(fqDeal);

        Assert.assertEquals(new BigDecimal(16),MarketPricer.calculatePrice(product, 12));
    }


}
