package com.automation.tests.day8;
import org.testng.*;
import sun.jvm.hotspot.utilities.Assert;
import  org.testng.annotations.*;
public class BasicTestNGTest {
 // runs anly once in the class before @beforemethod and before test


  // runs before every test automatically
  // works as a pre-condition or setup



  public void test1(){
      System.out.println("Test1");
      String expected="apple";
      String actual="apple";
      Assert.assertEquals(actual,expected);
  }
public   void test2(){
    System.out.println("Test2");
      int num1=5;
      int num2=10;
      // it calls hard assertion
    // if assertion fails - it stops the execution(due to exception).
      Assert.assertTrue(num1>num2);
}





}
