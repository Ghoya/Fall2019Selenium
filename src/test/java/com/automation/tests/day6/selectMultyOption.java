package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class selectMultyOption {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);

      Select languagesSelect=new Select(driver.findElement(By.name("Languages")));
     boolean isMultiple=languagesSelect.isMultiple();
        System.out.println(isMultiple);
        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        List<WebElement> selectedLanguages=languagesSelect.getAllSelectedOptions();
        for (WebElement Language:selectedLanguages) {
            System.out.println(Language.getText());
        }
        BrowserUtils.wait(2);
languagesSelect.deselectByVisibleText("Java");
        BrowserUtils.wait(2);
languagesSelect.deselectAll();

        BrowserUtils.wait(2);
       driver.close();
    }
}
