package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MoneyTest {

    @Test
    public void AddSameCurrency() {
        Money m1 = new Money(10, Currency.getInstance("UA"));
        Money m2 = new Money(10, Currency.getInstance("UA"));
        Money result = m1.add(m2);
        Assert.assertThat(result.equals(new Money(20, Currency.getInstance("UA"))), is(true));
    }

}