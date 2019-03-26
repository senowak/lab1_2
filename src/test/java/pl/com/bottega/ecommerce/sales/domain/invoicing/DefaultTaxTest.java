package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.junit.Assert.*;

public class DefaultTaxTest {

    DefaultTax defaultTax = new DefaultTax();
    Money testValue = new Money(10);

    @Test public void searchingIfDrugIsGettingRightRatio() {
        ProductData productData = new ProductData(new Id("0"), testValue, "Testowy", ProductType.DRUG,
                new Date(System.currentTimeMillis()));
        RequestItem requestItem = new RequestItem(productData, 1, testValue);
        Money testValueMultipliedByRightRatio = new Money(0.5);
        Tax expected = new Tax(testValueMultipliedByRightRatio, "");
        assertEquals(expected.getAmount(), defaultTax.calculate(requestItem, testValue).getAmount());
    }
}
