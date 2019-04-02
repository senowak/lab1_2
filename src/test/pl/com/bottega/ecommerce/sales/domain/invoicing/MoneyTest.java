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

    private final double MONEY_EUR1_VALUE = 4.3;
    private final double MONEY_EUR_VALUE = 0.3;
    private final double MONEY_USD_VALUE = 0.5;

    @Before public void init() {
        moneyUSD = new Money(MONEY_USD_VALUE, "USD");
        moneyEUR = new Money(MONEY_EUR_VALUE);
        moneyEUR1 = new Money(MONEY_EUR1_VALUE);
    }

    @Test
    public void add() {
        Assert.assertThat(moneyEUR.add(moneyEUR1), is(equalTo(new Money(MONEY_EUR_VALUE + MONEY_EUR1_VALUE))));
    }

    @Test
    public void subtract() {
        Assert.assertThat(moneyEUR.subtract(moneyEUR1), is(equalTo(new Money(MONEY_EUR_VALUE - MONEY_EUR1_VALUE))));
    }

    @Test
    public void multiplyBy() {
        Assert.assertThat(moneyEUR.multiplyBy(MONEY_EUR1_VALUE), is(equalTo(new Money(MONEY_EUR_VALUE * MONEY_EUR1_VALUE))));
    }

    @Test(expected = IllegalArgumentException.class)
    public void addFail() {
        moneyEUR.add(moneyUSD);
    }

    @Test(expected = IllegalArgumentException.class)
    public void subtractFail() {
        moneyEUR.subtract(moneyUSD);
    }
}
