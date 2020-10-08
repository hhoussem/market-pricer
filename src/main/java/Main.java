import java.math.BigDecimal;

public class Main {


    public static void main(String[] args) {
        // Milka with no deal
        Product milka = new Product();
        milka.setName("Milka 100g");
        milka.setPrice(new Price(Unit.PIECE,new BigDecimal("2")));
        milka.setDeal(null);

        MarketPricer.calculatePrice(milka,new BigDecimal("7"));

        //Ferrero Rocher with Fixed Price Quantity Deal : 5 for 9.99
        FixedPriceQuantityDeal ferreroDeal = new FixedPriceQuantityDeal();
        ferreroDeal.setQuantity(new BigDecimal("5"));
        ferreroDeal.setPrice(new BigDecimal("9.99"));

        Product ferrero = new Product();
        ferrero.setName("Ferrero Rocher 125g");
        ferrero.setPrice(new Price(Unit.PIECE,new BigDecimal("2.50")));
        ferrero.setDeal(ferreroDeal);

        MarketPricer.calculatePrice(ferrero,new BigDecimal("5"));

        //Rafaello with Free Quantity Deal : buy 3 get 1 for free
        FixedPriceQuantityDeal rafaelloDeal = new FixedPriceQuantityDeal();
        rafaelloDeal.setQuantity(new BigDecimal("5"));
        rafaelloDeal.setPrice(new BigDecimal("9.99"));

        Product rafaello = new Product();
        rafaello.setName("Rafaello 75g");
        rafaello.setPrice(new Price(Unit.PIECE,new BigDecimal("2.50")));
        rafaello.setDeal(rafaelloDeal);

        MarketPricer.calculatePrice(rafaello,new BigDecimal("6"));
    }
}
