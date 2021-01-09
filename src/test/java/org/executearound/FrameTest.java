package org.executearound;

import aroundmethodpattern.components.MainPage;
import org.BaseTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.reporters.jq.Main;

public class FrameTest extends BaseTest {

    private MainPage mainPage;
    //Before running need to swith to @BeforeTest/AfterTest

    @BeforeTest
    public void setMainPage() {
        this.mainPage = new MainPage(driver);
    }

    @Test
    public void frameTest() {
        this.mainPage.goTo();
        this.mainPage.onFrameA(a -> a.setFirstName("Name"));
        this.mainPage.onFrameB(b -> b.setFirstName("Name2"));
        this.mainPage.onFrameC(c -> {
            c.setLastName("LastName");
            c.setMessage("Long Message");
        });
    }
}
