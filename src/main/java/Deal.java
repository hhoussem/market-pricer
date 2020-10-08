import java.math.BigDecimal;

public interface Deal {

    BigDecimal calculatePrice(Product product, BigDecimal totalQuantity);

    static BigDecimal calculateNormalPrice(Product product, BigDecimal totalQuantity) {
        System.out.println("No deal was detected on this product, calculating normal price...");
        Price price = product.getPrice();
        BigDecimal totalPrice = price.getUnitPrice().multiply(totalQuantity);
        System.out.println("Total price of " + totalQuantity + " " + price.getUnit() + "(s) of " + product.getName() + " is: "
                + totalQuantity + " * " + price.getUnitPrice() + " = " + totalPrice + MarketPricer.EURO);
        return totalPrice;
    }
}
