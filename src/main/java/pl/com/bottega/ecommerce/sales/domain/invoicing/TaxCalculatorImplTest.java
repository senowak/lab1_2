package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

class TaxCalculatorImplTest {

    @Test void compute() {
        Id productId = new Id("temporaryID");
        Money money = new Money(0.23, Currency.getInstance("USD"));
        String name = "nameProduct";
        Date snapshotDate = new Date(2016, 07, 12);
        ProductType type = ProductType.STANDARD;
        ProductData productData = new ProductData(productId, money, name, type, snapshotDate);
        RequestItem requestItem = new RequestItem(productData, 1, money);
        TaxCalculatorImpl taxCalculator = new TaxCalculatorImpl();
        Tax tax = new Tax(new Money(0.05, Currency.getInstance("USD")), "23%");
        Tax resultTax = taxCalculator.compute(requestItem, money);

        Assert.assertEquals(tax.getAmount(), resultTax.getAmount());
        Assert.assertEquals(tax.getDescription(), resultTax.getDescription());

    }
}
