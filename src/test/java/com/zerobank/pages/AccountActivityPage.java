package com.zerobank.pages;

import io.cucumber.java.bs.A;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountActivityPage extends BasePage{

    @FindBy(id = "aa_accountId")
    public WebElement selectAccount;


    @FindBy(partialLinkText = "Find Transactions")
    public WebElement linkFindTransactions;


    @FindBy(xpath = "//h2[.='Find Transactions']")
    public WebElement headerUnderFindTransactions;


    @FindBy(id = "aa_description")
    public WebElement inputDescription;


    @FindBy(id = "aa_fromDate")
    public WebElement inputFromDate;


    @FindBy(id = "aa_toDate")
    public WebElement inputToDate;


    @FindBy(id = "aa_fromAmount")
    public WebElement inputFromAmount;


    @FindBy(id = "aa_toAmount")
    public WebElement inputToAmount;


    @FindBy(id = "aa_type")
    public WebElement selectType;


    @FindBy(xpath = "//button[.='Find']")
    public WebElement btnFind;



    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[1]")
    public List<WebElement> listedDates;

    

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[2]")
    public List<WebElement> listedDescriptions;


    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[3]")
    public List<WebElement> listedDeposits;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']//tr/td[4]")
    public List<WebElement> listedWithdraws;



    @FindBy(css = "#filtered_transactions_for_account div")
    public WebElement noResult;




}
