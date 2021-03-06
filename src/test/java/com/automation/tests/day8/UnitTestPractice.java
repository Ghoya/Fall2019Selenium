package com.automation.tests.day8;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTestPractice {
    public static void main(String[] args) {
  // unit test
  // to check if our method works properly
  // if assertion fails that means our method doesn't work correctly
  // that means we have to fix the method
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
       // Assertion
      verifyEquals(expected,actual) ;
    }
  // annotation
  //description - is not working for unit , make sure that you use testng
 @Test(description ="verify two Strings equilization")
public void test1(){
   String expected= "elpp";
   String actual=reverseString("apple");
   // it is coming from testng , junit also has this class
      // you can compare any data types here: strings , primitives arrays, objects
      // to verify if expected result is equals to actual
     Assert.assertEquals(expected,actual);
    }
   @ Test(description = "test if the method can reverse any String ")
    public void test2(){
    String expected="rac";
        String actual=reverseString("car");
        Assert.assertEquals(expected,actual);
    }



 public static boolean verifyEquals(String expected, String actual) {
     if (expected.equals(actual)) {
         System.out.println("Test Passed");
         return true;
     } else {
         System.out.println("Test Failed");
         System.out.println("Expected= " + expected);
         System.out.println("Actual= " + actual);
         return false;
     }
 }

 public static String reverseString(String str){
        String reversed="";
     for (int i = str.length()-1; i >=0 ; i--) {
      reversed+=str.charAt(i) ;
     }
    return reversed;
 }

}
