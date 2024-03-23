package sda.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sda.pages.FacebookLoginPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C06_FacebookNegativeLoginTest {

//Go to https://www.facebook.com/
//Log in (faker class)
//Test the "Failed to login" message

    @Test
    public void facebookTest(){
        FacebookLoginPage facebookLoginPage = new FacebookLoginPage();


        Driver.getDriver().get(ConfigReader.getProperty("facebookUrl"));


        facebookLoginPage.fakeLogin();
        facebookLoginPage.assertErrorMIsDisplayed();
        Assert.assertTrue(facebookLoginPage.errorMass.isDisplayed());

        //Driver.closeDriver();

    }

}
