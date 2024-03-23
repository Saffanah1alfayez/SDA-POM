package sda.pages.ebay;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import sda.utilities.Driver;

public class EbayItemPage {

    public EbayItemPage() {PageFactory.initElements(Driver.getDriver(),this);}
    @FindBy (xpath = "//*[.='Add to cart']")
    public WebElement addButton;

   @FindBy (id = "dropdown-856472913-520fc661-8ed2-467e-908e-38b5942f8fc3")
   public WebElement dropDown;

    public void clickAddButton() throws InterruptedException {

        Actions actions = new Actions(Driver.getDriver());
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(5000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        addButton.click();
        Select select = new Select(dropDown);
        select.selectByIndex(4);
    }
}
