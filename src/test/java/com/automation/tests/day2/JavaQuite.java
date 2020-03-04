package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
public class JavaQuite {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
driver.get("http://practice.cybertekschool.com/new_tab ");
Thread.sleep(4000);
//driver.close();// thil command will close the one window th test automation opened up
  driver.quit();//  this command will close all the windows that  the test command opened up
    }
}
