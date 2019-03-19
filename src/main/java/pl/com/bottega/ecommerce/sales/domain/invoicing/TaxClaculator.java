package pl.com.bottega.ecommerce.sales.domain.invoicing;

public interface TaxClaculator {

    public Tax calculate (RequestItem requestItem);

}
