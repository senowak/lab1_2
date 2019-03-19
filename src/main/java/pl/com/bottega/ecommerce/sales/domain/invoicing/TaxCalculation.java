package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxCalculation {

    Tax calculateTax(RequestItem item);

}
