package com.sauceDemo.tests;

import com.sauceDemo.pages.*;
import com.sauceDemo.utilities.BrowserUtils;
import com.sauceDemo.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class SauceDemoTask extends TestBase {
    LoginPage loginPage;
    ProductsPage productsPage;
    YourCartPage yourCartPage;
    CheckoutYourInformation checkoutYourInformation;
    CheckoutOverviewPage checkoutOverviewPage;
    CheckoutCompletePage checkoutCompletePage;

    @Test
    public void successShoppingE2ETest() {
        /**

         1-Create a project from scratch. Design all packages, classes and ohter files...
         2-Navigate to https://www.saucedemo.com/
         3-Login with valid credentials (shown on the page)
         4-Sort the products high to  low
         5-Add to cart at least two item
         6-Assert that the basket shows the true number of product
         7-Navigate to Your cart page
         8-Assert that the right items added to cart
         9-go to checkout page and fill the form
         10-click continue button and go to the checkout overview page
         11-Click finish and assert the success shopping message

         notes:     a. every new page should be asserted by page title
         b.   use parameterized methods.
         c. This is an e2e test so u can create one test method for this task called success shopping  test
         good luck.

         */
        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        yourCartPage = new YourCartPage();
        checkoutYourInformation = new CheckoutYourInformation();
        checkoutOverviewPage = new CheckoutOverviewPage();
        checkoutCompletePage = new CheckoutCompletePage();


        extentLogger = report.createTest("TC-005 Success Shopping");
        extentLogger.info("Navigate to " + ConfigurationReader.get("url"));
        driver.get(ConfigurationReader.get("url"));

        extentLogger.info("Login with valid credentials (shown on the page)");
        loginPage.login();

        extentLogger.info("Verify that Products page is displayed.");
        String actualTitle = productsPage.getPageTitle("Products");
        String expectedTitle = "Products";
        Assert.assertEquals(actualTitle, expectedTitle);

        extentLogger.info("Sort the products high to  low");
        productsPage.sortProduct("Price (high to low)");

        extentLogger.info("Add to cart at least two item");
        productsPage.addProduct("Sauce Labs Onesie");
        productsPage.addProduct("Sauce Labs Bolt T-Shirt");
        // productsPage.addProduct("Test.allTheThings() T-Shirt (Red)");

        extentLogger.info("Assert that the basket shows the true number of product");
        Assert.assertEquals(productsPage.getCounterOfCart(), ProductsPage.productCounter);

        extentLogger.info("Navigate to Your cart page");
        productsPage.shopCartLink.click();

        extentLogger.info("Verify that Your Cart  page is displayed.");
        String actualTitle_1 = yourCartPage.getPageTitle("Your Cart");
        String expectedTitle_1 = "Your Cart";
        Assert.assertEquals(actualTitle_1, expectedTitle_1);

        extentLogger.info("Assert that the right items added to cart");
        List<String> expectedProducts = new ArrayList<>();
        expectedProducts.add("Sauce Labs Onesie");
        expectedProducts.add("Sauce Labs Bolt T-Shirt");

        List<String> actualProducts = BrowserUtils.getElementsText(yourCartPage.cartProducts);
        Assert.assertEquals(actualProducts, expectedProducts);

        extentLogger.info("go to checkout page and fill the form");
        yourCartPage.checkoutBtn.click();

        extentLogger.info("Verify that Checkout: Your Information page is displayed.");
        String actualTitle_2 = checkoutYourInformation.getPageTitle("Checkout: Your Information");
        String expectedTitle_2 = "Checkout: Your Information";
        Assert.assertEquals(actualTitle_2, expectedTitle_2);

        extentLogger.info("fill the form and continue");
        checkoutYourInformation.fillFormAndContinue(faker.name().firstName(), faker.name().lastName(),
                faker.address().zipCode());

        extentLogger.info("click continue button and go to the checkout overview page");
        extentLogger.info("Verify that Checkout: Overview page is displayed.");
        String actualTitle_3 = checkoutOverviewPage.getPageTitle("Checkout: Overview");
        String expectedTitle_3 = "Checkout: Overview";
        Assert.assertEquals(actualTitle_3, expectedTitle_3);

        extentLogger.info("Click finish and assert the success shopping message");
        checkoutOverviewPage.finishBtn.click();
        extentLogger.info("Verify that Checkout: Checkout: Complete! page is displayed.");
        String actualTitle_4 = checkoutCompletePage.getPageTitle("Checkout: Complete!");
        String expectedTitle_4 = "Checkout: Complete!";
        Assert.assertEquals(actualTitle_4, expectedTitle_4);

        extentLogger.info("assert the success shopping message");
        String actualMessage = checkoutCompletePage.successMessage.getText();
        String expectedMessage = "Thank you for your order!";
        Assert.assertEquals(actualMessage, expectedMessage);

        extentLogger.pass("Pass...!");


    }

    @Test
    public void test2() {

        loginPage = new LoginPage();
        productsPage = new ProductsPage();
        driver.get(ConfigurationReader.get("url"));

        loginPage.login();

        String actualTitle = productsPage.getPageTitle("Products");
        String expectedTitle = "Products";
        Assert.assertEquals(actualTitle, expectedTitle);
    }
}
