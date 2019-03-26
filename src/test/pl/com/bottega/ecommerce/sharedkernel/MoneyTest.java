package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class MoneyTest {

    @Test void add_without_error() {
        Money start =new Money(7.56);
        Money adder = new Money(5);
        Money result = new Money(12.56);
        assertEquals(result,start.add(adder));
    }
    @Test void add_with_error() {
        Money start =new Money(67.74,"$");
        Money adder = new Money(85.12,"€");
        assertThrows(IllegalArgumentException.class ,()->{start.add(adder);});

    }
    @Test void subtract_without_error() {
        Money start =new Money(56.87);
        Money subtrahend = new Money(16);
        Money result = new Money(40.87);
        assertEquals(result,start.subtract(subtrahend));
    }
    @Test void substract_with_error() {
        Money start =new Money(84.74,"$");
        Money subtrahend = new Money(25.92,"€");
        assertThrows(IllegalArgumentException.class ,()->{start.subtract(subtrahend);});

    }

}
