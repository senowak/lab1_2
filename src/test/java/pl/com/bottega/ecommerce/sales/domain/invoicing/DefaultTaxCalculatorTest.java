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

	@Test
	public void computeTaxForFood() {
		RequestItem foodItem = new RequestItem(new ProductData(Id.generate(), money, "DRUGS", ProductType.FOOD, new Date()), 1,
				money);

		Tax tax = new Tax(new Money(0.7, "EUR"),"7% (F)");
		Assert.assertThat(taxCalculator.compute(foodItem, money).getAmount(), is(tax.getAmount()));
		Assert.assertThat(taxCalculator.compute(foodItem, money).getDescription(), is(tax.getDescription()));
	}

	@Test
	public void computeStandardTax() {
		RequestItem standardItem = new RequestItem(new ProductData(Id.generate(), money, "DRUGS", ProductType.STANDARD, new Date()), 1,
				money);

		Tax tax = new Tax(new Money(2.3, "EUR"),"23%");
		Assert.assertThat(taxCalculator.compute(standardItem, money).getAmount(), is(tax.getAmount()));
		Assert.assertThat(taxCalculator.compute(standardItem, money).getDescription(), is(tax.getDescription()));
	}
}
