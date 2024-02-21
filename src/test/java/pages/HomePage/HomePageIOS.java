package pages.HomePage;

import pages.LoginPage.LoginPageIOS;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class HomePageIOS extends HomePageAbstract {
    private IOSDriver driver;

    By linktest = By.xpath("abd)");

    public HomePageIOS(AppiumDriver driver) {
        this.driver = (IOSDriver) driver;
    }

    By postAdBtn = By.id("com.forsale.forsale:id/navgraph_postad");
    By phoneNumberTxt = By.xpath("//*[@resource-id='phoneNumberField']");
    By passwordTxt = By.xpath("*//android.view.View[2]/android.view.View/android.widget.EditText");
    By loginBtn = By.id("loginBtn");
    By categoryField = By.id("chooseCategoryField");
    By electronicsOpt = By.xpath("//*[@text = 'Electronics']");
    By tabletsOpt = By.xpath("//*[@text = 'Tablets / IPads']");
    By nextBtn = By.id("compose_view");
    By errorToastMsg = By.className("android.widget.Toast");  //android.widget.Toast[@text="Kindly Fill all the required information!"]
    By errorFieldMsg = By.id("textinput_error");
    By locationField = By.id("chooseDistrictField");
    By districtField = By.id("locationSelectorText");
    By districtList = By.id("rvSelection");
    By doneBtn = By.id("btnProceed");
    By proceedBtn = By.id("compose_view");
    By titleTxt = By.id("adTitleField");
    By priceTxt = By.id("adPriceField");
    By mediaTitle = By.xpath("//*[@text=\"Add Media\"]");


    @Override
    public LoginPageIOS tapOnPostAnAd() throws InterruptedException {
        Thread.sleep(20000);
        this.driver.findElement(postAdBtn).click();
        return new LoginPageIOS(driver);
    }
}
