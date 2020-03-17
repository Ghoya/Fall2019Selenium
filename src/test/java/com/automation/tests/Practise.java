package com.automation.tests;


import org.testng.Assert;
import org.testng.annotations.Test;

public class Practise {
  @Test
  public void test1(){
      String expected="imam";
      String actual= "imam";
      Assert.assertEquals(actual,expected);
  }
  @Test
public void test2(){
      int num1=4;
      int num2=30;
      Assert.assertTrue(num1>num2);
}

}
