package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class DefaultTaxCalculatorTest {
    Money money = new Money(1, "PLN");
    DefaultTaxCalculator taxCalculator = new DefaultTaxCalculator();

    @Test
    public void calculateTaxFood() {
        RequestItem foodItem = new RequestItem(new ProductData(Id.generate(), money, "DRUGS", ProductType.FOOD, new Date()), 1, money);

        Tax tax = new Tax(new Money(0.07, "PLN"), "7% (F)");
        Assert.assertThat(taxCalculator.getTax(foodItem, money).getAmount(), is(tax.getAmount()));
        Assert.assertThat(taxCalculator.getTax(foodItem, money).getDescription(), is(tax.getDescription()));
    }


}