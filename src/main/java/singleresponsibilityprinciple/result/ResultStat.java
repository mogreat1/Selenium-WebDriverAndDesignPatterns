package singleresponsibilityprinciple.result;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import singleresponsibilityprinciple.common.AbstractComponent;

public class ResultStat extends AbstractComponent {

    @FindBy(xpath = "//*[@id='result-stats']")
    private WebElement stats;

    public ResultStat(WebDriver driver) {
        super(driver);
    }

    public String getStats(){
        return this.stats.getText();
    }

    @Override
    public boolean isDisplayed() {
        return this.wait.until((d) ->this.stats.isDisplayed());
    }
}
