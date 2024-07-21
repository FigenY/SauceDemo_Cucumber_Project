package com.sauceDemo.pages;

import com.sauceDemo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage{

    public static int productCounter;

    @FindBy(css = ".product_sort_container")
    public WebElement sortingDropDown;

    public void sortProduct(String sortingType){
        Select select = new Select(sortingDropDown);
        select.selectByVisibleText(sortingType);
    }

    public void addProduct(String productName){
        Driver.get().findElement(By.xpath("//*[text()='"+productName+"']/ancestor::div[@class='inventory_item_description']//button")).click();
        productCounter++;
    }
}
