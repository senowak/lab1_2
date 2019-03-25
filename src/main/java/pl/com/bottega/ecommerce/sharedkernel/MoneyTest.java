package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.Currency;

public class MoneyTest {

    @Test void addMoneyTest(){
        Money money = new Money(5.25, Currency.getInstance("USD"));
        Money adder = new Money(2.04,Currency.getInstance("USD"));
        Money result = new Money(7.29,Currency.getInstance("USD"));
        Assert.assertEquals(result, money.add(adder));
    }
}
