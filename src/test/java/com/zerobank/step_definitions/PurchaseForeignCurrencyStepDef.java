package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDef {

    PayBillsPage payBillsPage = new PayBillsPage();
    Select selectCurrency;

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        selectCurrency = new Select(payBillsPage.selectCurrency);

        List<String> currenciesList = BrowserUtils.getStringListFromWebElementList(selectCurrency.getOptions());

        Assert.assertTrue(currenciesList.containsAll(dataTable));

    }


    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.inputAmount.sendKeys("1000");
        payBillsPage.radioBtnDollar.click();
        payBillsPage.btnCalculateCosts.click();
    }


    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {


        BrowserUtils.waitUntilAlertIsPresent(5);
        Alert alert = Driver.getDriver().switchTo().alert();
        Assert.assertTrue(alert.getText().equalsIgnoreCase("Please, ensure that you have filled all the required fields with valid values."));
        alert.accept();


    }


    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        selectCurrency = new Select(payBillsPage.selectCurrency);
        Select selectCurrency = new Select(payBillsPage.selectCurrency);
        selectCurrency.selectByIndex(1);
        payBillsPage.radioBtnDollar.click();
        payBillsPage.btnCalculateCosts.click();

    }


}
