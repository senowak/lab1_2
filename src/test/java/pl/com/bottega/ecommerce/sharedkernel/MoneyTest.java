package pl.com.bottega.ecommerce.sharedkernel;

import org.hamcrest.core.Is;
import org.junit.Test;

import static org.junit.Assert.*;

public class MoneyTest {

    @Test public void addTest() {

        Money a = new Money(5);
        Money b = new Money(10);

        Money result = a.add(b);

        assertThat(result, Is.is(new Money(15)));

    }

    @Test public void subtractTest() {

        Money a = new Money(10);
        Money b = new Money(5);

        Money result = a.subtract(b);

        assertThat(result, Is.is(new Money(5)));

    }

    @Test public void greaterThanTrueTest() {

        Money a = new Money(10);
        Money b = new Money(5);

        boolean result = a.greaterThan(b);

        assertThat(result, Is.is(true));

    }

    @Test public void greaterThanFalseTest() {

        Money a = new Money(5);
        Money b = new Money(10);

        boolean result = a.greaterThan(b);

        assertThat(result, Is.is(false));

    }

    @Test public void lessThanTrueTest() {

        Money a = new Money(5);
        Money b = new Money(10);

        boolean result = a.lessThan(b);

        assertThat(result, Is.is(true));

    }

    @Test public void lessThanFalseTest() {

        Money a = new Money(10);
        Money b = new Money(5);

        boolean result = a.lessThan(b);

        assertThat(result, Is.is(false));

    }

    @Test public void lessOrEqualsTrueTest() {

        Money a = new Money(10);
        Money b = new Money(10);

        boolean result = a.lessOrEquals(b);

        assertThat(result, Is.is(true));

    }

    @Test public void lessOrEqualsFalseTest() {

        Money a = new Money(10);
        Money b = new Money(5);

        boolean result = a.lessOrEquals(b);

        assertThat(result, Is.is(false));

    }

}
