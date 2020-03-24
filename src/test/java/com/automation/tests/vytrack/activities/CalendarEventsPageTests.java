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

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CalendarEventsPageTests {
    /**
     * TASK
     * <p>
     * Scenario: Verify for store manager
     * <p>
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
    private By createCalendarEventButtonBy = By.cssSelector("a[title='Create Calendar event']");

    private By currentUserBy = By.cssSelector("#user-menu > a");
    private By ownerBy = By.id("s2id_oro_calendar_event_form_calendar");//By.className("select2-chosen")
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    private By startDateBy = By.cssSelector("[id*='date_selector_oro_calendar_event_form_start-uid']");
    private By startTimeBy = By.cssSelector("[id*='time_selector_oro_calendar_event_form_start-uid']");

    @Test
    public void verifyCreateButton() {
        WebElement createCalendarEventBtn = driver.findElement(createCalendarEventButtonBy);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());
        BrowserUtils.wait(10);
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createADriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();
        actions = new Actions(driver);
        driver.findElement(usernameBy).sendKeys(managerUsername);
        driver.findElement(passwordBy).sendKeys(managerPassword, Keys.ENTER);
        BrowserUtils.wait(5);
//hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(5);

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
    @Test(description = "Default Option")
    public void VerifyDefaultValues() {
        driver.findElement(createCalendarEventButtonBy).click();
        BrowserUtils.wait(10);
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName, defaultOwnerName);
        //        Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());
        //date time syntax = https://www.journaldev.com/17899/java-simpledateformat-java-date-format
        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
    Assert.assertEquals(expectedDate,actualDate);
   String expectedTime=LocalDate.now().format(DateTimeFormatter.ofPattern("h:m a"));
  //      String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
String actualTime=driver.findElement(startTimeBy).getAttribute("value");
Assert.assertEquals(actualTime,expectedTime);
}
    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
