package factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleFrench extends GoogleEnglish {

    private final static String URL = "https://www.google.fr";

    @FindBy(xpath = "//*[contains(@id,'additional_languages')]/div/a")
    private WebElement language;

    public GoogleFrench(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get(URL);
        clickBtn();
        this.language.click();
    }
}
