package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxCalculator {

    public Tax calculateTax(RequestItem requestItem);

}
