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

import static org.hamcrest.CoreMatchers.is;

public class InvoiceTest {

    Invoice invoice;
    InvoiceLine item;
    final int PRODUCT_PRICE = 20;
    final int ITEM_NET = 20;
    final int ITEM_TAX = 5;

    @Before
    public void setUp() {
        invoice = Invoice.create(Id.generate(), new ClientData(Id.generate(), "user1"));
        ProductData product = new ProductData(Id.generate(), new Money(PRODUCT_PRICE), "cheese", ProductType.FOOD, new Date());

        item = new InvoiceLine(product, 1, new Money(ITEM_NET), new Tax(new Money(ITEM_TAX), "fee"));
    }

    @Test
    public void InvoiceWithOneItemAdded() {
        invoice.addItem(item);
        Assert.assertThat(invoice.getItems()
                                 .size(),
                is(1));
        Assert.assertThat(invoice.getGros(), is(item.getGros()));
        Assert.assertThat(invoice.getNet(), is(item.getNet()));
    }

    @Test
    public void NullItemAdded() {
        invoice.addItem(null);
        Assert.assertThat(invoice.getItems()
                                 .size(),
                is(0));
    }
