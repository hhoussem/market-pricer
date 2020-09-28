import java.math.BigDecimal;

public class FixedPriceQuantityDeal implements Deal {

    private int quantity;

    private BigDecimal price;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculatePrice(Product product, int totalQuantity) {
        BigDecimal price = new BigDecimal(0);
        FixedPriceQuantityDeal fpqDeal = (FixedPriceQuantityDeal) product.getDeal();
        int nbDeal = totalQuantity / fpqDeal.getQuantity();
        if(nbDeal > 0) {
            System.out.println("Deal : " + fpqDeal.getQuantity() + " " + product.getName()
                    + "(s) for " + fpqDeal.getPrice() + MarketPricer.EURO+ " was applied " + nbDeal + " time(s)");
            price = price.add(new BigDecimal(nbDeal).multiply(fpqDeal.getPrice()));
            int remainingQuantity = totalQuantity % fpqDeal.getQuantity();
            System.out.println("Remaining quantity (" + remainingQuantity + ") was sold for " + product.getUnitPrice() + " each");
            price = price.add(new BigDecimal(remainingQuantity).multiply(product.getUnitPrice()));
            System.out.println("Total price is: "
                    +nbDeal+" * "+fpqDeal.getPrice()+" + "+remainingQuantity+" * "+product.getUnitPrice()+" = "+price+ MarketPricer.EURO);
        }
        else{
            price = Deal.calculateNormalPrice(product,totalQuantity);
        }
        return price;
    }
}
