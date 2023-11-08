package com.zerobank.step_definitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.HomePage;
import com.zerobank.pages.OnlineBankingPage;
import com.zerobank.utilities.BrowserUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FindTransActionsStepDef {

    HomePage homePage=new HomePage();
    OnlineBankingPage onlineBankingPage=new OnlineBankingPage();

    AccountActivityPage accountActivityPage=new AccountActivityPage();

    LocalDate fromDate;
    LocalDate toDate;
    DateTimeFormatter dateFormat=DateTimeFormatter.ofPattern("yyyy-MM-dd");






    @Given("the user accesses the Find Transactions tab")
    public void the_user_accesses_the_find_transactions_tab() {
        accountActivityPage.linkFindTransactions.click();
        Assert.assertTrue(accountActivityPage.headerUnderFindTransactions.isDisplayed());

    }
    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String fromDate, String toDate) {

       this.fromDate= BrowserUtils.getDateFromString(fromDate,dateFormat);
       this.toDate=BrowserUtils.getDateFromString(toDate,dateFormat);

        accountActivityPage.inputFromDate.clear();
        accountActivityPage.inputToDate.clear();

        accountActivityPage.inputFromDate.sendKeys(fromDate);
        accountActivityPage.inputToDate.sendKeys(toDate);

    }
    @When("clicks search")
    public void clicks_search() {
        accountActivityPage.btnFind.click();
        BrowserUtils.sleep(1);
    }
    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String fromDate, String toDate) {
        LocalDate expectedFromDate=BrowserUtils.getDateFromString(fromDate,dateFormat);
        LocalDate expectedToDate=BrowserUtils.getDateFromString(toDate,dateFormat);



        for (WebElement eachDateString : accountActivityPage.listedDates) {
            LocalDate eachDate=BrowserUtils.getDateFromString(eachDateString.getText(),dateFormat);



            Assert.assertFalse(eachDate.isBefore(expectedFromDate) || eachDate.isAfter(expectedToDate) );
        }
    }
    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {

        List<LocalDate> datesActual=new ArrayList<>();
        List<LocalDate> datesSorted=new ArrayList<>();

        for (WebElement eachDate : accountActivityPage.listedDates) {

            datesActual.add(BrowserUtils.getDateFromString(eachDate.getText(),dateFormat));
            datesSorted.add(BrowserUtils.getDateFromString(eachDate.getText(),dateFormat));
        }
        Collections.sort(datesSorted,Collections.reverseOrder());
        Assert.assertEquals(datesSorted,datesActual);


    }
    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {

        boolean test=false;
        for (WebElement eachDate : accountActivityPage.listedDates) {
            if(eachDate.getText().equalsIgnoreCase(string)) {
                test=true;
                break;
            }
        }
        Assert.assertFalse(test);
    }




    @When("the user enters description {string}")
    public void the_user_enters_description(String keyword) {
    accountActivityPage.inputDescription.sendKeys(keyword);

    }
    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String keyword) {

        if(accountActivityPage.listedDescriptions.isEmpty()) Assert.fail(keyword + " not listed");


        for (WebElement eachDescription : accountActivityPage.listedDescriptions) {
                Assert.assertTrue(eachDescription.getText().contains(keyword));
        }

    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String keyword) {

        if(accountActivityPage.listedDescriptions.isEmpty()) Assert.fail(keyword + " not listed");

        for (WebElement eachDescription : accountActivityPage.listedDescriptions) {

            System.out.println("eachDescription.getText() = " + eachDescription.getText());
            System.out.println("keyword = " + keyword);
            Assert.assertTrue(!eachDescription.getText().contains(keyword) );

        }

    }



    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String header) {

        if(header.equals("Deposit")){
            Assert.assertTrue(accountActivityPage.listedDeposits.size()>0);
            return;
        }

        if(header.equals("Withdrawal")){
            Assert.assertTrue(accountActivityPage.listedWithdraws.size()>0);
        }

    }


    @When("user selects type {string}")
    public void user_selects_type(String option) {

        Select type=new Select(accountActivityPage.selectType);

        type.selectByVisibleText(option);
        BrowserUtils.sleep(1);

    }


    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String header) {

        if(header.equals("Deposit")){
            Assert.assertFalse(BrowserUtils.getStringListFromWebElementList(accountActivityPage.listedWithdraws).contains(header));
            return;
        }

        if(header.equals("Withdrawal")){
            Assert.assertFalse(BrowserUtils.getStringListFromWebElementList(accountActivityPage.listedDeposits).contains(header));
        }

    }



}
