package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/";
    private By userNameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");
    private String username = "storemanager85";
    private String password = "UserUser123";
    private  By fleetBy=By.xpath("//*[@id=\"main-menu\"]/ul/li[2]/a/span");
  private By subTitle=By.className("oro-subtitle");
  private By pageNumberBy= By.cssSelector("input[type='number']");
    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().version("79").setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @Test
    public void verifyPageNumber() {
       String expected="1";
       String actual=driver.findElement(pageNumberBy).getAttribute("value");

    }

    @Test
    public void verifyPageSubTitle() {
   driver.findElement(userNameBy).sendKeys(username);
    driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(5);

     driver.findElement(By.className("title title-level-1")).click();
        BrowserUtils.wait(5);

     driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(5);
        WebElement subTitleElement=  driver.findElement(subTitle);


    }

    @AfterMethod
    public void tearDown() {

    }
}
/*
    @Test(description = "verify you can list all cars in fleet")
    public void fleetTask(){
        BrowserUtils.wait(2);
        driver.findElement(userNameBy).sendKeys(storeManager);  //truck driver login
        driver.findElement(passwordBy).sendKeys(storeManagerPassword);
        driver.findElement(loginBy).click();
        BrowserUtils.wait(2);
        String userNameText=driver.findElement(logOnUserName).getText().trim();
        System.out.println("userNameText = " + userNameText);
        assertEquals(userNameText, "Lorenzo Weissnat");
        driver.findElement(fleetMenu).click();
        driver.findElement(vehiclesLink).click();
        BrowserUtils.wait(2);
        assertTrue(driver.findElement(carsHeader).isDisplayed());
  */