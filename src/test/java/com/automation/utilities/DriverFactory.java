package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {
   // this method return webDriver object on browser type
   // if you want to use chrome browser , just to provide chrome as a parameter
// return webDriver object
    public static WebDriver createADriver(String browserName) {

      if(browserName.equalsIgnoreCase("chrome")){
          WebDriverManager.chromedriver().setup();
          return new ChromeDriver();
      }else {
         WebDriverManager.firefoxdriver().setup();
         return new FirefoxDriver();
      }
  }

}
