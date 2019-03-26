package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.Matchers.*;

public class BookKeeperTest {

    private DefaultTax defaultTax;
    private InvoiceRequest invoiceRequest;
    private ClientData clientData;
    private RequestItem requestItem;
    private ProductData productData;
    private BookKeeper bookKeeper;
    private Invoice invoice;

    @Before
    public void init() {
        bookKeeper = new BookKeeper();
        defaultTax = new DefaultTax();
        clientData = new ClientData(new Id("1"), "Tomek");
        invoice = Invoice.createInvoice(new Id("1"), clientData);
        invoiceRequest = new InvoiceRequest(clientData);

        productData = new ProductData(new Id("1"), new Money(1), "prod1", ProductType.DRUG, new Date());
        requestItem = new RequestItem(productData, 1, new Money(1));
        invoiceRequest.add(requestItem);
        invoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

        productData = new ProductData(new Id("1"), new Money(1), "prod2", ProductType.FOOD, new Date());
        requestItem = new RequestItem(productData, 1, new Money(1));
        invoiceRequest.add(requestItem);
        invoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

        productData = new ProductData(new Id("1"), new Money(1), "prod3", ProductType.STANDARD, new Date());
        requestItem = new RequestItem(productData, 1, new Money(1));
        invoiceRequest.add(requestItem);
        invoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

    }

    @Test
    public void issuanceTest() {
        Invoice givenInvoice = bookKeeper.issuance(invoiceRequest, defaultTax);

        for (int i = 0; i < givenInvoice.getItems().size(); i++) {
            Assert.assertThat(true, is(equalTo(givenInvoice.getItems().get(i).equals(invoice.getItems().get(i)))));
        }

    }

}
