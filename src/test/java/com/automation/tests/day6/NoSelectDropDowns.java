package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;
public class NoSelectDropDowns {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
driver.findElement(By.id("dropdownMenuLink")).click();
        BrowserUtils.wait(2);
        driver.findElements(By.linkText("https://www.google.com/"));
        driver.findElements(By.linkText("Google"));
        BrowserUtils.wait(2);
        driver.findElements(By.linkText("Etsy"));
    List<WebElement>  allLiks=driver.findElements(By.className("dropdown-item"));

        for (WebElement Link:allLiks) {
            System.out.println(Link.getText()+ " : "+Link.getAttribute("href"));
        }


     driver.close();



    }
}
