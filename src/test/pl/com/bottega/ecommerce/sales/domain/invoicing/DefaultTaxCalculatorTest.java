package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import org.junit.Assert;

import java.util.Date;

class DefaultTaxCalculatorTest {

    @Test void calculateTestFood() {
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Id id = new Id("1");
        Date date = new Date(0204);
        Money money = new Money(100, Money.DEFAULT_CURRENCY);
        ProductData productData = new ProductData(id, money, "pizza", ProductType.FOOD, date);
        RequestItem requestItem = new RequestItem(productData, 1, money);
        Money taxValue = new Money(7, Money.DEFAULT_CURRENCY);
        Tax tax = new Tax(taxValue, "7% (F)");
        Assert.assertEquals(tax.getAmount(), defaultTaxCalculator.calculate(requestItem).getAmount());
        Assert.assertEquals(tax.getDescription(), defaultTaxCalculator.calculate(requestItem).getDescription());
    }

    @Test void calculateTestDrug() {
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Id id = new Id("1");
        Date date = new Date(0204);
        Money money = new Money(100, Money.DEFAULT_CURRENCY);
        ProductData productData = new ProductData(id, money, "drug", ProductType.DRUG, date);
        RequestItem requestItem = new RequestItem(productData, 1, money);
        Money taxValue = new Money(5, Money.DEFAULT_CURRENCY);
        Tax tax = new Tax(taxValue, "5% (D)");
        Assert.assertEquals(tax.getAmount(), defaultTaxCalculator.calculate(requestItem).getAmount());
        Assert.assertEquals(tax.getDescription(), defaultTaxCalculator.calculate(requestItem).getDescription());
    }

    @Test void calculateTestStandard() {
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Id id = new Id("1");
        Date date = new Date(0204);
        Money money = new Money(100, Money.DEFAULT_CURRENCY);
        ProductData productData = new ProductData(id, money, "standard", ProductType.STANDARD, date);
        RequestItem requestItem = new RequestItem(productData, 1, money);
        Money taxValue = new Money(23, Money.DEFAULT_CURRENCY);
        Tax tax = new Tax(taxValue, "23%");
        Assert.assertEquals(tax.getAmount(), defaultTaxCalculator.calculate(requestItem).getAmount());
        Assert.assertEquals(tax.getDescription(), defaultTaxCalculator.calculate(requestItem).getDescription());
    }
}
