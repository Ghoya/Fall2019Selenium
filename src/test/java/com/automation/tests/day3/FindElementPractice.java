package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementPractice {
    public static void main(String[] args)throws Exception{
  //      WebDriverManager.chromedriver().setup();
  //      WebDriver driver= new ChromeDriver();
WebDriver driver= DriverFactory.createADriver("chrome");
driver.get("http://practice.cybertekschool.com/sign_up");
Thread.sleep(3000);
WebElement fullName=driver.findElement(By.name("full_name"));
fullName.sendKeys("Ghoya Memet");
        Thread.sleep(3000);
WebElement email=driver.findElement(By.name("email"));
email.sendKeys("sdet@cybertek.com");
        Thread.sleep(3000);

WebElement signUp=driver.findElement(By.name("wooden_spoon"));
// when you see type = "submit" you can use submit() instead of click()
// it make sense to use when click() method doesn't work
//signUp.submit();
signUp.click();
        Thread.sleep(3000);
   String expected ="Thank you for signing up. Click the button below to return to the home page.";
//WebElement message=driver.findElement(By.className("subheader"));
        WebElement message=driver.findElement(By.tagName("h3"));
String actual= message.getText();
        System.out.println(actual);
   if(actual.equals(expected)){
       System.out.println("Test Passed"); }
   else{
       System.out.println("Test Failed");
   }
// getText()--returns visable text--->anything between opening and
// closing tags is visable text
      driver.quit();
    }
}
