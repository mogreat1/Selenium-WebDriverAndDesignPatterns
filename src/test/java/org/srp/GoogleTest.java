package org.srp;

import org.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import singleresponsibilityprinciple.main.GoogleMainPage;
import singleresponsibilityprinciple.result.GoogleResultPage;

public class GoogleTest extends BaseTest {

    private GoogleMainPage mainPage;
    private GoogleResultPage resultPage;

    @BeforeMethod
    public void setupPages() {
        this.mainPage = new GoogleMainPage(driver);
        this.resultPage = new GoogleResultPage(driver);
    }

    @Test(dataProvider = "getDate")
    private void googleWorkFlow(String keyword, int index) {
        mainPage.goTo();
        mainPage.swithToFrame();
        Assert.assertTrue(mainPage.getBeforeYouContinue().isDisplayed());

        mainPage.getBeforeYouContinue().clickBtn();
        Assert.assertTrue(mainPage.getSearchWidget().isDisplayed());

        mainPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(mainPage.getSearchSuggestion().isDisplayed());

        mainPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(resultPage.getNavigationBar().isDisplayed());

        resultPage.getSearchWidget().enter(keyword);
        Assert.assertTrue(resultPage.getSearchSuggestion().isDisplayed());

        resultPage.getSearchSuggestion().clickSuggestionByIndex(index);
        Assert.assertTrue(resultPage.getNavigationBar().isDisplayed());

        resultPage.getNavigationBar().goToNews();
        System.out.println(resultPage.getResultStat().getStats());
    }

    @DataProvider
    public Object[][] getDate() {
        return new Object[][]{
                {"selenium", 3},
                {"docker", 4}
        };
    }
}
