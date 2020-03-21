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

public class CalendarEventsPageTests {
/**
 * TASK
 *
 * Scenario: Verify for store manager
 *
 * Login as story manager
 * Go to Activities --> Calendar Events
 * Verify that Create Calendar Event button is displayed
 */

private String managerUsername = "storemanager85";
    private String managerPassword = "UserUser123";
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private WebDriver driver;
    private Actions actions;
    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Activities')]");

   private  By calendarEventButtonBy=By.cssSelector("a[title='Calendar Events']");
   private By currentUserBy=By.cssSelector("#user-menu > a");
   private By ownerBy=By.className("select2-chosen");//By.id("s2id_oro_calendar_event_form_calendar");//
private  By titleBy =By.cssSelector("[name='oro_calendar_event_form[title]']");
@Test
public void verifyCreateButton() {
    WebElement createCalendarEventBtn=driver.findElement(calendarEventButtonBy);
    Assert.assertTrue(createCalendarEventBtn.isDisplayed());

}
 /*   Test Case: Default options
    Login as sales manager
    Go to Activities --> Calendar Events
    Click on Create Calendar Event
    Default owner name should be current user
    Default title should be blank
    Default start date should be current date
    Default start time should be current time
*/
    @BeforeMethod
    public void setUp() {
        driver= DriverFactory.createADriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        BrowserUtils.wait(3);
        driver.findElement(usernameBy).sendKeys(managerUsername);
        driver.findElement(passwordBy).sendKeys(managerPassword, Keys.ENTER);
        BrowserUtils.wait(3);
//hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(2);
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);

    }

    @Test(description = "Default Option")
    public void VerifyDefaultValues() {
     driver.findElement(calendarEventButtonBy).click();
        BrowserUtils.wait(5);
       String currentUserName=driver.findElement(currentUserBy).getText();
        String defaultOwnerName=driver.findElement(ownerBy).getText();
        Assert.assertEquals(currentUserName,defaultOwnerName);
        WebElement titleElement=driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
