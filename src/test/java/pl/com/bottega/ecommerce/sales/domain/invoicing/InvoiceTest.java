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
    final int PRICE_ITEM = 1;
    final int PRICE_NET = 20;
    final int PRICE_GROS = 40;

    @Before
    public void setUp() {
        Id invoiceId = Id.generate();
        Id clientId = Id.generate();
        Id productId = Id.generate();
        Money price = Money.ZERO;
        ProductType type = ProductType.FOOD;
        Date snapshotDate = new Date();
        ClientData client = new ClientData(clientId, "dssdf");
        invoice = Invoice.create(invoiceId, client);
        ProductData product = new ProductData(productId, price, "sewrefw", type, snapshotDate);
    }

    @Test
    public void addItem() {

//        Assert.assertThat(,is(true));
    }

    @Test
    public void create() {
    }
}