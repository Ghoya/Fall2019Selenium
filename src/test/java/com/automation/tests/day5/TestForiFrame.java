package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TestForiFrame {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("Chrome") ;
        driver.get("practice.cybertekschool.com/iframe");
BrowserUtils.wait(2);
driver.switchTo().frame("mceu_28");
WebElement textInput=driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());
driver.switchTo().defaultContent();
        BrowserUtils.wait(2);
driver.quit();
    }
}
