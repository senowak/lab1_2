package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;


public class MoneyTest {
    private Money dollarMoney;
    private Money plnMoney;

    @Before
    public void initalizeMoney(){
        dollarMoney = new Money(3.87,"USD");
        plnMoney = new Money(1.00,"PLN");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCurrenciesMatchForAddition(){
        dollarMoney.add(plnMoney);
    }

    @Test
    public void testCorrectAddition(){
        Assert.assertThat(dollarMoney.add(dollarMoney),is(equalTo(new Money(2 * 3.87,"USD"))));
    }




}
