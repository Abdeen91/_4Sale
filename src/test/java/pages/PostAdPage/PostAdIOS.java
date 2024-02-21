package pages.PostAdPage;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PostAdIOS extends PostAdAbstract {

    private IOSDriver driver;

    public PostAdIOS(IOSDriver driver) {
        this.driver = driver;
    }

    @Override
    public void selectCategory() {

    }

    @Override
    public String validateErrorToastMassage() {
        return null;
    }

    @Override
    public List<WebElement> validateErrorMassages() {
        return null;
    }

    @Override
    public void selectLocation() {

    }

    @Override
    public void enterTitle() {

    }

    @Override
    public void enterPrice() {

    }

    @Override
    public void tapOnNextCTA() {

    }

    @Override
    public void validateMediaScreenDisplayed() {
    }
}
