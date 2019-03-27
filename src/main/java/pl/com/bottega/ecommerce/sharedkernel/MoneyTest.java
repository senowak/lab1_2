package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void add() {
        Money value = new Money(3.5, "EUR");
        Money adder = new Money(0.5, "EUR");
        Money result = new Money(4, "EUR");

        Assert.assertEquals(result, value.add(adder));
    }

    @Test
    void subtract() {
        Money value = new Money(3.5, "EUR");
        Money minuend = new Money(0.5, "EUR");
        Money result = new Money(3, "EUR");

        Assert.assertEquals(result, value.subtract(minuend));
    }
}
