package pl.com.bottega.ecommerce.sharedkernel;

import java.util.Currency;

import org.junit.Assert;
import org.junit.Test;

public class MonetTest {

    @Test
    public void add() {
        Money money = new Money(2.54, Currency.getInstance("USD"));
        Money adder = new Money(0.01, Currency.getInstance("USD"));
        Money result = new Money(2.55, Currency.getInstance("USD"));
        Assert.assertEquals(result, money.add(adder));
    }

    @Test
    public void subtract() {
        Money money = new Money(3.34, Currency.getInstance("USD"));
        Money subtrahend = new Money(0.02, Currency.getInstance("USD"));
        Money result = new Money(3.32, Currency.getInstance("USD"));
        Assert.assertEquals(result, money.subtract(subtrahend));
    }

}
