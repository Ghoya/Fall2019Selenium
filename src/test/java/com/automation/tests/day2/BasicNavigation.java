package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasicNavigation {
    public static void main (String[] args)throws Exception {
// to start selenium script we need:
        // setup webdriver( browser driver) and create web driver object
        WebDriverManager.chromedriver().setup();//
// ChromeDriver driver = new ChromeDriver();
        //   WebDriver is interface for Different drivers
        //       RemoteWebDriver  driver= new ChromeDriver();
        WebDriver driver = new ChromeDriver();// we will use Chrom
// in Selenium every thing began with WebDriver interface
        driver.get("http://google.com"); // to open a webside
        Thread.sleep(3000);// for demo , waite 3 seconds
        // method that return page title
        // you can also see it as tab name , in the browser
        String title = driver.getTitle(); // returns title
        String expectedTitle = "Google";
        System.out.println("Google title is..... = " + title);
        if (expectedTitle.equals(title)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            driver.close();// to close browser
        }
            // browser cann't close it self
        }
    }
