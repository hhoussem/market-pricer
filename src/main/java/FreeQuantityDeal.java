import java.math.BigDecimal;

public class FreeQuantityDeal implements Deal{

    private BigDecimal conditionalQuantity;

    private BigDecimal freeQuantity;

    public BigDecimal getConditionalQuantity() {
        return conditionalQuantity;
    }

    public void setConditionalQuantity(BigDecimal conditionalQuantity) {
        this.conditionalQuantity = conditionalQuantity;
    }

    public BigDecimal getFreeQuantity() {
        return freeQuantity;
    }

    public void setFreeQuantity(BigDecimal freeQuantity) {
        this.freeQuantity = freeQuantity;
    }

    @Override
    public BigDecimal calculatePrice(Product product, BigDecimal totalQuantity) {
        BigDecimal price;
        FreeQuantityDeal fqDeal = (FreeQuantityDeal) product.getDeal();
        BigDecimal nbDeal = totalQuantity.divideToIntegralValue(fqDeal.getConditionalQuantity().add(fqDeal.getFreeQuantity()));
        if(nbDeal.compareTo(new BigDecimal("0")) > 0) {
            System.out.println("Deal : buy " + fqDeal.getConditionalQuantity() + " " + product.getName()
                    + "(s), get " + fqDeal.getFreeQuantity() + " for free was applied " + nbDeal + " time(s)");
            BigDecimal quantityToPrice = totalQuantity.subtract(nbDeal.multiply(fqDeal.getFreeQuantity()));
            BigDecimal productUnitPrice = product.getPrice().getUnitPrice();
            System.out.println("Only " + quantityToPrice + " " + product.getName() + " was priced");
            price = quantityToPrice.multiply(productUnitPrice);
            System.out.println("Total price is: " + quantityToPrice + " * " + productUnitPrice + " = " + price + MarketPricer.EURO);
        }
        else{
            price = Deal.calculateNormalPrice(product, totalQuantity);
        }
        return price;
    }
}
