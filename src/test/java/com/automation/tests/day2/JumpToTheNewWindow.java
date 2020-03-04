package com.automation.tests.day2;
import java.util.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JumpToTheNewWindow {
    public static void main(String[] args)throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
driver.get("http://practice.cybertekschool.com/new_tab ");
  Thread.sleep(4000);
// every window has some id calls window handle
  // based on window handle we can switch in between windows
  String windowHandle= driver.getWindowHandle();// open current window
        System.out.println("windowHandle ="+windowHandle);
     // getWindowHandles returns id of all currently opened windows
        //  Set dosn't allow duplicates
Set<String> windowHandles=driver.getWindowHandles();
        System.out.println("windowHandles = " +windowHandles);
        System.out.println("Before Switch"+ driver.getCurrentUrl());
  // since we have all the windows and we know id of original window
  // we can say  switch to something that is not equals to old window id
        for (String windowID:windowHandles) {
      //     if it is not an old window switch then switch
          if(!windowID.equals(windowHandle)) {
         //     to jump to the new window
              driver.switchTo().window(windowID);
          }
        }
        System.out.println("After Switch : " + driver.getCurrentUrl());
        driver.close();
    }
    // This method helps to switch in between windows based on page title
  public static void switchToWindowBasedOnTitle(String pageTitle, WebDriver driver){
        Set<String> windows = driver.getWindowHandles();
        for(String window: windows){
            driver.switchTo().window(window);
            if (driver.getTitle().equals(pageTitle)){
                break;
            }
        }
  }

}
