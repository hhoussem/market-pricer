import java.math.BigDecimal;

public class MarketPricer {

    public static final char EURO = '€';

    /**
     *
     * @param product
     * @param totalQuantity
     * @return price of quantity product that can have a deal (or not)
     */
    public static BigDecimal calculatePrice(Product product, int totalQuantity) {
        System.out.println("----------------");
        System.out.println("Calculating price of "+totalQuantity+" "+product.getName() +"(s) with unit price "+product.getUnitPrice());
        Deal deal = product.getDeal();
        if (product.getDeal() == null) {
            return Deal.calculateNormalPrice(product,totalQuantity);
        }
        else {
            return deal.calculatePrice(product, totalQuantity);
        }
    }

}
