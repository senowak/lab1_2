package pl.com.bottega.ecommerce.sales.domain.invoicing;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import pl.com.bottega.ecommerce.canonicalmodel.publishedlanguage.Id;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductData;
import pl.com.bottega.ecommerce.sales.domain.productscatalog.ProductType;
import pl.com.bottega.ecommerce.sharedkernel.Money;
import sun.awt.ModalExclude;

import java.util.Date;

import static org.junit.Assert.*;

public class DefaultTaxTest {

    RequestItem item;

    @Before
    public void createObjectForTest(){
        ProductData productData = new ProductData(new Id("1"),new Money(21.37),"Peanaut Butter",ProductType.FOOD,new Date());
        item = new RequestItem(productData,2,new Money(42.74));
    }

    @Test
    public void calculate() {
        
    }
}
