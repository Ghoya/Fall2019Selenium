package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Xpath {
public static String userNameLocator="//lable[text()='Username']/following-sibling::input";
  public  static String passwordLocator="//lable[text()='Password']/following-sibling::input";
  public  static String loginButton="//button[contains(text(),'Login')]";
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
            driver.get("http://practice.cybertekschool.com/login");
        BrowserUtils.wait(3);
        driver.findElements(By.xpath(userNameLocator));
driver.findElements(By.xpath(passwordLocator));
        driver.findElements(By.xpath(loginButton));
        BrowserUtils.wait(3);
driver.close();
    }
}
