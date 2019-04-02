package pl.com.bottega.ecommerce.sales.domain.invoicing;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.is;


public class DefaultTaxTest {

    private RequestItem foodItem;
    private ProductData foodProductData;
    private RequestItem drugItem;
    private ProductData drugProductData;
    private RequestItem standardItem;
    private ProductData standardProductData;
    private DefaultTax defaultTax;

    @Before
    public void createObjectForTest(){
        defaultTax = new DefaultTax();
    }

    @Test
    public void testFoodCalculate() {
        foodProductData = new ProductData(new Id("1"),new Money(21.37),"Peanaut Butter",ProductType.FOOD,new Date());
        foodItem = new RequestItem(foodProductData,1,new Money(21.37));
        Tax tax = new Tax(new Money(1.50),"7% (F)");
        Assert.assertThat(tax.getAmount(),is(equalTo(defaultTax.calculate(foodItem).getAmount())));
        Assert.assertThat(tax.getDescription(),is(equalTo(defaultTax.calculate(foodItem).getDescription())));
    }

    @Test
    public void testDrugCalculate() {
        drugProductData = new ProductData(new Id("2"),new Money(10),"Ibuprofen",ProductType.DRUG,new Date());
        drugItem = new RequestItem(drugProductData,1,new Money(21.37));
        Tax tax = new Tax(new Money(1.07),"5% (D)");
        Assert.assertThat(tax.getAmount(),is(equalTo(defaultTax.calculate(drugItem).getAmount())));
        Assert.assertThat(tax.getDescription(),is(equalTo(defaultTax.calculate(drugItem).getDescription())));
    }

    @Test
    public void testStandardCalculate() {
        standardProductData = new ProductData(new Id("3"),new Money(5),"Standard item name",ProductType.STANDARD,new Date());
        standardItem = new RequestItem(standardProductData,1,new Money(21.37));
        Tax tax = new Tax(new Money(4.92),"23%");
        Assert.assertThat(tax.getAmount(),is(equalTo(defaultTax.calculate(standardItem).getAmount())));
        Assert.assertThat(tax.getDescription(),is(equalTo(defaultTax.calculate(standardItem).getDescription())));
    }

}
