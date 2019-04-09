package pl.com.bottega.ecommerce.sales.domain.invoicing;

import java.math.BigDecimal;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public class TaxCalculatorExample implements TaxCalculator {

    @Override
    public Tax calculate(RequestItem item) {
        Money net = item.getTotalCost();
        BigDecimal ratio = null;
        String desc = null;
        switch (item.getProductData()
                    .getType()) {
            case DRUG:
                ratio = BigDecimal.valueOf(0.05);
                desc = "5% (D)";
                break;
            case FOOD:
                ratio = BigDecimal.valueOf(0.07);
                desc = "7% (F)";
                break;
            case STANDARD:
                ratio = BigDecimal.valueOf(0.23);
                desc = "23%";
                break;

            default:
                throw new IllegalArgumentException(item.getProductData()
                                                       .getType()
                                                   + " not handled");
        }
        Money taxValue = net.multiplyBy(ratio);

        return new Tax(taxValue, desc);
    }

}
