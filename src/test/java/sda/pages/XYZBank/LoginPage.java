package sda.pages.XYZBank;

import com.github.javafaker.Faker;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import sda.utilities.Driver;

import javax.swing.text.TableView;
import java.util.List;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath= "(//button[@class='btn btn-primary btn-lg'] )[2]")
    public WebElement bankManagerLogin;

    @FindBy(xpath = "//button[@ng-class='btnClass1']")
    public WebElement addCustomer;

    @FindBy(xpath = "//input[@ng-model='fName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@ng-model='lName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@ng-model='postCd']")
    public WebElement postCode;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement addCustometButton;

    @FindBy(xpath = "//button[@class='btn btn-lg tab btn-primary']")
    public WebElement customersButton;

//    @FindBy(xpath = "//table[@class='table table-bordered table-striped']")
//    public WebElement customerTable;


    public void fakelogin(){

        bankManagerLogin.click();
        addCustomer.click();

        Faker faker = new Faker();

        for( int i =0 ; i < 5 ; i++) {

            firstName.sendKeys(faker.name().firstName());
            lastName.sendKeys(faker.name().lastName());
            postCode.sendKeys(faker.address().zipCode());

            addCustometButton.click();

            Alert alert = Driver.driver.switchTo().alert();
            alert.accept();
        }
    }

    public int getTableRowCount () {

        customersButton.click();

//        List<WebElement> rows = Driver.getDriver().
//        findElements(By.cssSelector("table.table tbody tr"));
//        return rows.size();
        //Assert.assertEquals(rowCount, 5, "Number of customers not as expected.");
        return 0;
    }
}
