package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main(String[] args) {
// to start selenium script we need:
        // setup webdriver( browser driver) and create web driver object
        WebDriverManager.chromedriver().setup();//
// ChromeDriver driver = new ChromeDriver();
     //   WebDriver is interface for Different drivers
 //       RemoteWebDriver  driver= new ChromeDriver();
        WebDriver driver= new ChromeDriver();// we will use Chrom
// in Selenium every thing began with WebDriver interface
        driver.get("http://google.com"); // to open a webside

    }
}
