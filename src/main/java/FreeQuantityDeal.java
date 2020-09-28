import java.math.BigDecimal;

public class FreeQuantityDeal implements Deal{

    private int conditionalQuantity;

    private int freeQuantity;

    public int getConditionalQuantity() {
        return conditionalQuantity;
    }

    public void setConditionalQuantity(int conditionalQuantity) {
        this.conditionalQuantity = conditionalQuantity;
    }

    public int getFreeQuantity() {
        return freeQuantity;
    }

    public void setFreeQuantity(int freeQuantity) {
        this.freeQuantity = freeQuantity;
    }

    @Override
    public BigDecimal calculatePrice(Product product, int totalQuantity) {
        BigDecimal price = new BigDecimal(0);
        FreeQuantityDeal fqDeal = (FreeQuantityDeal) product.getDeal();
        int nbDeal = totalQuantity / (fqDeal.getConditionalQuantity() + fqDeal.getFreeQuantity());
        if(nbDeal > 0) {
            System.out.println("Deal : buy " + fqDeal.getConditionalQuantity() + " " + product.getName()
                    + "(s), get " + fqDeal.getFreeQuantity() + " for free was applied " + nbDeal + " time(s)");
            int quantityToPrice = totalQuantity - (nbDeal * fqDeal.getFreeQuantity());
            System.out.println("Only " + quantityToPrice+" "+product.getName()+ " was priced");
            price = new BigDecimal(quantityToPrice).multiply(product.getUnitPrice());
            System.out.println("Total price is: "+quantityToPrice+" * "+product.getUnitPrice()+" = "+price+ MarketPricer.EURO);
        }
        else{
            price = Deal.calculateNormalPrice(product,totalQuantity);
        }
        return price;
    }
}
