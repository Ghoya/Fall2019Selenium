package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
       driver.get("http://practice.cybertekschool.com/radio_buttons");
driver.manage().window().maximize();
        BrowserUtils.wait(2);
     //<input type="radio">
        List<WebElement> radioButtons=driver.findElements(By.tagName("input"));

        for (WebElement radioButton:radioButtons) {
            // to chech if button is clickable
             // <input type="radio" id="blue" name="color"
            String id = radioButton.getAttribute("id");
            // if buttoon is eligible to click
            // returns true of you can click in the button
            if (radioButton.isEnabled()) {
                radioButton.click();
                System.out.println("Clicked on : " + radioButton.getAttribute("id"));
                BrowserUtils.wait(1);
            }else{
                System.out.println("Button is dinabled , not clicked : "+ id);
            }

        }
driver.quit();
    }

}
