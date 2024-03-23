package sda.tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class BankingTest {
    private WebDriver driver;
    private String baseUrl = "https://www.globalsqa.com/angularJs-protractor/BankingProject/#/login";
    private String customerName = "John Doe";
    private String customerCurrency = "Dollar";

    @BeforeClass
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "path_to_chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void testCreateCustomers() {
        driver.get(baseUrl);
        driver.findElement(By.cssSelector("[ng-click='manager()']")).click();

        // Add 5 customers
        for (int i = 0; i < 5; i++) {
            addCustomer(customerName + " " + i);
        }

        // Verify 5 customers created
        driver.findElement(By.cssSelector("[ng-click='showCust()']")).click();
        Assert.assertEquals(getTableRowCount(), 5, "Number of customers not as expected.");
    }

    @Test(priority = 2)
    public void testDepositAndWithdraw() {
        // Login as a customer
        driver.findElement(By.cssSelector("[ng-click='customer()']")).click();
        driver.findElement(By.cssSelector("[ng-click='login()']")).click();
        new Select(driver.findElement(By.id("userSelect"))).selectByVisibleText(customerName + " 0");
        driver.findElement(By.cssSelector("[type='submit']")).click();

        // Deposit
        driver.findElement(By.cssSelector("[ng-click='deposit()']")).click();
        driver.findElement(By.cssSelector("[ng-model='amount']")).sendKeys("100");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Assert.assertTrue(isTransactionSuccessful(), "Deposit was not successful.");

        // Withdraw
        driver.findElement(By.cssSelector("[ng-click='withdrawl()']")).click();
        driver.findElement(By.cssSelector("[ng-model='amount']")).sendKeys("100");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        Assert.assertTrue(isTransactionSuccessful(), "Withdrawal was not successful.");

        // Logout
        driver.findElement(By.cssSelector("[ng-click='byebye()']")).click();
    }

    @Test(priority = 3)
    public void testDeleteAccounts() {
        // Login as a bank manager
        driver.findElement(By.cssSelector("[ng-click='manager()']")).click();
        driver.findElement(By.cssSelector("[ng-click='showCust()']")).click();

        // Delete accounts
        for (int i = 0; i < 5; i++) {
            driver.findElement(By.xpath("//button[text()='Delete']")).click();
            driver.switchTo().alert().accept();
        }

        // Verify accounts deleted
        Assert.assertEquals(getTableRowCount(), 0, "Number of customers not as expected after deletion.");
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    private void addCustomer(String name) {
        driver.findElement(By.cssSelector("[ng-click='addCust()']")).click();
        driver.findElement(By.cssSelector("[ng-model='fName']")).sendKeys(name);
        driver.findElement(By.cssSelector("[ng-model='lName']")).sendKeys("Doe");
        driver.findElement(By.cssSelector("[ng-model='postCd']")).sendKeys("12345");
        driver.findElement(By.cssSelector("[type='submit']")).click();
        driver.switchTo().alert().accept();
    }

    private int getTableRowCount() {
        return driver.findElements(By.cssSelector("table.table tbody tr")).size();
    }

    private boolean isTransactionSuccessful() {
        try {
            return driver.findElement(By.xpath("//span[contains(text(),'Transaction successful')]")).isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
