import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class MarketPricer {

    public static final char EURO = '€';
    public static final int SCALE = 2;

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
        BigDecimal price;
        if (product.getDeal() == null) {
            price = Deal.calculateNormalPrice(product,totalQuantity);
        }
        else {
            price = deal.calculatePrice(product, totalQuantity);
        }
        return price.setScale(SCALE, RoundingMode.CEILING);
    }

}
