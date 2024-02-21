package pages.LoginPage;

import pages.PostAdPage.PostAdAbstract;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.By;

public class LoginPageIOS extends LoginPageAbstract {

    private IOSDriver driver;

    By phoneNumberTxt = By.xpath("//*[@resource-id='phoneNumberField']");

    public LoginPageIOS(IOSDriver driver) {
        this.driver = driver;
    }

    @Override
    public boolean elementDisplayed() throws InterruptedException {
        driver.findElement(phoneNumberTxt).isDisplayed();
        return true;
    }

    @Override
    public PostAdAbstract loginWithPhoneNumberAndPassword() {
        return null;
    }


}
