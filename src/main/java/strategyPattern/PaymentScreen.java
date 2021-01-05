package strategyPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import strategyPattern.components.Order;
import strategyPattern.components.UserInfo;
import strategyPattern.paymentOptions.PaymentOption;

public class PaymentScreen {

    private WebDriver driver;
    private UserInfo userInfo;
    private Order order;
    private PaymentOption paymentOption;

    public PaymentScreen(final  WebDriver driver) {
        this.driver = driver;
        this.userInfo = PageFactory.initElements(driver, UserInfo.class);
        this.order = PageFactory.initElements(driver, Order.class);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public Order getOrder() {
        return order;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }
}
