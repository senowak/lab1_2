package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.junit.Assert.*;

public class BookKeeperTest {
    private InvoiceRequest invoiceRequest;


    @Before
    public void initialize(){
        invoiceRequest = new InvoiceRequest(new ClientData(Id.generate(), "Data"));

    }

    @Test
    public void issuance() {
    }
}
