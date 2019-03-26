package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

public class BookKeeperTest {

    BookKeeper bookKeeper = new BookKeeper();
    DefaultTax defaultTax = new DefaultTax();
    Money testValue = new Money(10);
    Tax tax = new Tax(testValue, "");
    @Test public void checkingIfIssuanceMethodReturnsRightInvoiceGetClient() {
        ClientData clientData = new ClientData(new Id("0"), "Kowalski");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        assertEquals(clientData, bookKeeper.issuance(invoiceRequest, defaultTax).getClient());
    }

    @Test public void checkingIfIssuanceMethodReturnsRightInvoiceGetItems() {
        ClientData clientData = new ClientData(new Id("0"), "Kowalski");
        InvoiceRequest invoiceRequest = new InvoiceRequest(clientData);
        ProductData productData = new ProductData(new Id("0"), testValue, "Testowy", ProductType.DRUG,
                new Date(System.currentTimeMillis()));
        RequestItem requestItem = new RequestItem(productData, 1, testValue);
        InvoiceLine invoiceLine = new InvoiceLine(productData, 1, testValue, tax);
        List<InvoiceLine> list = new ArrayList();
        list.add(invoiceLine);
        invoiceRequest.add(requestItem);
        assertEquals(list.get(0).getProduct(), bookKeeper.issuance(invoiceRequest, defaultTax).getItems().get(0).getProduct());
    }
}
