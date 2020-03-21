package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2<JavascriptExceptor> {
private WebDriver driver;

    @Test
    public void verifyTitle() {
    String expected="";
        JavascriptExceptor js=(JavascriptExceptor)driver;
    //    String actual=js.executeScript("return ducument.title").toString();
  //      Assert.assertEquals(actual,expected);
    }

    @BeforeMethod
    public void setUp() {
driver= DriverFactory.createADriver("chrome");
driver.get("http://practice.cybertekschool.com/");
driver.manage().window().maximize();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(3);
        driver.quit();
    }



}
