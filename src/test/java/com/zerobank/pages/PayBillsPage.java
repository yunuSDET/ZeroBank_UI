package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PayBillsPage extends BasePage {


    @FindBy(css = "#tabs li")
    public List<WebElement> tabLinks;


    @FindBy(css = "#ui-tabs-2 .control-group div *")
    public List<WebElement> inputBoxesTabNewPayee;

    @FindBy(css = "#ui-tabs-2 .control-group label")
    public List<WebElement> labelsTabNewPayee;


    @FindBy(id = "pc_currency")
    public WebElement selectCurrency;


    @FindBy(id = "add_new_payee")
    public WebElement btnAddTabNewPayee;


    @FindBy(id = "alert_content")
    public WebElement alertContent;

    @FindBy(id = "pc_amount")
    public WebElement inputAmount;


    @FindBy(id = "pc_inDollars_true")
    public WebElement radioBtnDollar;

    @FindBy(id = "pc_inDollars_false")
    public WebElement radioBtnDollarFalse;



    @FindBy(id = "pc_calculate_costs")
    public WebElement btnCalculateCosts;


    @FindBy(id = "purchase_cash")
    public WebElement btnPurchase;





}
