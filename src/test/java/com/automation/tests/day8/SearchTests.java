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
        //is some of the search results
        //doesn't contain java word, it will fail the test
        Assert.assertTrue(var.toLowerCase().contains("java"));
        System.out.println(var.toLowerCase());
        System.out.println();
      }
    }
  }
  /**
   * Given user is on the amazon.com page
   * When user enters "java" as a search item
   * Then user clicks on the search button
   * And user clicks on the first search item
   * And user verifies that title of the search item contains "Java"
   */
  @Test  //(description="search for Java book on amazon")
  public void amazonSearchTest() {
    driver.get("https://www.amazon.com");
    //there is a chance that item is not visible
    //so we need to maximize window before clicking on it
    driver.manage().window().maximize();
BrowserUtils.wait(5);

driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java",Keys.ENTER);
    BrowserUtils.wait(5);
    //find all links inside h2 elements, because h2 element is no clickable itself
List<WebElement> searchItems=driver.findElements(By.xpath("//h2//a"));

//click on the first item
//for(WebElement searchItem:searchItems){
// System.out.println(searchItem.getText());
 //  }
searchItems.get(0).click();
    BrowserUtils.wait(3);

WebElement productTitle=driver.findElement(By.id("title"));
String productTitleString=productTitle.getText();
    System.out.println(productTitleString);
    Assert.assertTrue(productTitleString.contains("Java"));
    //so h2 elements are not clickable, even though they contain links
    //that's why, instead of collection all h2 elements
    //we collected all hyperlinks
    //every hyperlink represent some search item
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