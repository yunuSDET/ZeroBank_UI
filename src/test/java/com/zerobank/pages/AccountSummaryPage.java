package com.zerobank.pages;

import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends BasePage{


    @FindBy(css="td a")
    public List<WebElement> links;

    public void clickLink(String text){



        for (WebElement link : links) {

            if(link.getText().toLowerCase().contains(text.toLowerCase())){
                link.click();

                break;
            }
        }
    }

}
