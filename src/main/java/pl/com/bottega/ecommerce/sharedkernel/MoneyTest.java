package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Currency;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test void add() {
        Money money = new Money(2.54, Currency.getInstance("USD"));
        Money adder = new Money(0.01, Currency.getInstance("USD"));
        Money result = new Money(2.55, Currency.getInstance("USD"));
        Assert.assertEquals(result, money.add(adder));
    }

    @Test void subtract() {
        Money minued = new Money(3.34, Currency.getInstance("USD"));
        Money subtrahend = new Money(0.02, Currency.getInstance("USD"));
        Money result = new Money(3.32, Currency.getInstance("USD"));
        Assert.assertEquals(result, minued.subtract(subtrahend));
    }
}
