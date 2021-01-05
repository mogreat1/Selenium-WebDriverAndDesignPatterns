package org.factoryPattern;

import factoryPattern.GoogleFactory;
import factoryPattern.GooglePage;
import org.BaseTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class GoogleSearchTest extends BaseTest {

    private GooglePage googlePage;

    @Test(dataProvider = "getDate")
    public void searchTest(String language, String keyword) {
        this.googlePage = GoogleFactory.get(language, this.driver);
        this.googlePage.launchSite();
        this.googlePage.search(keyword);
        int resultCount = this.googlePage.getResultsCount();

        System.out.println("Result: " + resultCount);
    }

    @DataProvider
    public Object[][] getDate() {
        return new Object[][]{
                {"ENG", "selenium"},
                {"FR", "selenium"},
                {"SA", "selenium"}
        };
    }
}
