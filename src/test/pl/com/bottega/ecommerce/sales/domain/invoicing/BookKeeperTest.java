package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;

public class BookKeeperTest {

    private InvoiceRequest invoiceRequest;
    private TaxCalculator taxCalculator;
    private Invoice expectedInvoice;

    @Before
    public void initialize() {
        invoiceRequest = new InvoiceRequest(new ClientData(Id.generate(), "ClientData1"));

        invoiceRequest.add(new RequestItem(
                new ProductData(new Id("1"), new Money(new BigDecimal(100)), "ProductDrugForTest", ProductType.DRUG, new Date()), 1,
                new Money(new BigDecimal(100))));
        // here
    }

    @Test
    public void issuance() {

    }
}
