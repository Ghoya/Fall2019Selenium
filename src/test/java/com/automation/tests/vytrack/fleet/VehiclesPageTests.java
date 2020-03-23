package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
/**
 *
 ######## TASK
 under fleet package create a class called VehiclesPageTests
 In this class, you will need to create @beforemethod with setup and @aftermethod with teardown part. Use LoginPageTests class as a reference.
 create a test called verifyPageSubTitle
 - in this test, you will need to navigate to Fleet --> Vehicles and verify that page subtitle is equals to "All Cars"
 user assertions for validation.
 */
public class VehiclesPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/";
    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String username = "storemanager85";
    private String password = "UserUser123";
    private  By fleetBy=By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span");
  private By subTitleBy=By.className("oro-subtitle");
  private By pageNumberBy= By.cssSelector("input[type='number']");
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test

    public void verifyPageNumber() {
        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(7);
        Actions  actions=new Actions(driver);
        //move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform();
        BrowserUtils.wait(2);
// click on Vihcle
        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(2);
        //find subtitle element
        WebElement subTitleElement=  driver.findElement(subTitleBy);
        BrowserUtils.wait(10);
       String expected="1";
       String actual=driver.findElement(pageNumberBy).getAttribute("value");
       Assert.assertEquals(actual,expected);
    }

    @Test
    public void verifyPageSubTitle() {
        //login
        driver.findElement(userNameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(7);
// click on fleet
 //    driver.findElement(fleetBy).click();
        //Actions class is used for more advanced browser interactions
    Actions  actions=new Actions(driver);
        //move to element instead of click
    actions.moveToElement(driver.findElement(fleetBy)).perform();
        //perform - to execute command
        //every action should end with perform()
        BrowserUtils.wait(2);
// click on Vihcle
     driver.findElement(By.linkText("Vehicles")).click();
        //put more wait time if you are getting Cars, Dashboard...
        //this application is slooooow...
        BrowserUtils.wait(10);
        //find subtitle element
        WebElement subTitleElement=  driver.findElement(subTitleBy);
        BrowserUtils.wait(10);
        System.out.println(subTitleElement.getText());
        String expected="All Cars";
        String actual=subTitleElement.getText();
        Assert.assertEquals(actual,expected);

    }

    @AfterMethod
    public void tearDown() {
        //if webdriver object alive
        if (driver != null) {
            //close browser, close session
            driver.quit();
            //destroy webdriver object for sure
            driver = null;
        }
    }
}
