package com.automation.tests.day7;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CssSelector {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(3);
   WebElement heading = driver.findElement(By.cssSelector(".h3"));
        WebElement home = driver.findElement(By.cssSelector(".nav_link"));
        WebElement button1 = driver.findElement(By.cssSelector("[onclick='button1()']"));
        WebElement button2 = driver.findElement(By.cssSelector("[name='button2()']"));
         WebElement button3 = driver.findElement(By.cssSelector("[onclick='button']"));
                WebElement button4 = driver.findElement(By.cssSelector("[onclick='button']"));
BrowserUtils.wait(2);
button1.click();
        button2.click();
        button3.click();
        button4.click();


driver.close();
    }
}
