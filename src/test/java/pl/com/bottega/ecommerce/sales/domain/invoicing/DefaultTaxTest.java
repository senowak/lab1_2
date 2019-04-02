package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.hamcrest.core.Is;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;

import static org.junit.Assert.*;

public class DefaultTaxTest {

    private Id productId;
    private Money productPrice;
    private String productName;
    private Date productSnapshotDate;
    private int quantity;

    @Before public void initialize() {
        productId = new Id("1");
        BigDecimal denomination;
        denomination = new BigDecimal("10");
        productPrice = new Money(denomination);
        productName = "testProduct";
        productSnapshotDate = new Date(2013, 02, 01);
        quantity = 1;
    }

    @Test public void calculateTaxForFoodTest() {

        ProductData productData = new ProductData(productId, productPrice, productName, ProductType.FOOD, productSnapshotDate);
        RequestItem requestItem = new RequestItem(productData, quantity, productPrice);
        DefaultTax defaultTax = new DefaultTax();

        Tax tax = defaultTax.calculateTax(requestItem);

        assertThat(tax.getAmount(), Is.is(new Money(new BigDecimal(0.7))));

    }

    @Test public void calculateTaxForDrugTest() {

        ProductData productData = new ProductData(productId, productPrice, productName, ProductType.DRUG, productSnapshotDate);
        RequestItem requestItem = new RequestItem(productData, quantity, productPrice);
        DefaultTax defaultTax = new DefaultTax();

        Tax tax = defaultTax.calculateTax(requestItem);

        assertThat(tax.getAmount(), Is.is(new Money(new BigDecimal(0.5))));

    }

    @Test public void calculateTaxForStandardProductTest() {

        ProductData productData = new ProductData(productId, productPrice, productName, ProductType.STANDARD, productSnapshotDate);
        RequestItem requestItem = new RequestItem(productData, quantity, productPrice);
        DefaultTax defaultTax = new DefaultTax();

        Tax tax = defaultTax.calculateTax(requestItem);

        assertThat(tax.getAmount(), Is.is(new Money(new BigDecimal(2.3))));

    }

}
