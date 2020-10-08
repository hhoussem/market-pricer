import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class MarketPricerTest {

    @Test
    public void calculateNormalPrice() {
        Product product = new Product();
        product.setName("Bottle 1L Milk");
        product.setPrice(new Price(Unit.PIECE,new BigDecimal("2.01")));
        product.setDeal(null);

        Assert.assertEquals(new BigDecimal("12.06"),MarketPricer.calculatePrice(product, new BigDecimal(6)));
        Assert.assertNotEquals(new BigDecimal("12.060"),MarketPricer.calculatePrice(product, new BigDecimal(6)));
    }

    @Test
    public void calculateNormalPrice_KG_UNIT() {
        Product product = new Product();
        product.setName("Apple Golden CAT");
        product.setPrice(new Price(Unit.KG,new BigDecimal("1.50")));
        product.setDeal(null);

        Assert.assertEquals(new BigDecimal("6.30"),MarketPricer.calculatePrice(product, new BigDecimal("4.20")));
        Assert.assertNotEquals(new BigDecimal("6.3000"),MarketPricer.calculatePrice(product, new BigDecimal("4.20")));
    }

    @Test
    public void calculateFixedPriceQuantityDeal() {
        FixedPriceQuantityDeal fpqDeal = new FixedPriceQuantityDeal();
        fpqDeal.setQuantity(new BigDecimal("3"));
        fpqDeal.setPrice(new BigDecimal("5.99"));

        Product product = new Product();
        product.setName("Cake 120g");
        product.setPrice(new Price(Unit.PIECE,new BigDecimal("2.5")));
        product.setDeal(fpqDeal);

        Assert.assertEquals(new BigDecimal("5.00"),MarketPricer.calculatePrice(product, new BigDecimal("2")));
        Assert.assertNotEquals(new BigDecimal("5"),MarketPricer.calculatePrice(product, new BigDecimal("2")));
        Assert.assertEquals(new BigDecimal("5.99"),MarketPricer.calculatePrice(product, new BigDecimal("3")));
        Assert.assertEquals(new BigDecimal("16.98"),MarketPricer.calculatePrice(product, new BigDecimal("8")));
    }

    @Test
    public void calculateFixedPriceQuantityDeal_KG_UNIT() {
        FixedPriceQuantityDeal fpqDeal = new FixedPriceQuantityDeal();
        fpqDeal.setQuantity(new BigDecimal("1.5"));
        fpqDeal.setPrice(new BigDecimal("2.10"));

        Product product = new Product();
        product.setName("Strawberry");
        product.setPrice(new Price(Unit.KG,new BigDecimal("1.5")));
        product.setDeal(fpqDeal);

        Assert.assertEquals(new BigDecimal("2.85"),MarketPricer.calculatePrice(product, new BigDecimal("2")));
        Assert.assertEquals(new BigDecimal("2.03"),MarketPricer.calculatePrice(product, new BigDecimal("1.350")));
        Assert.assertNotEquals(new BigDecimal("2.025"),MarketPricer.calculatePrice(product, new BigDecimal("1.35")));
    }

    @Test
    public void calculateFreeQuantityDeal() {
        FreeQuantityDeal fqDeal = new FreeQuantityDeal();
        fqDeal.setConditionalQuantity(new BigDecimal("3"));
        fqDeal.setFreeQuantity(new BigDecimal("2"));

        Product product = new Product();
        product.setName("Yogurt pack 8 * 125g");
        product.setPrice(new Price(Unit.PIECE,new BigDecimal("2")));
        product.setDeal(fqDeal);

        Assert.assertNotEquals(new BigDecimal("2.0"),MarketPricer.calculatePrice(product, new BigDecimal("1")));
        Assert.assertEquals(new BigDecimal("2.00"),MarketPricer.calculatePrice(product, new BigDecimal("1")));
        Assert.assertEquals(new BigDecimal("6.00"),MarketPricer.calculatePrice(product, new BigDecimal("3")));
        Assert.assertEquals(new BigDecimal("8.00"),MarketPricer.calculatePrice(product, new BigDecimal("4")));
        Assert.assertEquals(new BigDecimal("6.00"),MarketPricer.calculatePrice(product, new BigDecimal("5")));
        Assert.assertEquals(new BigDecimal("8.00"),MarketPricer.calculatePrice(product, new BigDecimal("6")));
        Assert.assertEquals(new BigDecimal("16.00"),MarketPricer.calculatePrice(product, new BigDecimal("12")));
    }


}
