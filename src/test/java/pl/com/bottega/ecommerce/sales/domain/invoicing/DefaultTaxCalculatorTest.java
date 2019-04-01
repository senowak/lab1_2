package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.hamcrest.CoreMatchers.is;

public class DefaultTaxCalculatorTest {

    Money money;
    DefaultTaxCalculator taxCalculator;

    @Before
    public void setUp() {
        this.money = new Money(10, "EUR");
        this.taxCalculator = new DefaultTaxCalculator();
    }

    @Test
    public void computeTaxForDrugs() {
        RequestItem drugItem = new RequestItem(new ProductData(Id.generate(), money, "DRUGS", ProductType.DRUG, new Date()), 1,
                money);

        Tax tax = new Tax(new Money(0.5, "EUR"),"5% (D)");
        Assert.assertThat(taxCalculator.compute(drugItem, money).getAmount(), is(tax.getAmount()));
		Assert.assertThat(taxCalculator.compute(drugItem, money).getDescription(), is(tax.getDescription()));
	}
