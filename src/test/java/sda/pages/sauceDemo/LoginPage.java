package sda.pages.sauceDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sda.utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    @FindBy(id = "user-name")
    public WebElement usernameFiled;

    @FindBy(id = "password")
    public WebElement passwordFiled;

    @FindBy(id = "login-button")
    public WebElement loginButton;


    public void login(String name , String password){
        usernameFiled.sendKeys(name);
        passwordFiled.sendKeys(password);
        loginButton.click();


    }
}
