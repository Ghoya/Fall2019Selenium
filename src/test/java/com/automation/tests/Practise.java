package com.automation.tests;


import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Practise {
private WebDriver driver;
@Test
public void googleSearchTest(){
    driver.get("http://google.com");
    driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
    BrowserUtils.wait(3);
    List<WebElement> searchItems=driver.findElements(By.tagName("h3"));
    for (WebElement searchItem:searchItems) {
       String var= searchItem.getText();
       if(!var.isEmpty()){
           System.out.println(var);
       //   Assert.assertTrue(var.toLowerCase().contains("java"));
       }
    }
}
@BeforeMethod
    public void setUp() {

      driver= DriverFactory.createADriver("chrome");

    }

    @AfterMethod
    public void tearDown() {
   driver.quit();
    }
}
