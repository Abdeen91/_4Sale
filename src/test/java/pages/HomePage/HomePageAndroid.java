package pages.HomePage;

import pages.LoginPage.LoginPageAndroid;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;

public class HomePageAndroid extends HomePageAbstract {
    private AndroidDriver driver;

    By linktest = By.xpath("abd)");

    public HomePageAndroid(AppiumDriver driver) {
        this.driver = (AndroidDriver) driver;
    }

    By postAdBtn = By.id("com.forsale.forsale:id/navgraph_postad");



    @Override
    public LoginPageAndroid tapOnPostAnAd() throws InterruptedException {
        waitForVisibility(postAdBtn);
        this.driver.findElement(postAdBtn).click();
        return new LoginPageAndroid(driver);
    }
}
