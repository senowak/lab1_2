package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxInterface {

    Tax calculate(RequestItem item);
}
