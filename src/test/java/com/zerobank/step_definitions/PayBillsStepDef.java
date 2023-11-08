package com.zerobank.step_definitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.Map;

public class PayBillsStepDef {

    PayBillsPage payBillsPage = new PayBillsPage();


    @Given("the user clicks {string} link")
    public void the_user_clicks_link(String linkText) {
        payBillsPage.clickLinkFromWebElementList(linkText);

    }


    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String, String> table) {

        for (int i = 0; i < payBillsPage.labelsTabNewPayee.size(); i++) {
            String eachValue = table.get(payBillsPage.labelsTabNewPayee.get(i).getText());
            payBillsPage.inputBoxesTabNewPayee.get(i).sendKeys(eachValue);
        }

        payBillsPage.btnAddTabNewPayee.click();

    }


    @Then("message {string} should be displayed")
    public void message_should_be_displayed(String expectedError) {
        BrowserUtils.waitForVisibility(payBillsPage.alertContent, 5);
        Assert.assertEquals(expectedError, payBillsPage.alertContent.getText());
    }


}
