package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(2);
        List<WebElement> buttons=driver.findElements(By.tagName("button"));
buttons.get(0).click();// to click on the first button
BrowserUtils.wait(3);
// to get the text from popup message
String popupText=driver.switchTo().alert().getText();
        System.out.println(popupText);
driver.switchTo().alert().accept();// to click ok
String expected="You successfuly clicked an alert";
String actual=driver.findElement(By.id("result")).getText();
if(expected.equals(actual)){
    System.out.println("Test Passed");
}else {
    System.out.println("Test Failed");
    System.out.println("Expected = " + expected);
    System.out.println("Accual = " + actual);
}
        System.out.println("***********************************");

buttons.get(1).click();// to click second button
BrowserUtils.wait(2);
// to click cancel

driver.switchTo().alert().dismiss();// result must be: you clicked: Cancel
        BrowserUtils.wait(3);
String expected2 ="You clicked: Ok";
String actual2=driver.findElement(By.id("result")).getText();
if(expected2.equals(actual2)){
    System.out.println("Test Passed");
}else {
    System.out.println("Test Failed");
    System.out.println("Expected = " + expected2);
    System.out.println("Accual = " + actual2);
}
        BrowserUtils.wait(2);
        System.out.println("***************************");
// Task: click on button 3
        // enter some text :Hello World
        //
    //    Verify that result text ind with Hello World!
   buttons.get(2).click();;
   BrowserUtils.wait(2);
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("Hello World!");
        BrowserUtils.wait(2);
alert.accept();// click ok
   String expected3= "Hello World!";
String actual3=driver.findElement(By.id("result")).getText();
if(actual3.equals(expected3)){
    System.out.println("Test Passed");
}else {
    System.out.println("Test Failed");
    System.out.println("Expected = " + expected3);
    System.out.println("Accual = " + actual3);
}

driver.close();
    }
}
