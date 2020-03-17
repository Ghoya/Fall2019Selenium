package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
/**
 * Create a class called PracticeTests
 ** - setup before/after methods
 *     - in before method - instantiate webdriver and navigate to: http://practice.cybertekschool.com/
 *     - in after method - just close webdriver.
 ** - create a test called loginTest
 *     - go to "Form Authentication" page
 *     - enter valid credentials
 *        username: tomsmith
 *        password: SuperSecretPassword
 **     - verify that following sub-header message is displayed: "Welcome to the Secure Area. When you are done click logout below."
 */
public class PracticeTests {
    private WebDriver driver;
// we put @Test annotation to make methods executable as tests
 /*   @Test//create a test called loginTest
    public void logInTest() {
        //go to "Form Authentication" page
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);
     driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);
        BrowserUtils.wait(3);
  String expected="Welcome to the Secure Area. When you are done click logout below.";
String actual=driver.findElement(By.className("subheader")).getText();
        //if assertion fails - it will throw exception and message will be printed
        //3 parameters: (expected, actual, "message in case of error")
        Assert.assertEquals(actual,expected,"Sub-header message is not matching ");

    }

    @Test
    public void forgotPasswordTest() {
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(3);
driver.findElement(By.className("email")).sendKeys("cybertek@gmail.com",Keys.ENTER);
        BrowserUtils.wait(3);
    String actual=driver.findElement(By.name("confirmation_message")).getText();

    }

    @Test
    public void CheckBoxesTest () {
     driver.findElement(By.linkText("Checkboxes")).click();;
        BrowserUtils.wait(3);
   //     List<WebElement> checkBoxes= driver.findElement(By.tagName("input"));
        BrowserUtils.wait(3);
   ///     checkBoxes.get(0).click();
  //      Assert.assertTrue(checkBoxes.get(0).isSelected(),"checkbox 1 is not slected");

    }

    @Before
    public void setUp()  {

        WebDriver driver= DriverFactory.createADriver("chrome");
//INTERVIEW QUESTION: HOW TO HANDLE SSL ISSUES IN SELENIUM?
        //ChromeOptions - use to customize browser for tests
        ChromeOptions chromeOptions=new ChromeOptions();
        //to ignore "Your connection is not private issue"
        chromeOptions.setAcceptInsecureCerts(true);
        //provide chromeOptions object into chromedriver constructor
        driver=new ChromeDriver(chromeOptions);
        driver.get("http://practice.cybertekschool.com/");
       driver.manage().window().maximize();;
    }


    @After
    public void tearDown() {
        driver.close();
    }

    public static void main(String[] args) {


    }
*/
}