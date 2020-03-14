package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.builder.ToStringExclude;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Collection;
import java.util.List;

public class SearchTests {
  private WebDriver driver;

  @Test
  public void googleSearchTest() {
    driver.get("http://google.com");
    driver.findElement(By.tagName("q")).sendKeys("java", Keys.ENTER);
    BrowserUtils.wait(2);
    //since every search item has a tag name <h3>
    //it's the easiest way to collect all of them
    List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
    for (WebElement searchItem : searchItems) {
      String var = searchItem.getText();
      //if there is a text - print it
      if (!var.isEmpty()) {
        System.out.println(var);
        //verify that every search result contains java
        Assert.assertTrue(var.toLowerCase().contains("java"));
      }
    }
  }

  @Before
  public void setUp()  {
    //setup webdriver
    WebDriverManager.chromedriver().version("79").setup();
    driver = new ChromeDriver();
  }

  @After
  public void tearDown() {
    //close browser and destroy webdriver object
    driver.quit();
  }
}