package pl.com.bottega.ecommerce.sales.domain.invoicing;


import org.junit.Assert;
import org.junit.jupiter.api.Test;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DefaultTaxCalculatorTest {

    @Test void calculatetest_FOOD(){
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Id id = new Id("1");
        Date date = new Date(12345);
        Money price= new Money(100,Money.DEFAULT_CURRENCY);
        ProductData productData = new ProductData(id,price,"kaktus", ProductType.FOOD,date);
        RequestItem requestItem = new RequestItem(productData,1,price);
        Money taxvalue = new Money(7,Money.DEFAULT_CURRENCY);
        Tax tax = new Tax(taxvalue,"7% (F)");
        assertEquals(tax.getAmount(),defaultTaxCalculator.calculate(requestItem).getAmount());
        assertEquals(tax.getDescription(),defaultTaxCalculator.calculate(requestItem).getDescription());
    }

    @Test void calculatetest_DRUG(){
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Id id = new Id("1");
        Date date = new Date(12345);
        Money price= new Money(100,Money.DEFAULT_CURRENCY);
        ProductData productData = new ProductData(id,price,"drug", ProductType.DRUG,date);
        RequestItem requestItem = new RequestItem(productData,1,price);
        Money taxvalue = new Money(5,Money.DEFAULT_CURRENCY);
        Tax tax = new Tax(taxvalue,"5% (D)");
        assertEquals(tax.getAmount(),defaultTaxCalculator.calculate(requestItem).getAmount());
        assertEquals(tax.getDescription(),defaultTaxCalculator.calculate(requestItem).getDescription());
    }

    @Test void calculatetest_STANDARD(){
        DefaultTaxCalculator defaultTaxCalculator = new DefaultTaxCalculator();
        Id id = new Id("1");
        Date date = new Date(12345);
        Money price= new Money(100,Money.DEFAULT_CURRENCY);
        ProductData productData = new ProductData(id,price,"kaktus", ProductType.STANDARD,date);
        RequestItem requestItem = new RequestItem(productData,1,price);
        Money taxvalue = new Money(23,Money.DEFAULT_CURRENCY);
        Tax tax = new Tax(taxvalue,"23%");
        assertEquals(tax.getAmount(),defaultTaxCalculator.calculate(requestItem).getAmount());
        assertEquals(tax.getDescription(),defaultTaxCalculator.calculate(requestItem).getDescription());
    }



}
