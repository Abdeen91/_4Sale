package pages.HomePage;

import helper.CommonActions;
import pages.LoginPage.LoginPageAbstract;

public abstract class HomePageAbstract extends CommonActions {


    public HomePageAbstract() {
    }

    public abstract LoginPageAbstract tapOnPostAnAd() throws InterruptedException;
}
