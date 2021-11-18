package com.automation.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class WebDriveFactory {

    /*
    Write a static method that takes a string parameter name: browserType
    base on the value of parameter
    it will setup the browser and
    the method must return chromeDriver or firefoxdriver objext
    name: getDriver
     */

    public static WebDriver getDriver(String browserType){

        WebDriver driver = null;

        //Chrome, chrome, CHROME
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                break;

            case "safari":
                driver= new SafariDriver();
                break;
        }

        return driver;


    }
}
