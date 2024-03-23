package sda.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

import static sda.utilities.Driver.driver;

public class DhtmlgoodiesTest {

    public DhtmlgoodiesTest() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public void dragCapitolInCountryBox(String capital, String country) {
        By cap = By.xpath("//div[text()='" + capital + "'][2]");
        By count = By.xpath("//div[text()='" + country + "']");

        WebElement capitalBox = driver.findElement(cap);
        WebElement countryBox = driver.findElement(count);
        Actions action = new Actions(Driver.getDriver());
        action.dragAndDrop(capitalBox, countryBox).perform();
    }
}
