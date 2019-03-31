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

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


public class BookKeeperTest {

    private RequestItem requestItem;
    private InvoiceRequest invoiceRequest;
    private ClientData clientData;
    private ProductData productData;
    private Invoice invoice;
    private DefaultTax defaultTax;
    private BookKeeper bookKeeper;

    @Before
    public void initialize(){
        bookKeeper = new BookKeeper();
        defaultTax = new DefaultTax();
        clientData = new ClientData(new Id("1"), "USER");
        invoice = Invoice.createInvoice(new Id("1"), clientData);
        invoiceRequest = new InvoiceRequest(clientData);

        productData = new ProductData(new Id("1"), new Money(1), "prd1", ProductType.DRUG, new Date());
        requestItem = new RequestItem(productData, 1, new Money(1));
        invoiceRequest.add(requestItem);
        invoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

        productData = new ProductData(new Id("1"), new Money(1), "prd2", ProductType.FOOD, new Date());
        requestItem = new RequestItem(productData, 1, new Money(1));
        invoiceRequest.add(requestItem);
        invoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

        productData = new ProductData(new Id("1"), new Money(1), "pr3", ProductType.STANDARD, new Date());
        requestItem = new RequestItem(productData, 1, new Money(1));
        invoiceRequest.add(requestItem);
        invoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

    }

    @Test
    public void issuance() {
        Invoice givenInvoice = bookKeeper.issuance(invoiceRequest, defaultTax);

        for (int i = 0; i < givenInvoice.getItems().size(); i++) {
            Assert.assertThat(false, is(equalTo(givenInvoice.getItems().get(i).equals(invoice.getItems().get(i)))));
        }
    }
}
