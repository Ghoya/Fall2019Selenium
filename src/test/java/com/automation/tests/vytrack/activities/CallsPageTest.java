package com.automation.tests.vytrack.activities;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import java.awt.*;

public class CallsPageTest {
    private String managerUsername = "storemanager85";
    private String managerPassword = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

  private  WebDriver driver;
  private Actions actions;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");



    @BeforeMethod
    public void setUp() {
      driver= DriverFactory.createADriver("chrome");
driver.get("https://qa2.vytrack.com/user/login");
driver.manage().window().maximize();
BrowserUtils.wait(5);
        driver.findElement(usernameBy).sendKeys(managerUsername);
        driver.findElement(passwordBy).sendKeys(managerPassword, Keys.ENTER);
        BrowserUtils.wait(5);
//hover over Activities
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(5);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);
    }
    /**
     * Scenario: Verify for store manager
     *
     * Login as story manager
     * Go to Activities --> Calls
     * Verify that Log Call button is displayed
     */
    @Test
    public void verifyLogCallButton(){
        WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
        Assert.assertTrue(logCallBtnElement.isDisplayed());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
