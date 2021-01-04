package singleresponsibilityprinciple.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import singleresponsibilityprinciple.common.AbstractComponent;

public class BeforeYouContinue extends AbstractComponent {

    @FindBy(xpath = "//span[text()='I agree']")
    private WebElement agreeBtn;

    public BeforeYouContinue(WebDriver driver) {
        super(driver);
    }

    public void clickBtn() {
        this.agreeBtn.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.agreeBtn.isDisplayed());
    }
}
