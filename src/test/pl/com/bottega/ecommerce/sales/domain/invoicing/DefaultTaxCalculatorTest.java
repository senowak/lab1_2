package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTaxCalculatorTest {

    @Test void calculateTaxForDrug() {

        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();

        Money price = new Money(10.00, Money.DEFAULT_CURRENCY);

        ProductData productData = new ProductData(
                new Id("1"),
                price,
                "test",
                ProductType.DRUG,
                new Date(123));

        RequestItem requestItem = new RequestItem(
                productData,
                1,
                price);

        BigDecimal ratio = BigDecimal.valueOf(0.05);
        String desc = "5% (D)";

        Money taxValue = price.multiplyBy(ratio);

        assertEquals(new Tax(taxValue, desc).getAmount(), defaultTaxCalculator.calculateTax(requestItem).getAmount());

    }

    @Test void calculateTaxForFood() {

        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();

        Money price = new Money(10.00, Money.DEFAULT_CURRENCY);

        ProductData productData = new ProductData(
                new Id("1"),
                price,
                "test",
                ProductType.FOOD,
                new Date(123));

        RequestItem requestItem = new RequestItem(
                productData,
                1,
                price);

        BigDecimal ratio = BigDecimal.valueOf(0.07);
        String desc = "7% (F)";

        Money taxValue = price.multiplyBy(ratio);

        assertEquals(new Tax(taxValue, desc).getAmount(), defaultTaxCalculator.calculateTax(requestItem).getAmount());

    }

    @Test void calculateTaxForStandard() {

        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();

        Money price = new Money(10.00, Money.DEFAULT_CURRENCY);

        ProductData productData = new ProductData(
                new Id("1"),
                price,
                "test",
                ProductType.STANDARD,
                new Date(123));

        RequestItem requestItem = new RequestItem(
                productData,
                1,
                price);

        BigDecimal ratio = BigDecimal.valueOf(0.23);
        String desc = "23";

        Money taxValue = price.multiplyBy(ratio);

        assertEquals(new Tax(taxValue, desc).getAmount(), defaultTaxCalculator.calculateTax(requestItem).getAmount());

    }
    
}
