package com.automation.tests.Practices;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RegistrationForm {
  private String URL="http://practice.cybertekschool.com/registration_form";
private WebDriver driver;
//private String firstNameLocator="firstname";
private By firstNameBy=By.name("firstname");
private By lastNameBy=By.name("lastname");
    private By userNameBy=By.name("username");
    private By emailBy=By.name("email");
    private By passwordBy=By.name("password");
    private By PhoneNumberBy=By.name("phone");
    private By genderBy=By.className("col-sm-3 control-label");
    //gender
private By maleBy=By.cssSelector("input[value='male']");
    private By femaleBy=By.cssSelector("input[value='female']");
    private By otherBy=By.cssSelector("input[value='other']");

    private By birthdayBy=By.name("birthday");
    private By departmentBy=By.name("department");
    private By jobTitleBy=By.name("job_title");
    //language
//private By cPlussPluss=By.xpath("//*[@id=\"registrationForm\"]/div[11]/div/div[1]/label");
private By cPlussPlussBy=By.xpath("//label[text()='C++']/preceding-sibling::input");
private By javaBy=By.xpath("//label[text()='Java']/preceding-sibling::input");
    private By javaScriptBy=By.xpath("//label[text()='JavaScript']/preceding-sibling::input");
// signUpButton
 private By signInBY =By.id("wooden_spoon");
    @Test
    public void test1() {
driver.findElement(firstNameBy).sendKeys("ghoya");
        BrowserUtils.wait(1);
        driver.findElement(lastNameBy).sendKeys("Imam");
        driver.findElement(userNameBy).sendKeys("goyaUses");
        driver.findElement(emailBy).sendKeys("ghoya@gmail.com");
        BrowserUtils.wait(1);
        driver.findElement(passwordBy).sendKeys("ghoya123");
        driver.findElement(PhoneNumberBy).sendKeys("604-121-1833");
        driver.findElement(maleBy).click();

        driver.findElement(birthdayBy).sendKeys("01/07/1969");
        Select  departmentSelect=new Select(driver.findElement(departmentBy));
        departmentSelect.selectByVisibleText("Department of Agriculture");

        Select jobTitleSelect=new Select(driver.findElement(jobTitleBy));
        jobTitleSelect.selectByVisibleText("Manager");

        driver.findElement(javaBy).click();
        driver.findElement(signInBY).click();

       String expected="You've successfully completed registration!";
       String actual=driver.findElement(By.tagName("p")).getText();
        Assert.assertEquals(actual,expected);
        BrowserUtils.wait(5);
    }

    @Test
    public void verifyFirstNameLengthTest() {
      driver.findElement(firstNameBy).sendKeys("a");
        BrowserUtils.wait(5);
        WebElement warningMessage=driver.findElement(By.xpath("//small[text()='first name must be more than 2 and less than 64 characters long']"));
Assert.assertTrue(warningMessage.isDisplayed());

    }

    @Test
    public void verifyAlphabeticLettersOnlyTest() {
        driver.findElement(firstNameBy).sendKeys("123");
       BrowserUtils.wait(4);
      WebElement warningMessage =driver.findElement(By.xpath("// small[text()='first name can only consist of alphabetical letters']"));
      Assert.assertTrue(warningMessage.isDisplayed());

    }

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79").setup();
       driver=new ChromeDriver();
        driver.get(URL);
        BrowserUtils.wait(5);
       driver.manage().window().maximize();
        BrowserUtils.wait(2);
    }

    @AfterMethod
    public void tearDown() {
       driver.quit();
    }
}
