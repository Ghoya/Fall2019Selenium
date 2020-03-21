package com.automation.tests.vytrack.login;
import static org.testng.Assert.*;// static import of all assertion
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
    //https is a secured version of http protocol
    //http - it's hypertext transfer protocol that every single website is using now days
    //https - data encrypted, no chance for hackers to retrieve info
    //http - data as a plain text, very easy to hack it
    private String URL = "https://qa2.vytrack.com/";
    //    CREDENTIALS FOR store manager
    private String username = "storemanager85";
    private String password = "UserUser123";
    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    // > in css selector means same thing as / in xpath - direct child
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
        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);
    }

    @Test(description = "log in as store manager and verify that title is equals to Dashboard ")
    public void logInAsStoreManager() {
      driver.findElement(userNameBy).sendKeys("storemanager85");
      driver.findElement(passwordBy).sendKeys("UserUser123",Keys.ENTER);
        BrowserUtils.wait(3);
String expectedTitle="Dashboard";
String actualTitle=driver.getTitle();
assertEquals(actualTitle,expectedTitle,"Page title is not correct!");
BrowserUtils.wait(5);
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
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver=null;
        }
    }
}


