package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
    public static void main(String[] args) throws Exception{
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("http://google.com");
Thread.sleep(3000);
// By.name("q") -->name is one of the selenium locators
        // there are 8 lacators and we use lacators to find elements
      // to choose locator we use By.locator
        WebElement search= driver.findElement(By.name("q"));
        //once we found an element how to enter text?
        // to enter text use sendKeys() method
        // how to press enter after entering the text?
        // use Key.ENTER---perform keyboard click
        //keysToSend---name of the parameter, we don't specify it
       search.sendKeys("ghoya", Keys.ENTER);
        Thread.sleep(4000);
       // if see <a> element , it calls  link
        // visible text of this link, can be used by selenium to find this element
      WebElement news=driver.findElement(By.linkText("News"));
news.click();
        Thread.sleep(4000);
driver.quit();// to click on the element


    }
}
