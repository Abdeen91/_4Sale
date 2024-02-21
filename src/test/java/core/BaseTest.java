package core;

import com.google.common.io.Files;
import helper.PropertiesLoader;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.HomePage.HomePageAbstract;
import pages.HomePage.HomePageAndroid;
import pages.HomePage.HomePageIOS;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import static core.DriverConstants.*;

public class BaseTest {


    private static String platform = System.getProperty("PLATFORM", PropertiesLoader.readPlatform("PLATFORM"));

    private static AppiumDriver driver;
    private static UiAutomator2Options androidCaps = new UiAutomator2Options();
    private static XCUITestOptions iosCaps = new XCUITestOptions();

    private final Config config = new Config();

    protected HomePageAbstract homePage;

    public BaseTest( ) {
    }

    @BeforeClass
    public void setUp() {

        try {
            if (platform.equalsIgnoreCase("Android")) {
                driver = new AndroidDriver(new URL(PropertiesLoader.readConfig(APPIUM_URL)), setAndroidCaps());
            } else if (platform.equalsIgnoreCase("ios")) {
                driver = new IOSDriver(new URL(PropertiesLoader.readConfig(APPIUM_URL)), setIOSCaps());
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("The appium server URL is incorrect, please check it again.", e);
        } catch (WebDriverException ee) {
            throw new RuntimeException("Kindly be sure installing of UIAutomator2/XCUITEST - Start Appium Server and Check properties files", ee);
        }
    }

    public static final AppiumDriver getDriver(){
        return driver;
    }




    @BeforeMethod
    public void goHome() {
        if (config.isAndroid()) this.homePage = new HomePageAndroid(driver);
        if (config.isIos()) this.homePage = new HomePageIOS(driver);

    }




    private static UiAutomator2Options setAndroidCaps() {
        Properties prop = PropertiesLoader.readPropertyFile(PropertiesLoader.readConfig(ANDROID));
        if(prop.getProperty("APP_INSTALLED").equalsIgnoreCase(String.valueOf(false))){
            androidCaps.setApp(System.getProperty("user.dir") + "/apps/4Sale.apk");
        }
        androidCaps.setAppPackage("com.forsale.forsale");
        androidCaps.setAppActivity("com.forsale.app.features.maincontainer.LauncherActivity");
        androidCaps.setPlatformName(prop.getProperty("PLATFORM_NAME")); //optional
        androidCaps.setAutomationName(AutomationName.ANDROID_UIAUTOMATOR2);//optional
        androidCaps.setDeviceName(prop.getProperty("DEVICE_NAME"));
        return androidCaps;
    }


    private static XCUITestOptions setIOSCaps() {
        Properties prop = PropertiesLoader.readPropertyFile(PropertiesLoader.readConfig(IOS));
        iosCaps.setDeviceName(prop.getProperty("DEVICE_NAME"));
        iosCaps.setCapability(MobileCapabilityType.UDID, System.getProperty("UUID", prop.getProperty("UUID")));
        iosCaps.setCapability(MobileCapabilityType.APP, System.getProperty("APP", prop.getProperty("APP")));
        return iosCaps;
    }



    @AfterMethod
    public void recordFailure(ITestResult result) {
        if (2 == result.getStatus()) {
            TakesScreenshot camera = driver;
            File screenshot = camera.getScreenshotAs(OutputType.FILE);

            try {
                Files.move(screenshot, new File("screenshots/" + result.getName() + ".png"));
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }
    }


    @AfterClass
    public void tearDown() {
        if(null != driver){
            driver.quit();
        }
    }
}

