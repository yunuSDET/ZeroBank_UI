package com.zerobank.step_definitions;

import com.zerobank.pages.*;
import com.zerobank.utilities.Driver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class AccountActivityStepDef {



    LoginPage loginPage=new LoginPage();



    AccountActivityPage accountActivityPage=new AccountActivityPage();



    @Given("the user is logged in")
    public void the_user_is_logged_in() {

     loginPage.login();

    }


    @Then("the Account Activity page should be displayed")
    public void the_account_activity_page_should_be_displayed() {
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Account Activity"));
    }

    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String option) {

        Select select=new Select(accountActivityPage.selectAccount);
        Assert.assertTrue(select.getFirstSelectedOption().getText().equalsIgnoreCase(option));
    }





}
