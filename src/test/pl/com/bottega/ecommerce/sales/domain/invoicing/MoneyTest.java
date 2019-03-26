package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.junit.Assert;

import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import java.util.Currency;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class MoneyTest {

    @Test void addMoneyTest(){
        Money money = new Money(5.25, Currency.getInstance("USD"));
        Money adder = new Money(2.04,Currency.getInstance("USD"));
        Money result = new Money(7.29,Currency.getInstance("USD"));
        Assert.assertEquals(result, money.add(adder));
    }

    @Test void addMoneyTestWithError(){
        Money money = new Money(5.25, "$");
        Money adder = new Money(2.04, "€");
        assertThrows(IllegalArgumentException.class ,()->{money.add(adder);});
    }

    @Test void subtractMoneyTest(){
        Money money = new Money(3.02, Currency.getInstance("USD"));
        Money subtrahend = new Money(0.02, Currency.getInstance("USD"));
        Money result = new Money(3.00, Currency.getInstance("USD"));
        Assert.assertEquals(result, money.subtract(subtrahend));
    }

    @Test void subtractMoneyTestWithError(){
        Money money = new Money(3.02, "$");
        Money subtrahend = new Money(0.02, "€");
        assertThrows(IllegalArgumentException.class ,()->{money.subtract(subtrahend);});
    }
}
