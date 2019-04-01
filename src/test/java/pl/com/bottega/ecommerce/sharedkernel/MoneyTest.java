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


}