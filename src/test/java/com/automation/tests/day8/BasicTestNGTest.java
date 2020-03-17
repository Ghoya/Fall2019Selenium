package com.automation.tests.day8;
import org.testng.Assert;
import  org.testng.annotations.*;
public class BasicTestNGTest {
 // runs only once in the class before @beforeClass and @beforeMethod
  @BeforeTest
public void beforeTest(){
      System.out.println("BEFORE TEST");
}
    // runs only once in the class after @beforeClass and @beforeMethod
    @AfterTest
    public void afterTest(){
        System.out.println("AFTER TEST");
    }
   // some thing that should be done once only in the class before all test
    // regardless on number of tests it runs only once
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    // some thing that should be done once only in the class after all test
    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS");
    }

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
