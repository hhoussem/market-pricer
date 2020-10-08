import java.math.BigDecimal;

public class Price {

    private Unit unit;

    private BigDecimal unitPrice;

    public Price(Unit unit, BigDecimal unitPrice) {
        this.unit = unit;
        this.unitPrice = unitPrice;
    }

    public Unit getUnit() {
        return unit;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }
}
