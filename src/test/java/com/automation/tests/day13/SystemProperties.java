package com.automation.tests.day13;

import org.testng.annotations.Test;

public class SystemProperties {
    @Test
    public void testName() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("os.name"));
        System.out.println(System.getProperty("user.name"));
      //  System.getProperty("user.dir")+"/pom.xml"
       // frexible path to downloads folder
      //  System.getProperty("user.home")+ "/Downloads"
     //    for windows we use \\ insted of /
     String pathToDownloads= System.getProperty("user.home")+ "/Downloads";
        System.out.println(System.getProperty("user.home"));
        System.out.println(pathToDownloads);
        System.out.println(System.getProperty("os.arch"));
    }

}
