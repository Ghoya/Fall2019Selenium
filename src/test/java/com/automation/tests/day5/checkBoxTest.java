package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class checkBoxTest {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome") ;
        driver.get("practice.cybertekschool.com/checkboxes");
        List<WebElement> checkBoxes=driver.findElements(By.tagName("input"));
       if(!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()) {
           System.out.println("Test Pasted");
       }else{
           System.out.println("Test Failed");
       }
        BrowserUtils.wait(3);
    //   checkBoxes.get(0).click();
      WebElement  checkbox1=checkBoxes.get(0);// to get first check box
      checkbox1.click();// click on it
      if (checkbox1.isSelected()){
          System.out.println("Test Passed");
          System.out.println("Checkbox1 is slected");}
      else {
          System.out.println("Test Failed");
          System.out.println("Checkbox1 is not slected");}

     driver.quit();
        }









    }

