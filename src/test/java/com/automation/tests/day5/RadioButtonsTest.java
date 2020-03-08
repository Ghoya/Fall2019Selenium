package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RadioButtonsTest {
    public static void main(String[] args) {
        WebDriver driver= DriverFactory.createADriver("chrome");
driver.get("http://practice.cybertekschool.com/radio_buttons");
        BrowserUtils.wait(3);
        WebElement blackButton=driver.findElement(By.id("black"));
blackButton.click();
if(blackButton.isEnabled()) {
    System.out.println("BLACK BUTTON IS ENABLED ");
}else {
    System.out.println("BLACK BUTTON IS FAID TO ENABLED ");
}

// how do we verify that buton clicked
        // returns true if button clicked

   /*    boolean visible = blackButton.isDisplayed();
        boolean enabled = blackButton.isEnabled();
        if (enabled && visible){
            blackButton.click();
        }
        System.out.println("enabled + visible = " + enabled+" , "+visible);
  */
//driver.findElements(By.someThing(" some thing")).size()==0;
        if (blackButton.isSelected()){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        BrowserUtils.wait(3);

driver.quit();
    }
}
