package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {
    public static void main(String[] args) {
        // we need to do two thing
        // 1. set up chromedriver
        //2. create chromedriver object
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver= new ChromeDriver();
        // open some webside
        driver.get("http://google.com");

    }
}
