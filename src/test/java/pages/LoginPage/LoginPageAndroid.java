package pages.LoginPage;

import helper.PropertiesLoader;
import pages.PostAdPage.PostAdAbstract;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import pages.PostAdPage.PostAdAndroid;


public class LoginPageAndroid extends LoginPageAbstract {

    private static String phoneNumber = PropertiesLoader.readTestdata("phonenumber");
    private static String password = PropertiesLoader.readTestdata("password");
    By phoneNumberTxt = By.xpath("//android.view.View[@resource-id=\"phoneNumberField\"]/android.view.View/android.widget.EditText");
    By passwordTxt = By.xpath("*//android.view.View[2]/android.view.View/android.widget.EditText");
    By loginBtn = By.xpath("//android.view.View[@resource-id=\"loginBtn\"]/android.widget.Button");
    private AndroidDriver driver;

    public LoginPageAndroid(AndroidDriver driver) {
        this.driver = driver;
    }

    public boolean elementDisplayed(){
        driver.findElement(phoneNumberTxt).isDisplayed();
        return true;
    }

    @Override
    public PostAdAndroid loginWithPhoneNumberAndPassword() {
        waitForVisibility(phoneNumberTxt);
        enterValue(phoneNumberTxt,phoneNumber);
        enterValue(passwordTxt,password);
        tap(loginBtn);
        return new PostAdAndroid(driver);
    }



}
