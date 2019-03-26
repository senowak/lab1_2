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

public class DefaultTaxTest {

    private DefaultTax defaultTax;
    private RequestItem requestItem;
    private ProductData productData;

    private final String DRUG_DESCRIPTION = "5% (D)";
    private final String FOOD_DESCRIPTION = "7% (F)";

    private final BigDecimal VALUE_OF_DRUG = BigDecimal.valueOf(0.05);
    private final BigDecimal VALUE_OF_FOOD = BigDecimal.valueOf(0.07);

    @Before public void init() {
        defaultTax = new DefaultTax();
    }

    @Test public void checkDrugTest() {
        productData = new ProductData(new Id("1"), new Money(1), "prod1", ProductType.DRUG, new Date());
        requestItem = new RequestItem(productData, 1, new Money(1));

        Tax tax = new Tax(requestItem.getTotalCost().multiplyBy(VALUE_OF_DRUG), DRUG_DESCRIPTION);

        Assert.assertThat(tax.getAmount(), is(equalTo(defaultTax.calculate(requestItem).getAmount())));
        Assert.assertThat(tax.getDescription(), is(equalTo(defaultTax.calculate(requestItem).getDescription())));
    }

    @Test public void checkFoodTest() {
        productData = new ProductData(new Id("1"), new Money(1), "prod1", ProductType.FOOD, new Date());
        requestItem = new RequestItem(productData, 1, new Money(1));

        Tax tax = new Tax(requestItem.getTotalCost().multiplyBy(VALUE_OF_FOOD), FOOD_DESCRIPTION);

        Assert.assertThat(tax.getAmount(), is(equalTo(defaultTax.calculate(requestItem).getAmount())));
        Assert.assertThat(tax.getDescription(), is(equalTo(defaultTax.calculate(requestItem).getDescription())));
    }

}
