package aroundmethodpattern.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FrameA {

    private WebDriver driver;

    @FindBy(name = "fn")
    private WebElement firstName;
    @FindBy(name = "ln")
    private WebElement lastName;
    @FindBy(name = "addr")
    private WebElement address;
    @FindBy(id = "area")
    private WebElement messageField;

    public FrameA(WebDriver driver) {
        this.driver = driver;
    }

    public void setFirstName(String firstName){
        this.firstName.sendKeys(firstName);
    }

    public void setLastName(String lastName){
        this.lastName.sendKeys(lastName);
    }

    public void setAddress(String address){
        this.address.sendKeys(address);
    }

    public void setMessage(String message){
        this.messageField.sendKeys(message);
    }
}
