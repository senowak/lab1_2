package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;

import static org.junit.Assert.*;

public class BookKeeperTest {

    BookKeeper bookKeeper = new BookKeeper();
    DefaultTax defaultTax = new DefaultTax();

    @Test public void checkingIfIssuanceMethodReturnsRightInvoiceGetClient() {
        ClientData clientData = new ClientData(new Id("0"), "Kowalski");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        assertEquals(clientData, bookKeeper.issuance(invoiceRequest, defaultTax).getClient());
    }

}
