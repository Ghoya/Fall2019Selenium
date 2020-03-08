package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.*;
public class selectByText {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
       driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(2);
        WebElement SimpleDropDown=driver.findElement(By.id("dropdown"));
      Select selectSimpleDropDown=new Select(SimpleDropDown);
  selectSimpleDropDown.selectByVisibleText("Option 2");
        BrowserUtils.wait(3);
        selectSimpleDropDown.selectByVisibleText("Option 1");
        BrowserUtils.wait(3);

Select selectYear=new Select(driver.findElement(By.id("year")));
        Select selectMonth=new Select(driver.findElement(By.id("month")));
        Select selectDay=new Select(driver.findElement(By.id("day")));
        BrowserUtils.wait(2);
selectDay.selectByVisibleText("28");
        BrowserUtils.wait(3);
        selectMonth.selectByVisibleText("February");
        BrowserUtils.wait(2);
        selectYear.selectByVisibleText("2003");
        BrowserUtils.wait(2);
 List<WebElement> months  = selectMonth.getOptions();
        for (WebElement month:months) {
            String monthName=month.getText();
            selectMonth.selectByVisibleText(monthName);
        }
 Select stateSelect=new Select(driver.findElement(By.id("state")));
   stateSelect.selectByVisibleText("District of Columbia");
   String selected=stateSelect.getFirstSelectedOption().getText();
   if(selected.equals("District of Columbia")){
       System.out.println("Test Passed");
   }else{
       System.out.println("Test Failed");
   }

 List<WebElement> states=stateSelect.getOptions();
        for (WebElement state:states) {
            System.out.println(state.getText());
        }

        BrowserUtils.wait(2);
        driver.quit();
    }
}
