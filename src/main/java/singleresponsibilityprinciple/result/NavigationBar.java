package singleresponsibilityprinciple.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import singleresponsibilityprinciple.common.AbstractComponent;

public class NavigationBar extends AbstractComponent {

    @FindBy(xpath = "//*[text()='News']")
    private WebElement newsTabs;

    public NavigationBar(WebDriver driver) {
        super(driver);
    }

    public void goToNews(){
        this.newsTabs.click();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.newsTabs.isDisplayed());
    }
}
