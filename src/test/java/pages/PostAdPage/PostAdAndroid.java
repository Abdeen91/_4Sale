package pages.PostAdPage;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostAdAndroid extends PostAdAbstract{

    private AndroidDriver driver;

    public PostAdAndroid(AndroidDriver driver) {
        this.driver = driver;
    }
    By selectOption(String name) {
        return By.xpath("//*[@text = '" + name + "']");
    }

    By categoryField = By.id("chooseCategoryField");
   // By electronicsOpt = By.xpath("//*[@text = 'Electronics']");
  //  By tabletsOpt = By.xpath("//*[@text = 'Tablets / IPads']");
    By nextBtn = By.id("compose_view");
    By errorToastMsg = By.xpath("//android.widget.Toast[@text=\"Kindly Fill all the required information!\"]");
    By errorFieldMsgs = By.xpath("//android.widget.TextView[@resource-id=\"com.forsale.forsale:id/textinput_error\"]");
    By locationField = By.id("chooseDistrictField");
    By districtField = By.id("locationSelectorText");
   // By districtList = By.id("rvSelection");
    By doneBtn = By.id("btnProceed");

    By doneCTA = By.xpath("*//android.view.View/android.view.View/android.widget.Button");

    By titleField = By.id("adTitleField");
    By priceField = By.id("adPriceField");


    By mediaTitle = By.xpath("//*[@text=\"Add Media\"]");


    @Override
    public void selectCategory() {
        waitForVisibility(categoryField);
        tap(categoryField);
        tap(selectOption("Electronics"));
        waitForVisibility(selectOption("Tablets / IPads"));
        tap(selectOption("Tablets / IPads"));
    }

    @Override
    public String validateErrorToastMassage() {
        String errorToast = driver.findElement(errorToastMsg).getText();
        return errorToast;
    }

    @Override
    public List<WebElement> validateErrorMassages() {
        List<WebElement> errorFields = driver.findElements(errorFieldMsgs);
        return errorFields;
    }

    @Override
    public void selectLocation() {
        tap(locationField);
        tap(districtField);
        tap(selectOption("Kuwait City"));
        tap(doneBtn);
        tap(doneCTA);

    }

    @Override
    public void enterTitle() {
        enterValue(titleField,"Testing123456");
    }

    @Override
    public void enterPrice() {
        enterValue(priceField,"500");

    }

    @Override
    public void tapOnNextCTA() {
        waitForVisibility(titleField);
        tap(nextBtn);
    }

    @Override
    public void validateMediaScreenDisplayed() {
        driver.findElement(mediaTitle).isDisplayed();
    }
}
