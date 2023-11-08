package com.zerobank.step_definitions;

import com.zerobank.pages.HomePage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginStepDefinitions {

    LoginPage loginPage=new LoginPage();
    HomePage homePage=new HomePage();

    String userName=ConfigurationReader.getProperty("userName");
    String password=ConfigurationReader.getProperty("password");


    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("loginPage"));
    }
    @When("user enters valid credentials")
    public void user_enters_valid_credentials() {
        loginPage.inputUserName.sendKeys(userName);
        loginPage.inputPassword.sendKeys(password);

    }
    @When("user clicks sing in button")
    public void user_clicks_sing_in_button() {
        loginPage.buttonSingIn.click();
    }
    @Then("user should be logged in")
    public void user_should_be_logged_in() {
        Driver.getDriver().navigate().back(); //used for skip ERR_SSL_VERSION_OR_CIPHER_MISMATCH
        BrowserUtils.waitForVisibility(homePage.userDropDown,5);
        Assert.assertTrue(homePage.userDropDown.getText().contains(userName));



    }


    @When("user enters {string} as username and {string} as password")
    public void user_enters_as_username_and_as_password(String userName, String password) {
        loginPage.inputUserName.sendKeys(userName);
        loginPage.inputPassword.sendKeys(password);

    }
    @Then("user should see error message {string}")
    public void user_should_see_error_message(String errMsg) {
        Assert.assertTrue(loginPage.errMsg.getText().contains(errMsg));
    }





}
