package com.zerobank.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class OnlineBankingPage extends BasePage {


    @FindBy(id = "account_summary_link")
    public WebElement accountSummaryLink;



    @FindBy(className = "headers")
    public List<WebElement> headerLinks;



    public void clickHeaders(String linkText){
        for (WebElement eachLink : headerLinks) {
            if (eachLink.getText().contains(linkText)){
                eachLink.click();
                break;
            }
        }
    }


}
