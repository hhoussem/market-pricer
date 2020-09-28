import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        // Milka with no deal
        Product milka = new Product();
        milka.setName("Milka 100g");
        milka.setUnitPrice(new BigDecimal("2"));
        milka.setDeal(null);

        MarketPricer.calculatePrice(milka,7);

        //Ferrero Rocher with Fixed Price Quantity Deal : 5 for 9.99
        FixedPriceQuantityDeal ferreroDeal = new FixedPriceQuantityDeal();
        ferreroDeal.setQuantity(5);
        ferreroDeal.setPrice(new BigDecimal("9.99"));

        Product ferrero = new Product();
        ferrero.setName("Ferrero Rocher 125g");
        ferrero.setUnitPrice(new BigDecimal("2.50"));
        ferrero.setDeal(ferreroDeal);

        MarketPricer.calculatePrice(ferrero,5);

        //Rafaello with Free Quantity Deal : buy 3 get 1 for free
        FixedPriceQuantityDeal rafaelloDeal = new FixedPriceQuantityDeal();
        rafaelloDeal.setQuantity(5);
        rafaelloDeal.setPrice(new BigDecimal("9.99"));

        Product rafaello = new Product();
        rafaello.setName("Rafaello 75g");
        rafaello.setUnitPrice(new BigDecimal("2.50"));
        rafaello.setDeal(rafaelloDeal);

        MarketPricer.calculatePrice(rafaello,6);
    }
}
