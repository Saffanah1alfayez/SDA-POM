package sda.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import sda.pages.XYZBank.LoginPage;
import sda.utilities.Driver;

public class C09_XYZBank {

    @Test
    public void Test() throws InterruptedException {

        LoginPage loginPage = new LoginPage();

        String url = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
        Driver.getDriver().get(url);

        loginPage.fakelogin();
        Thread.sleep(2000);
        loginPage.getTableRowCount();

        //Assert.assertEquals(loginPage.getTableRowCount(), 5, "Number of customers not as expected.");
    }



}
