package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class BookKeeperTest {

    private List<RequestItem> expectedList;
    private ClientData clientData;
    private Invoice invoice;

    @Before public void initialize() {

        TaxCalculation defaultTax = new DefaultTax();
        clientData = new ClientData(new Id("1"), "Jon Smith");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        expectedList = new LinkedList<>();

        for (int i = 0; i < 3; i++) {
            ProductData productData = new ProductData(new Id(String.valueOf(i)), new Money(new BigDecimal("10")), "testProduct",
                    ProductType.FOOD, new Date(2013, 02, 01));
            RequestItem requestItem = new RequestItem(productData, 1, new Money(new BigDecimal("10")));
            invoiceRequest.add(requestItem);

        }

        BookKeeper bookKeeper = new BookKeeper();
        invoice = bookKeeper.issuance(invoiceRequest, defaultTax);

    }

    @Test public void issuanceProductsTest() {

        Iterator expectedListIterator = expectedList.iterator();
        Iterator invoiceRequestIterator = invoice.getItems().iterator();

        for (int i = 0; i < expectedList.size(); i++) {

            RequestItem expected = (RequestItem) expectedListIterator.next();
            InvoiceLine invoiceLine = (InvoiceLine) invoiceRequestIterator.next();

            assertThat(invoiceLine.getProduct(), Is.is(expected.getProductData()));

        }

    }

    @Test public void issuanceClientTest() {

        assertThat(invoice.getClient(), Is.is(clientData));

    }

}
