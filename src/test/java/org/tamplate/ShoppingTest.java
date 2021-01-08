package org.tamplate;

import org.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tamplate.AmazonShopping;
import tamplate.EbayShopping;
import tamplate.ShoppingTemplate;

public class ShoppingTest extends BaseTest {

    //before running change in BaseTest change @BeforeMethod/After on @BeforeTest/After

    @Test(dataProvider = "getData")
    public void shoppingTest(ShoppingTemplate shoppingTemplate) {
        shoppingTemplate.shop();
    }

    @DataProvider
    public Object[] getData() {
        return new Object[]{
                new AmazonShopping(driver, "samsung"),
                new EbayShopping(driver, "samsung")
        };
    }
}
