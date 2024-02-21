package pages.PostAdPage;

import helper.CommonActions;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class PostAdAbstract extends CommonActions {
    public PostAdAbstract() {

    }

    public abstract void selectCategory();

    public abstract String validateErrorToastMassage();
    public abstract List<WebElement> validateErrorMassages();
    public abstract void selectLocation();
    public abstract void enterTitle();
    public abstract void enterPrice();

    public abstract void tapOnNextCTA();

    public abstract void validateMediaScreenDisplayed();


}
