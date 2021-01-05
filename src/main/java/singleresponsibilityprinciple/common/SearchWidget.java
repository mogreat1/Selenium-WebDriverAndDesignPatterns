package singleresponsibilityprinciple.common;

import com.google.common.util.concurrent.Uninterruptibles;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SearchWidget extends AbstractComponent {

    @FindBy(xpath = "//*[@role='combobox']")
    private WebElement searchBox;

    public SearchWidget(final WebDriver driver) {
        super(driver);
    }

    public void enter(String keyword) {
        this.searchBox.clear();
        for (char ch : keyword.toCharArray()) {
            Uninterruptibles.sleepUninterruptibly(10, TimeUnit.MILLISECONDS);
            this.searchBox.sendKeys(ch + "");
        }
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) -> this.searchBox.isDisplayed());
    }
}
