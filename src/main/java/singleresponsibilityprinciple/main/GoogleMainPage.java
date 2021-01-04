package singleresponsibilityprinciple.main;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import singleresponsibilityprinciple.common.SearchSuggestion;
import singleresponsibilityprinciple.common.SearchWidget;

public class GoogleMainPage {

    private WebDriver driver;
    private SearchWidget searchWidget;
    private SearchSuggestion searchSuggestion;
    private BeforeYouContinue beforeYouContinue;

    public GoogleMainPage(final WebDriver driver) {
        this.driver = driver;
        this.searchWidget = PageFactory.initElements(driver, SearchWidget.class);
        this.searchSuggestion = PageFactory.initElements(driver, SearchSuggestion.class);
        this.beforeYouContinue = PageFactory.initElements(driver, BeforeYouContinue.class);
    }

    public void goTo() {
        this.driver.get("https://www.google.pl/");
        this.driver.manage().window();
    }

    public void swithToFrame(){
        driver.switchTo().frame(0);
    }

    public SearchWidget getSearchWidget() {
        return searchWidget;
    }

    public SearchSuggestion getSearchSuggestion() {
        return searchSuggestion;
    }

    public BeforeYouContinue getBeforeYouContinue() {
        return beforeYouContinue;
    }
}
