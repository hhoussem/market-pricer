import java.math.BigDecimal;

public class MarketPricer {

    public static void main(String[] args) {
        System.out.println("Hello from Market pricer");
    }

    public static BigDecimal calculatePrice(Product product, int totalQuantity) {
       return product.getUnitPrice().multiply(new BigDecimal(totalQuantity));
    }

}
