package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class MoneyTest {

    Currency currencyEUR;
    Currency currencyUSD;

    @Before
    public void setUp() {
        currencyEUR = Currency.getInstance("EUR");
        currencyUSD = Currency.getInstance("USD");
    }

    @Test
    public void AddMoneyWithSameCurrency() {
        Money m1 = new Money(10, currencyEUR);
        Money m2 = new Money(10, currencyEUR);
        Money result = m1.add(m2);
        Assert.assertThat(result.equals(new Money(20, currencyEUR)), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void AddMoneyWithDifferentCurrency() {
        Money m1 = new Money(10, currencyEUR);
        Money m2 = new Money(10, currencyUSD);
        m1.add(m2);
    }

    @Test
    public void SubtractMoneyWithSameCurrency() {
        Money m1 = new Money(10, currencyEUR);
        Money m2 = new Money(10, currencyEUR);
        Money result = m1.subtract(m2);
        Assert.assertThat(result.equals(new Money(0, currencyEUR)), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void SubtractMoneyWithDifferentCurrency() {
        Money m1 = new Money(10, currencyEUR);
        Money m2 = new Money(10, currencyUSD);
        m1.subtract(m2);
    }

    @Test
    public void checkMoneyCurrency() {
        Money m1 = new Money(10, currencyEUR);
        Assert.assertThat(m1.getCurrency(), is(currencyEUR));
        Assert.assertThat(m1.getCurrencyCode(), is("EUR"));
    }
}
