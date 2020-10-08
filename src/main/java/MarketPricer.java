import java.math.BigDecimal;

public class MarketPricer {

    public static final char EURO = '€';

    /**
     *
     * @param product
     * @param totalQuantity
     * @return price of quantity product that can have a deal (or not)
     */
    public static BigDecimal calculatePrice(Product product, BigDecimal totalQuantity) {
        System.out.println("----------------");
        System.out.println("Calculating price of "+totalQuantity+" "+product.getPrice().getUnit()+"(s) of "+product.getName()
                +" with unit price "+product.getPrice().getUnitPrice()+ MarketPricer.EURO);
        Deal deal = product.getDeal();
        if (product.getDeal() == null) {
            return Deal.calculateNormalPrice(product,totalQuantity);
        }
        else {
            return deal.calculatePrice(product, totalQuantity);
        }
    }

}
