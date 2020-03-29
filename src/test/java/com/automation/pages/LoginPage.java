package com.automation.pages;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
   @FindBy(id="prependedInput")
public WebElement userName;
  @FindBy(id="prependedInput2")
public WebElement password;
@FindBy(id="_submit")
public WebElement login;
@FindBy(linkText = "Forgot your password?")
public WebElement forgotPassword;
@FindBy(css="[class='alert alert-error']")
private WebElement warningMessage;
    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

public void login(String userNameValue, String passwordValue){
   userName.sendKeys(userNameValue);
password.sendKeys(passwordValue);
    }
public void login(){
    userName.sendKeys(ConfigurationReader.getProperty("store_manager"));
password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
    }


}
