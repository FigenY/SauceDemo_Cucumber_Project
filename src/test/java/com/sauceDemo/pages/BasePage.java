package com.sauceDemo.pages;

import com.sauceDemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    public BasePage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy (css = ".shopping_cart_badge")
    public WebElement counterOfCart;

    @FindBy (css = ".shopping_cart_link")
    public WebElement shopCartLink;

    public String getPageTitle(String pageName){
        return Driver.get().findElement(By.xpath("//span[text()='"+pageName+"']")).getText();
    }

    public int getCounterOfCart(){
        String s = counterOfCart.getText();
        return Integer.parseInt(s);
    }
}
