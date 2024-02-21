package pages.LoginPage;


import helper.CommonActions;
import pages.PostAdPage.PostAdAbstract;


public abstract class LoginPageAbstract extends CommonActions  {


    public LoginPageAbstract() {
        super();
    }

    public abstract boolean elementDisplayed() throws InterruptedException;

    public abstract PostAdAbstract loginWithPhoneNumberAndPassword() ;




}
