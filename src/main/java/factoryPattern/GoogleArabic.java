package factoryPattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

class GoogleArabic extends GoogleEnglish {

    @FindBy(xpath = "//*[contains(@id,'additional_languages')]/div/a")
    private WebElement language;
    @FindBy(xpath = "//*[@class='hOoLGe']")
    private WebElement keyboardBtn;
    @FindBy(xpath = "//*[@id='kbd']")
    private WebElement keyboard;

    public GoogleArabic(WebDriver driver) {
        super(driver);
    }

    @Override
    public void launchSite() {
        this.driver.get("https://www.google.com.sa");
        clickBtn();
        this.language.click();
    }

    @Override
    public void search(String keyword) {
        this.wait.until((d) -> this.keyboardBtn.isDisplayed());
        this.keyboardBtn.click();
        this.wait.until((d) -> this.keyboard.isDisplayed());
        super.search(keyword);

    }
}
