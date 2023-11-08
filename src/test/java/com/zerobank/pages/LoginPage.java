package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage {


    String expectedErrMsg ="Login and/or password are wrong.";

    public LoginPage(){

        PageFactory.initElements(Driver.getDriver(),this);

    }


    @FindBy(id = "user_login")
    public WebElement inputUserName;


    @FindBy(id = "user_password")
    public WebElement inputPassword;


    @FindBy(css = "input[type='submit']")
    public WebElement buttonSingIn;



    @FindBy(css = ".alert.alert-error")
    public WebElement errMsg;



    public void login(){
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
        inputUserName.sendKeys(ConfigurationReader.getProperty("userName"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("password"));
        buttonSingIn.click();

        Driver.getDriver().navigate().back();



    }

    public void login(String userName,String password){
        inputUserName.sendKeys(userName);
        inputPassword.sendKeys(password);
        buttonSingIn.click();
        Driver.getDriver().navigate().back();

    }





}
