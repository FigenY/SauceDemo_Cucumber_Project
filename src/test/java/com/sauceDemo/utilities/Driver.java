package com.sauceDemo.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class Driver {
    private Driver(){}

    private static WebDriver driver;

    public static WebDriver get(){
        if (driver == null){
            String browser = ConfigurationReader.get("browser");

            switch (browser.toLowerCase()){
                case "chrome" :
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")){
                        throw new WebDriverException("Your OS does NOT support Edge...");
                    }
                    driver = new EdgeDriver();
                    break;
                case "chrome-headless" :
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless"));
                    break;
                case "firefox-headless":
                    driver = new FirefoxDriver(new FirefoxOptions().addArguments("--headless"));
                    break;
            }

        }

        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.quit();
            driver = null;
        }
    }
}
