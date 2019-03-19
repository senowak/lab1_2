package pl.com.bottega.ecommerce.sales.domain.invoicing;

import pl.com.bottega.ecommerce.sharedkernel.Money;

public interface Calculator {
    Tax calculate(RequestItem requestItem);
}
