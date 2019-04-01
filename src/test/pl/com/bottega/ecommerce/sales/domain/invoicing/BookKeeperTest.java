package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.ClientData;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class BookKeeperTest {

    private InvoiceRequest invoiceRequest;
    private DefaultTax defaultTax;
    private Invoice expectedInvoice;
    private BookKeeper bookKeeper;

    @Before
    public void initialize() {
        bookKeeper = new BookKeeper();
        defaultTax = new DefaultTax();
        ClientData clientData = new ClientData(new Id("1"), "ClientData1");
        invoiceRequest = new InvoiceRequest(clientData);
        expectedInvoice = new Invoice(new Id("1"), clientData);

        RequestItem requestItem = new RequestItem(
                new ProductData(new Id("1"), new Money(new BigDecimal(100)), "ProductDrugForTest1", ProductType.DRUG, new Date()), 1,
                new Money((new BigDecimal(100))));
        invoiceRequest.add(requestItem);
        expectedInvoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

        requestItem = new RequestItem(
                new ProductData(new Id("2"), new Money(new BigDecimal(100)), "ProductFoodForTest1", ProductType.FOOD, new Date()), 1,
                new Money((new BigDecimal(100))));
        invoiceRequest.add(requestItem);
        expectedInvoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

        requestItem = new RequestItem(
                new ProductData(new Id("3"), new Money(new BigDecimal(80)), "ProductStandardForTest1", ProductType.STANDARD, new Date()), 1,
                new Money((new BigDecimal(80))));
        invoiceRequest.add(requestItem);
        expectedInvoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));

        requestItem = new RequestItem(
                new ProductData(new Id("4"), new Money(new BigDecimal(120)), "ProductDrugForTest2", ProductType.DRUG, new Date()), 1,
                new Money((new BigDecimal(120))));
        invoiceRequest.add(requestItem);
        expectedInvoice.addItem(new InvoiceLine(requestItem.getProductData(), requestItem.getQuantity(), requestItem.getTotalCost(),
                defaultTax.calculate(requestItem)));
    }

    @Test
    public void issuance() {
        Invoice invoice = bookKeeper.issuance(invoiceRequest, defaultTax);
        for (int i = 0; i < invoice.getItems().size(); i++) {
            Assert.assertThat(expectedInvoice.getItems().get(i).getGros(), is(equalTo(invoice.getItems().get(i).getGros())));
            Assert.assertThat(expectedInvoice.getItems().get(i).getNet(), is(equalTo(invoice.getItems().get(i).getNet())));
            Assert.assertThat(expectedInvoice.getItems().get(i).getQuantity(), is(equalTo(invoice.getItems().get(i).getQuantity())));
            Assert.assertThat(expectedInvoice.getItems().get(i).getTax().getDescription(),
                    is(equalTo(invoice.getItems().get(i).getTax().getDescription())));
            Assert.assertThat(expectedInvoice.getItems().get(i).getTax().getAmount(),
                    is(equalTo(invoice.getItems().get(i).getTax().getAmount())));
            Assert.assertThat(expectedInvoice.getItems().get(i).getProduct(), is(equalTo(invoice.getItems().get(i).getProduct())));
        }
    }
}
