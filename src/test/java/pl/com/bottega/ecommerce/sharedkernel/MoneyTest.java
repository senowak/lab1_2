package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void AddSameCurrency() {
        Money m1 = new Money(5, Currency.getInstance("PLN"));
        Money m2 = new Money(5, Currency.getInstance("PLN"));
        Money result = m1.add(m2);
        Assert.assertThat(result.equals(new Money(10, Currency.getInstance("PLN"))), is(true));

    }

    @Test(expected = IllegalArgumentException.class)
    public void AddDifferentCurrency() {
        Money m1 = new Money(40.2, Currency.getInstance("USD"));
        Money m2 = new Money(15.1, Currency.getInstance("PLN"));
        m1.add(m2);
    }

    @Test
    public void SubtractSameCurrency() {
        Money m1 = new Money(555.25, Currency.getInstance("PLN"));
        Money m2 = new Money(555.25, Currency.getInstance("PLN"));
        Money result = m1.subtract(m2);
        Assert.assertThat(result.equals(new Money(0, Currency.getInstance("PLN"))), is(true));
    }

    @Test(expected = IllegalArgumentException.class)
    public void SubtractDifferentCurrency() {
        Money m1 = new Money(777.45, Currency.getInstance("PLN"));
        Money m2 = new Money(956.01,Currency.getInstance("USD") );
        m1.subtract(m2);
    }
}