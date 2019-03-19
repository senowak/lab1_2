package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;

public interface TaxCalculator {
    public Tax compute(RequestItem requestItem, Money money);
}
