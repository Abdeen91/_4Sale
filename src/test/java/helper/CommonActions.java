package helper;


import core.BaseTest;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public  class CommonActions extends BaseTest {
    static AppiumDriver driver = getDriver();
    public CommonActions() {
    }


    public static void waitForVisibility(By mobileElement) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        try {
            wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(mobileElement));
        }catch (Exception e) {
            System.out.println("Element not exist");
        }
    }



    public static FluentWait<WebDriver> fluentWait(Integer seconds, Integer pollTime) {

        FluentWait<WebDriver> fluentWait =
                new FluentWait<WebDriver>(driver)
                        .withTimeout(Duration.ofSeconds(seconds))
                        .pollingEvery(Duration.ofSeconds(pollTime))
                        .ignoring(WebDriverException.class);

        return fluentWait;
    }


    public static void tap(By element) {
        driver.findElement(element).click();
    }

    public static void enterValue(By element,String value){
        driver.findElement(element).sendKeys(value);
    }
}
