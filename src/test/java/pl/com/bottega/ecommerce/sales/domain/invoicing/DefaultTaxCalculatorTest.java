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
        RequestItem foodItem = new RequestItem(new ProductData(Id.generate(), money, "FOOD", ProductType.FOOD, new Date()), 1, money);

        Tax tax = new Tax(new Money(0.07, "PLN"), "7% (F)");
        Assert.assertThat(taxCalculator.getTax(foodItem, money).getAmount(), is(tax.getAmount()));
        Assert.assertThat(taxCalculator.getTax(foodItem, money).getDescription(), is(tax.getDescription()));

    }

    @Test
    public void calculateTaxDrug() {
        RequestItem drugItem = new RequestItem(new ProductData(Id.generate(), money, "DRUGS", ProductType.DRUG, new Date()), 1, money);

        Tax tax = new Tax(new Money(0.05, "PLN"), "5% (D)");
        Assert.assertThat(taxCalculator.getTax(drugItem, money).getAmount(), is(tax.getAmount()));
        Assert.assertThat(taxCalculator.getTax(drugItem, money).getDescription(), is(tax.getDescription()));

    }
    @Test
    public void calulateStandardTax() {
        RequestItem standardItem = new RequestItem(new ProductData(Id.generate(), money, "Haaa", ProductType.STANDARD, new Date()), 1,
                money);

        Tax tax = new Tax(new Money(0.23, "PLN"),"23%");
        Assert.assertThat(taxCalculator.getTax(standardItem, money).getAmount(), is(tax.getAmount()));
        Assert.assertThat(taxCalculator.getTax(standardItem, money).getDescription(), is(tax.getDescription()));
    }

}