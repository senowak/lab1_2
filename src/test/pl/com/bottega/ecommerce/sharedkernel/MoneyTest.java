package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void addForTheSameCurrency() {
        Money start = new Money(100.00, Money.DEFAULT_CURRENCY);
        Money adder = new Money(250.50, Money.DEFAULT_CURRENCY);
        Money result = new Money(350.50, Money.DEFAULT_CURRENCY);

        assertEquals(result, start.add(adder));
    }

    @Test
    void addForDifferentCurrency() {
        Money start = new Money(100.00, Money.DEFAULT_CURRENCY);
        Money adder = new Money(250.50, "PLN");

        assertThrows(IllegalArgumentException.class, () -> start.add(adder));
    }

    @Test
    void subtract() {
    }
}
