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
        FixedPriceQuantityDeal fpqDeal = (FixedPriceQuantityDeal) product.getDeal();
        int nbDeal = totalQuantity / fpqDeal.getQuantity();
        if(nbDeal > 0) {
            System.out.println("Deal : " + fpqDeal.getQuantity() + " " + product.getName()
                    + "(s) for " + fpqDeal.getPrice() + " € was applied " + nbDeal + " time(s)");
            price = price.add(new BigDecimal(nbDeal).multiply(fpqDeal.getPrice()));
            int remainingQuantity = totalQuantity % fpqDeal.getQuantity();
            System.out.println("Remaining quantity (" + remainingQuantity + ") was sold for " + product.getUnitPrice() + " each");
            price = price.add(new BigDecimal(remainingQuantity).multiply(product.getUnitPrice()));
            System.out.println("Total price is: "
                    +nbDeal+" * "+fpqDeal.getPrice()+" + "+remainingQuantity+" * "+product.getUnitPrice()+" = "+price+"€");
        }
        else{
            return calculateNormalPrice(product,totalQuantity);
        }
        return price;
    }

    private static BigDecimal calculateFreeQuantityDeal(Product product, int totalQuantity) {
        BigDecimal price = new BigDecimal(0);
        return price;
    }

}
