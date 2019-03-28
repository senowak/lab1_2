package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MoneyTest {

    private Money moneyUSD;
    private Money moneyEUR;
    private Money moneyEUR1;

    private final double MONEY_EUR_VALUE = 0.35;
    private final double MONEY_EUR1_VALUE = 4.5;
    private final double MONEY_USD_VALUE = 0.5;

    @Before
    public void init() {
        moneyUSD = new Money(MONEY_USD_VALUE, "USD");

        moneyEUR = new Money(MONEY_EUR_VALUE);
        moneyEUR1 = new Money(MONEY_EUR1_VALUE);
    }

    @Test
    public void addTest() {
        Assert.assertThat(moneyEUR.add(moneyEUR1), is(equalTo(new Money(MONEY_EUR_VALUE + MONEY_EUR1_VALUE))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFailureTest() {
        moneyEUR.add(moneyUSD);
    }

    @Test
    public void subtractTest() {
        Assert.assertThat(moneyEUR.subtract(moneyEUR1), is(equalTo(new Money(MONEY_EUR_VALUE - MONEY_EUR1_VALUE))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractFailureTest() {
        moneyEUR.subtract(moneyUSD);
    }


}
