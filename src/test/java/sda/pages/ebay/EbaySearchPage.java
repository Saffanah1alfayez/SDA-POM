package sda.pages.ebay;

import net.bytebuddy.jar.asm.Handle;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class EbaySearchPage {

    public EbaySearchPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "gh-ac")
    public WebElement searchBox;

    @FindBy(css= "\"ul.srp-results li.s-item:first-child\"")
    public WebElement item;

    public void searchAndSelectItem() throws InterruptedException {
        searchBox.sendKeys("book"+ Keys.ENTER);
        Thread.sleep(2000);
        item.click();
    }
}
//"(//*[@data-atftimer='1711021255502'])[1]"