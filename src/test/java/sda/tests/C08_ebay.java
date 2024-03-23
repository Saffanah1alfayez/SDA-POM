package sda.tests;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import sda.pages.ebay.EbayItemPage;
import sda.pages.ebay.EbaySearchPage;
import sda.utilities.ConfigReader;
import sda.utilities.Driver;

public class C08_ebay {

    @Test
    public void test() throws InterruptedException {

        EbaySearchPage ebaySearchPage = new EbaySearchPage();
        EbayItemPage ebayItemPage = new EbayItemPage();

        Driver.getDriver().get(ConfigReader.getProperty("ebayUrl"));

        ebaySearchPage.searchAndSelectItem();

       // Driver.getDriver().get(ConfigReader.getProperty("itemUrl"));

        //ebayItemPage.clickAddButton();



    }
}
