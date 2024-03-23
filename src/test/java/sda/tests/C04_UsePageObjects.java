package sda.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sda.pages.sauceDemo.InventoryPage;
import sda.pages.sauceDemo.LoginPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C04_UsePageObjects {
    /*
    Navigate to https://www.saucedemo.com/
Enter the user name as standard_user
Enter the password as secret_sauce
Click on login button.
- Choose price low to high with soft Assert.
- Verify item prices are sorted from low to high with hard Assert.
     */


    @Test
    public void pageObjectTest(){

        LoginPage loginPage = new LoginPage();
        InventoryPage inventoryPage = new InventoryPage();

        Driver.getDriver().get(ConfigReader.getProperty("sauceDemoUrl"));

        loginPage.usernameFiled.sendKeys(ConfigReader.getProperty("saucedemousername"));
        loginPage.passwordFiled.sendKeys(ConfigReader.getProperty("saucedemopassword"));
        loginPage.loginButton.click();

        inventoryPage.selectByIndex(2);
       // inventoryPage.selectByVisibleText("Price (low to high)");
        String optionText = inventoryPage.getTextOfSelectedOption();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(optionText.contains("low to high"));
        softAssert.assertAll();

        Assert.assertTrue(optionText.contains("low to high")); //hard
        Driver.closeDriver();




    }
}
//        loginPage.login(
//                ConfigReader.getProperty("saucedemousername")
//                ,ConfigReader.getProperty("saucedemopassword"));