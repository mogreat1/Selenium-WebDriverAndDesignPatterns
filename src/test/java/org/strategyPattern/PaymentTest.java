package org.strategyPattern;

import org.BaseTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.collections.Maps;
import strategyPattern.PaymentOptionFactory;
import strategyPattern.PaymentScreen;

import java.util.Map;
//Strategy pattern is good way to use when app provides multiple options to the user &
//based on the user selection execute the business rule slightly differently
//ex. you can pay with card/paypal/money transfer...
public class PaymentTest extends BaseTest {

    private PaymentScreen paymentScreen;

    @BeforeMethod
    public void setPaymentScreen() {
        this.paymentScreen = new PaymentScreen(this.driver);
    }

    @Test(dataProvider = "getData")
    public void paymentTest(String paymentOption, Map<String, String> paymentDetails) {
        this.paymentScreen.goTo();
        driver.manage().window().maximize();
        this.paymentScreen.getUserInfo().enterDetails("Max", "Osipa", "email@email.com");
        this.paymentScreen.setPaymentOption(PaymentOptionFactory.get(paymentOption));
        this.paymentScreen.getPaymentOption().enterPaymentInfo(paymentDetails);
        String placeOrder = this.paymentScreen.getOrder().placeOrder();
        System.out.println(placeOrder);
    }

    @DataProvider
    public Object[][] getData() {
        Map<String, String> cc = Maps.newHashMap();
        cc.put("cc", "1235");
        cc.put("year", "2023");
        cc.put("cvv", "123");

        Map<String, String> nb = Maps.newHashMap();
        nb.put("bank", "WELLS FARGO");
        nb.put("account", "account123");
        nb.put("pin", "999");

        return new Object[][]{
                {"CC", cc},
                {"NB", nb}
        };
    }
}
