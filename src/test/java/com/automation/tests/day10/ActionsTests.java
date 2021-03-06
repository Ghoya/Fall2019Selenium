package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTests {
    private WebDriver driver;
    private Actions actions;


    @Test
    public void hoverOnImage() {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));
        //build() is needed when you have couple of actions
        //always end with perform()
        // pause(1000). - like Thread.sleep(1000)
        actions.moveToElement(img1).
                pause(1000).
                moveToElement(img2).
                pause(1000).
                moveToElement(img3).
                build().perform();

        BrowserUtils.wait(3);
        //hover on the first image
        //verify that "name: user1" is displayed
        //hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webelement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        //move to the second image
        BrowserUtils.wait(2);

        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());

    }

    @Test
    public void jqueryMenuTest(){
        //TASK UNTIL 8:20
        driver.get("http://practice.cybertekschool.com/jqueryui/menu#");
        BrowserUtils.wait(7);
        //hover on "enabled"
        //hover on "downloads"
        //click on PDF
WebElement enabled=driver.findElement(By.id("ui-id-3"));
WebElement download=driver.findElement(By.id("ui-id-4"));
WebElement pdf=driver.findElement(By.id("ui-id-5"));

actions.moveToElement(enabled).pause(1000).
        moveToElement(download).pause(1000).
        moveToElement(pdf).pause(1000).click().build().perform();
    }

    @Test
    public void DragAndDropsTest() {
driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
     BrowserUtils.wait(5);
   driver.findElement(By.xpath("//button[text()='Accept Cookies']")).click();
        BrowserUtils.wait(5);
   WebElement eath=driver.findElement(By.id("droptarget"));
        WebElement moon=driver.findElement(By.id("draggable"));
actions.dragAndDrop(moon,eath).perform();
String expected="You did great!";
String actual=eath.getText();
Assert.assertEquals(expected,actual);
    }

    @BeforeMethod
    public void setUp() {
        driver = DriverFactory.createADriver("chrome");
        actions = new Actions(driver);
    }

    @AfterMethod
    public void tearDown() {
   BrowserUtils.wait(2);
driver.quit();
    }


}
