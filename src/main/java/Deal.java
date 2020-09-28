import java.math.BigDecimal;

public interface Deal {

    BigDecimal calculatePrice(Product product, int totalQuantity);

    static BigDecimal calculateNormalPrice(Product product, int totalQuantity) {
        System.out.println("No deal was detected on this product, calculating normal price...");
        BigDecimal price = product.getUnitPrice().multiply(new BigDecimal(totalQuantity));
        System.out.println("Total price is: "
                +totalQuantity+" * "+product.getUnitPrice()+" = "+price+ MarketPricer.EURO);
        return price;
    }
}
