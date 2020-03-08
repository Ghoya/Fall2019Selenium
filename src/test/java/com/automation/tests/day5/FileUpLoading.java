package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FileUpLoading {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/upload");
        BrowserUtils.wait(3);
        WebElement upload=driver.findElement(By.id("file-upload"));
        String filePath=System.getProperty("user.dir")+"/pom.xml";
String file2Path=System.getProperty("");



      driver.quit();



    }
}
