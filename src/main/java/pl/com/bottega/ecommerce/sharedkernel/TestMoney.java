package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

public class TestMoney {

    @Test
    public void testAdd() {
        Money addend1 = new Money(1.5, "EUR");
        Money addend2 = new Money(1.25, "EUR");
        Money sum = new Money(2.75, "EUR");

        Assert.assertEquals(sum, addend1.add(addend2));
    }

    @Test
    public void testSubtract() {
        Money minuend = new Money(1.5, "EUR");
        Money subtrahend = new Money(1.25, "EUR");
        Money difference = new Money(0.25, "EUR");

        Assert.assertEquals(difference, minuend.subtract(subtrahend));
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddException() {
        Money addend1 = new Money(1.5, "EUR");
        Money addend2 = new Money(1.25, "PLN");

        addend1.add(addend2);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSubtractException() {
        Money minuend = new Money(1.5, "EUR");
        Money subtrahend = new Money(1.25, "PLN");

        minuend.subtract(subtrahend);
    }
}
