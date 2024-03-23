package sda.pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sda.utilities.Driver;

public class FacebookLoginPage {
    public FacebookLoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "email")
    public WebElement emailFiled;

    @FindBy(id = "pass")
    public WebElement passwordFiled;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    @FindBy(partialLinkText = "Find your account")
    public WebElement errorMass;

    public void fakeLogin()
    {
        Faker faker = new Faker();
        emailFiled.sendKeys(faker.internet().emailAddress());
        passwordFiled.sendKeys(faker.internet().password());
        loginButton.click();

    }

    public void assertErrorMIsDisplayed(){
        Assert.assertTrue(errorMass.isDisplayed());
    }

}
