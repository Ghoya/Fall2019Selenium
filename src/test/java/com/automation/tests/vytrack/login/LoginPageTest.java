package com.automation.tests.vytrack.login;
import static org.testng.Assert.*;
import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/";
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private By warningMessageBy = By.cssSelector("[class='alert alert-error']>div");

    @Test(description = "warning for invalid user name")
    public void invalidUserNameTest() {
//driver.findElement(By.name("_username")).sendKeys("invalidUserName");
        driver.findElement(userNameBy).sendKeys("invalidUserName");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        //   WebElement warningElement=driver.findElement(By.className("alert alert-error"));
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed());
        String expected = "Invalid user name and password";
        String actual = warningElement.getText();
        assertEquals(actual, expected);
    }

    @Test(description = "log in as store manager and verify that ")
    public void logInAsStoreManager() {
    }


    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


