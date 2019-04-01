package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;

import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;
import java.util.Date;

public class TestDefaultTaxCalculator {

    @Test
    public void testGetTax(){
        Id id = new Id("1");
        ProductType pt = ProductType.FOOD;
        String name = "pizza";
        Money price = new Money(7, Currency.getInstance("EUR"));
        Date snapshotDate = new Date(1);
        DefaultTaxCalculator calculator = new DefaultTaxCalculator();


        ProductData pd = new ProductData(id, price, name, pt, snapshotDate);
        RequestItem item = new RequestItem(pd, 10, price);

        Tax tax = new Tax(new Money(0.49, Currency.getInstance("EUR")), "7% (F)");
        Tax result = calculator.getTax(item, price);

        Assert.assertEquals(tax.getAmount(), result.getAmount());
        Assert.assertEquals(tax.getDescription(), result.getDescription());
    }
}
