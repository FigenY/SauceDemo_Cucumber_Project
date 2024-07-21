package com.sauceDemo.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutOverviewPage extends BasePage{

    @FindBy(id = "finish")
    public WebElement finishBtn;
}
