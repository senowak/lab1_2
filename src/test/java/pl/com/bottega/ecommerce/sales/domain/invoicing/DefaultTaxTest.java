package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.core.Is;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class DefaultTaxTest {

    @Test public void calculateTaxForFoodTest() {

        Id productId = new Id("1");
        BigDecimal denomination = new BigDecimal("3.5");
        Money productPrice = new Money(denomination);
        String productName = "chocolate";
        ProductType produktType = ProductType.FOOD;
        Date produktSnapshotDate = new Date(2013, 02, 01);

        ProductData productData = new ProductData(productId, productPrice, productName, produktType, produktSnapshotDate);

        int quantity = 1;
        RequestItem requestItem = new RequestItem(productData, quantity, productPrice);

        DefaultTax defaultTax = new DefaultTax();

        Tax tax = defaultTax.calculateTax(requestItem);
        Money expectedResult = new Money(new BigDecimal(0.24));

        assertThat(tax.getAmount(), Is.is(expectedResult));

    }

}
