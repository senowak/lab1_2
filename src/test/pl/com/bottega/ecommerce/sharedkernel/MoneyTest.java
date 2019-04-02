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

    @Test(expected = IllegalArgumentException.class)
    public void testIfCurrenciesMatchForSubtraction(){
        plnMoney.add(dollarMoney);
    }

    @Test
    public void testCorrectSubtraction(){
        Assert.assertThat(plnMoney.subtract(plnMoney),is(equalTo(new Money(0,"PLN"))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIfCurrenciesMatchForMultiplication(){
        plnMoney.add(dollarMoney);
    }

    @Test
    public void testCorrectMultiplication(){
        Assert.assertThat(dollarMoney.multiplyBy(3.87),is(equalTo(new Money(3.87*3.87,"USD"))));
    }



}
