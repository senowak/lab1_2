package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.math.BigDecimal;
import java.util.Date;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class DefaultTaxTest {

    private DefaultTax defaultTax;
    private RequestItem requestItem;
    private ProductData productData;
    private Tax tax;

    @Before
    public void initialize() {
        defaultTax = new DefaultTax();
    }

    @Test
    public void checkDrugCalculate() {
        productData = new ProductData(new Id("1"), new Money(new BigDecimal(100)), "ProductDrugForTest", ProductType.DRUG, new Date());
        requestItem = new RequestItem(productData, 1, new Money(new BigDecimal(100)));

        tax = new Tax(new Money(5), "5% (D)");
        Assert.assertThat(tax.getAmount(), is(equalTo(defaultTax.calculate(requestItem).getAmount())));
        Assert.assertThat(tax.getDescription(), is(equalTo(defaultTax.calculate(requestItem).getDescription())));
    }

    @Test
    public void checkFoodCalculate() {
        productData = new ProductData(new Id("2"), new Money(new BigDecimal(100)), "ProductFoodForTest", ProductType.FOOD, new Date());
        requestItem = new RequestItem(productData, 1, new Money(new BigDecimal(100)));

        tax = new Tax(new Money(7), "7% (F)");
        Assert.assertThat(tax.getAmount(), is(equalTo(defaultTax.calculate(requestItem).getAmount())));
        Assert.assertThat(tax.getDescription(), is(equalTo(defaultTax.calculate(requestItem).getDescription())));
    }

}
