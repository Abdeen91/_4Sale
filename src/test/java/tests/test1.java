package tests;

import core.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.PostAdPage.PostAdAbstract;

public class test1 extends BaseTest {

    @Test
    public void test() throws InterruptedException {
       PostAdAbstract postAd= homePage.tapOnPostAnAd().loginWithPhoneNumberAndPassword();
       postAd.selectCategory();
       postAd.tapOnNextCTA();
       Assert.assertEquals(postAd.validateErrorToastMassage(),"Kindly Fill all the required information!");
       Assert.assertEquals(postAd.validateErrorMassages().get(0).getText(),"Location information is mandatory");
       Assert.assertEquals(postAd.validateErrorMassages().get(1).getText(),"Required");
       Assert.assertEquals(postAd.validateErrorMassages().get(2).getText(),"Required");
       postAd.selectLocation();
       postAd.enterTitle();
       postAd.enterPrice();
       postAd.tapOnNextCTA();
       postAd.validateMediaScreenDisplayed();

    }
}


