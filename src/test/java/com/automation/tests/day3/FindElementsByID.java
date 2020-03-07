package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FindElementsByID {
    public static void main(String[] args)throws Exception {
        WebDriver driver= DriverFactory.createADriver("chrome");
driver.get("http://practice.cybertekschool.com/login");
Thread.sleep(3000);
  //      WebElement username= driver.findElement(By.name("username"));
   //     username.sendKeys("tomsmith");
         driver.findElement(By.name("username")).sendKeys( "tomsmith" );
        Thread.sleep(3000);
//WebElement password=driver.findElement(By.name("password"));
  //      password.sendKeys("SuperSecretPassword");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
   //     WebElement login=driver.findElement(By.id("wooden_spoon"));
//login.click();
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);
   String expected=" You logged into a secure area! ";

   WebElement message=driver.findElement(By.id("flash"));
   String    actual=message.getText();
        System.out.println(actual);
   if(actual.equals(expected)){
       System.out.println("Test Passed");
   }else {
       System.out.println("Test Failed");

   }


//driver.quit();
    }
}
