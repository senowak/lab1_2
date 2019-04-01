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
import static org.junit.Assert.*;

public class InvoiceTest {
    Invoice invoice;
    InvoiceLine item;
    final int PRODUCT_PRICE = 455;
    final int ITEM_BRUT = 455;
    final int ITEM_NET = 366;

    @Before
    public void invoiceData() {
        invoice = Invoice.create(Id.generate(), new ClientData(Id.generate(), "user0"));
        ProductData product = new ProductData(Id.generate(), new Money(PRODUCT_PRICE), "cheese", ProductType.FOOD, new Date());

        item = new InvoiceLine(product, 1, new Money(ITEM_BRUT), new Tax(new Money(ITEM_NET), "fee"));
    }

    @Test
    public void ItemsAdd() {
        int itemsAdd = 45;
        for (int i = 0; i < itemsAdd; i++) {
            invoice.addItem(item);
        }
        Assert.assertThat(invoice.getItems().size(), is(itemsAdd));

        Assert.assertThat(invoice.getGros(), is(item.getGros().multiplyBy(itemsAdd)));

        Assert.assertThat(invoice.getNet(), is(item.getNet().multiplyBy(itemsAdd)));

    }

    @Test
    public void NullItemAdd() {
        invoice.addItem(null);
        Assert.assertThat(invoice.getItems().size(), is(0));
    }

    @Test
    public void InvoiceOnlyOneItemAdd() {
        invoice.addItem(item);
        Assert.assertThat(invoice.getItems().size(), is(1));
        Assert.assertThat(invoice.getGros(), is(item.getGros()));
        Assert.assertThat(invoice.getNet(), is(item.getNet()));
    }
}