package com.automation.tests;

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
import  static org.testng.Assert.*;



public class Practise{
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/";
private By userNameBy=By.id("prependedInput");
    private By passwordBy=By.id("prependedInput");
  private By alertBy=By.className("alert alert-error");

    @Test(description = "verify warning when user enter invalid user name")
    public void invalidUserName() {
driver.findElement(userNameBy).sendKeys("ghoya");
        driver.findElement(passwordBy).sendKeys("123", Keys.ENTER);
        BrowserUtils.wait(3);
       WebElement warningElement= driver.findElement(alertBy);
       assertTrue(warningElement.isDisplayed());
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
            driver=null;
        }
    }
}