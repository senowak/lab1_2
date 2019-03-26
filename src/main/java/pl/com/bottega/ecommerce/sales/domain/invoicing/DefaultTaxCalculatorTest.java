package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Currency;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTaxCalculatorTest {

    @Test
    void getTaxTest() {
        Id id = new Id("tempId");
        Money price = new Money(5, Currency.getInstance("EUR"));
        Date date = new Date(2017, 05, 01);
        ProductType pType = ProductType.DRUG;
        String name = new String("NAME");

        ProductData pData = new ProductData(id, price, name, pType, date);
        int quantity = 20;

        RequestItem rItem = new RequestItem(pData, quantity, price);
        DefaultTaxCalculator cal = new DefaultTaxCalculator();
        
        Tax tax = new Tax(new Money(0.25, Currency.getInstance("EUR")), "5% (D)");
        Assert.assertEquals(tax.getAmount(), cal.getTax(rItem, new Money(5, "EUR")).getAmount());
        Assert.assertEquals(tax.getDescription(), cal.getTax(rItem, new Money(5, "EUR")).getDescription());

    }

}
