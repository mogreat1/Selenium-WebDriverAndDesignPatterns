package proxy;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import proxy.components.OrderComponent;
import proxy.components.OrderComponentProxy;
import proxy.components.OrderComponentReal;
import proxy.components.UserInfo;
import proxy.paymentOptions.PaymentOption;

public class PaymentScreen {

    private WebDriver driver;
    private UserInfo userInfo;
    private OrderComponent orderComponent;
    private PaymentOption paymentOption;

    public PaymentScreen(final  WebDriver driver) {
        this.driver = driver;
        this.userInfo = PageFactory.initElements(driver, UserInfo.class);
        this.orderComponent = new OrderComponentProxy(driver);
    }

    public void goTo(){
        this.driver.get("https://vins-udemy.s3.amazonaws.com/ds/strategy.html");
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public OrderComponent getOrder() {
        return this.orderComponent;
    }

    public void setPaymentOption(PaymentOption paymentOption) {
        this.paymentOption = paymentOption;
        PageFactory.initElements(driver, this.paymentOption);
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }
}
