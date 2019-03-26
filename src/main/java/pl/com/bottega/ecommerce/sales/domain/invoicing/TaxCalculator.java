package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public interface TaxCalculator {
    public Tax getTax(RequestItem item, Money net);
}
