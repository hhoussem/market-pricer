import java.math.BigDecimal;

public class MarketPricer {

    public static void main(String[] args) {
        System.out.println("Hello from Market pricer");
    }

    public static BigDecimal calculatePrice(Product product, int totalQuantity) {
        System.out.println("Calculating price of "+totalQuantity+" "+product.getName() +"(s) with unit price "+product.getUnitPrice());
        Deal deal = product.getDeal();
        if (product.getDeal() == null) {
            return calculateNormalPrice(product,totalQuantity);
        } else {
            if (deal instanceof FixedPriceQuantityDeal) {
                return calculateFixedPriceQuantity(product, totalQuantity);
            }
            else if (deal instanceof FreeQuantityDeal) {
                return calculateFreeQuantityDeal(product, totalQuantity);
            }
            else{
                return calculateNormalPrice(product,totalQuantity);
            }
        }
    }

    private static BigDecimal calculateNormalPrice(Product product, int totalQuantity) {
        System.out.println("No deal was detected on this product, calculating normal price...");
        BigDecimal price = product.getUnitPrice().multiply(new BigDecimal(totalQuantity));
        System.out.println("Total price is: "
                +totalQuantity+" * "+product.getUnitPrice()+" = "+price+"€");
        return price;
    }

    private static BigDecimal calculateFixedPriceQuantity(Product product, int totalQuantity) {
        BigDecimal price = new BigDecimal(0);
        return price;
    }

    private static BigDecimal calculateFreeQuantityDeal(Product product, int totalQuantity) {
        BigDecimal price = new BigDecimal(0);
        return price;
    }

}
