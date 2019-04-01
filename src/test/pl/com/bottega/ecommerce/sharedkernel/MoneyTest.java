package pl.com.bottega.ecommerce.sharedkernel;

import org.junit.Assert;
import org.junit.Test;

import java.util.Currency;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class MoneyTest {

    @Test
    public void addMoneyInCompatibleCurrency() {
        Money money = new Money(55.8, Currency.getInstance("USD"));
        Money addend = new Money(45.5, Currency.getInstance("USD"));
        Money sum = new Money((55.8 + 45.5), Currency.getInstance("USD"));
        Assert.assertThat(true, is(equalTo(money.add(addend).equals(sum))));
    }

    @Test
    public void subtractMoneyInCompatibleCurrency() {
        Money money = new Money(55.8, Currency.getInstance("USD"));
        Money subtrahend = new Money(45.5, Currency.getInstance("USD"));
        Money differenxe = new Money((55.8 - 45.5), Currency.getInstance("USD"));
        Assert.assertThat(true, is(equalTo(money.subtract(subtrahend).equals(differenxe))));
    }
}
