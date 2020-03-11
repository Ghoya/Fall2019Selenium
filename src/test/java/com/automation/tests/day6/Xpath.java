package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Xpath {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome") ;
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        BrowserUtils.wait(2);
// value can be inside " or"
        // if you don't know the tag name or want to skip tag name use *
        // for example //*[@onclick='button()']    * means any tag name
        WebElement button1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/button[1]"));
// lock the element and right click then expand "copy" then click on the "copy xpath"
// to get Xpath
      button1.click();
        BrowserUtils.wait(3);
WebElement result=driver.findElement(By.id("result"));
        System.out.println(result.getText());

 //click on button 2
                                                  //tag[@attribute='value']
 WebElement button2=driver.findElement(By.xpath("//button[text()='Button 2']"));
 button2.click();
        System.out.println(result.getText());

        WebElement button3=driver.findElement(By.xpath("//button[starts-with(@id,'button_')]"));
        button3.click();
        System.out.println(result.getText());
                WebElement button4=driver.findElement(By.id("//button[contains(@id,'_button')][1]"));
        button4.click();
                        System.out.println(result.getText());
BrowserUtils.wait(3);
driver.close();
    }
}
