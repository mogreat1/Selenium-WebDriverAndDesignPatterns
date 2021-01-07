package org.command;

import command.HomePage;
import org.BaseTest;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {

    private HomePage homePage;

    @BeforeMethod
    public void setHomePage() {
        this.homePage = new HomePage(driver);
    }

    @Test
    public void homePage() {
        this.homePage.goTo();
        this.homePage.getElementValidators()
                .stream()
                .parallel()
                .map(ev -> ev.validate())
                .forEach(b -> Assert.assertTrue(b));
    }
}
