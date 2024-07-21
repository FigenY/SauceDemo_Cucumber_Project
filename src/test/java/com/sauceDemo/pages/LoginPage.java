package com.sauceDemo.pages;

import com.sauceDemo.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

    @FindBy(id = "user-name")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "login-button")
    public WebElement loginBtn;

    public void login(){
        usernameBox.sendKeys(ConfigurationReader.get("username"));
        passwordBox.sendKeys(ConfigurationReader.get("password"));
        loginBtn.click();
    }

}
