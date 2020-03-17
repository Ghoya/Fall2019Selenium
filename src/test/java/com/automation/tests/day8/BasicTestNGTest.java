package com.automation.tests.day8;
import org.testng.Assert;
import  org.testng.annotations.*;
public class BasicTestNGTest {
 // runs only once in the class before @beforeClass and @beforeMethod
    // runs before every test automatically
  // works as a pre-condition or setup
    @BeforeMethod
   public void setup(){
        System.out.println("Before method");
   }
    // runs after every test automatically
  @AfterMethod
   public void teardown(){
       System.out.println("After method");
   }
    @Test
  public void test1(){
      System.out.println("Test1");
      String expected="apple";
      String actual="apple";
      Assert.assertEquals(actual,expected);
  }
    @Test
public   void test2(){
    System.out.println("Test2");
      int num1=5;
      int num2=10;
      // it calls hard assertion
    // if assertion fails - it stops the execution(due to exception).
      Assert.assertTrue(num1<num2);
}





}
