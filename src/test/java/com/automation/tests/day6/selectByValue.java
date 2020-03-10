package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class selectByValue {
    public static void main(String[] args) {

        WebDriver driver= DriverFactory.createADriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        Select stateSelect=new Select(driver.findElement(By.id("state")));
        stateSelect.selectByIndex(9);
        stateSelect.selectByIndex(stateSelect.getOptions().size()-1);
        BrowserUtils.wait(2);
      stateSelect.selectByValue("DC");

        BrowserUtils.wait(2);
      String expected= "District of Colombia"  ;
        String actual=stateSelect.getFirstSelectedOption().getText();
        if(expected.equals(actual)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
       driver.close();
    }
}
