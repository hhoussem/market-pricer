import java.math.BigDecimal;

public class FixedPriceQuantityDeal implements Deal {

    private BigDecimal quantity;

    private BigDecimal price;

    public BigDecimal getQuantity() {
        return quantity;
    }

    public void setQuantity(BigDecimal quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public BigDecimal calculatePrice(Product product, BigDecimal totalQuantity) {
        BigDecimal price = new BigDecimal(0);
        FixedPriceQuantityDeal fpqDeal = (FixedPriceQuantityDeal) product.getDeal();
        BigDecimal nbDeal = totalQuantity.divideToIntegralValue(fpqDeal.getQuantity());
        if (nbDeal.compareTo(new BigDecimal(0)) > 0) {
            Unit unit = product.getPrice().getUnit();
            System.out.println("Deal : " + fpqDeal.getQuantity() +" " + unit +" " + product.getName()
                    + " for " + fpqDeal.getPrice() + MarketPricer.EURO+ " was applied " + nbDeal + " time(s)");
            price = price.add(nbDeal.multiply(fpqDeal.getPrice()));
            BigDecimal remainingQuantity = totalQuantity.remainder(fpqDeal.getQuantity());
            BigDecimal productUnitPrice = product.getPrice().getUnitPrice();
            System.out.println("Remaining quantity (" + remainingQuantity +unit + ") was sold for " + productUnitPrice + MarketPricer.EURO + " each");
            price = price.add(remainingQuantity.multiply(productUnitPrice));
            System.out.println("Total price is: "
                    +nbDeal+" * "+fpqDeal.getPrice()+" + "+remainingQuantity+" * "+productUnitPrice+" = "+price+ MarketPricer.EURO);
        }
        else{
            price = Deal.calculateNormalPrice(product,totalQuantity);
        }
        return price;
    }
}
