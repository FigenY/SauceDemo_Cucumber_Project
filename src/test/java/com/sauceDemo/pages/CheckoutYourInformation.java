package com.sauceDemo.pages;

import com.sauceDemo.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CheckoutYourInformation extends BasePage{

    @FindBy(tagName = "input")
    public List<WebElement> formInputs;

    public void fillFormAndContinue(String firstName, String lastName, String postalCode){
        formInputs.get(0).sendKeys(firstName);
        formInputs.get(1).sendKeys(lastName);
        formInputs.get(2).sendKeys(postalCode);
        BrowserUtils.waitFor(2);
        formInputs.get(3).click();
    }
}
