package tamplate;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import tamplate.pages.AmazonProductPage;
import tamplate.pages.AmazonResultsPage;
import tamplate.pages.AmazonSearchPage;

public class AmazonShopping extends ShoppingTemplate {

    private WebDriver driver;
    private String product;
    private AmazonSearchPage amazonSearchPage;
    private AmazonResultsPage amazonResultsPage;
    private AmazonProductPage amazonProductPage;

    public AmazonShopping(WebDriver driver, String product) {
        this.driver = driver;
        this.product = product;
        this.amazonSearchPage = PageFactory.initElements(driver, AmazonSearchPage.class);
        this.amazonResultsPage = PageFactory.initElements(driver, AmazonResultsPage.class);
        this.amazonProductPage = PageFactory.initElements(driver, AmazonProductPage.class);
    }

    @Override
    public void launchSite() {
        this.amazonSearchPage.goTo();
    }

    @Override
    public void searchForProduct() {
        this.amazonSearchPage.search(this.product);
    }

    @Override
    public void selectProduct() {
        this.amazonResultsPage.selectProduct();
    }

    @Override
    public void buy() {
        this.amazonProductPage.buy();
    }
}
