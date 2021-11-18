package com.automation.utilities;

import com.mifmif.common.regex.Generex;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BrowserUtils {

    /**
     * This method returns a generated email
     *
     * @return Email with 10 chars in name
     */
    public static String generateEmail() {
        String regex = "\\w{10}\\@gmail\\.com";
        return new Generex(regex).random();
    }


    /**
     * Performs a pause
     *
     * @param seconds
     */
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Waits for the provided element to be visible on the page
     *
     * @param element
     * @param timeToWaitInSec
     * @return
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitInSec) {
        WebDriverWait wait = new WebDriverWait(com.automation.utilities.Driver.get(), timeToWaitInSec);
        return wait.until(ExpectedConditions.visibilityOf(element));
    }


    /**
     * Verifies whether the element is displayed on page
     *
     * @param element
     * @throws AssertionError if the element is not found or not displayed
     */
    public static void verifyElementDisplayed(WebElement element) {
        try {
            Assert.assertTrue(element.isDisplayed(), "Element not visible: " + element);
        } catch (NoSuchElementException e) {
            e.printStackTrace();
            Assert.fail("Element not found: " + element);

        }
    }

    /**
     * Checks or unchecks given checkbox
     *
     * @param element
     * @param check
     */
    public static void selectCheckBox(WebElement element, boolean check) {
        if (check) {
            if (!element.isSelected()) {
                element.click();
            }
        } else {
            if (element.isSelected()) {
                element.click();
            }
        }
    }


    /**
     * takes screenshot
     * @param name
     * take a name of a test and returns a path to screenshot takes
     */
    public static String getScreenshot(String name) throws IOException {
        // name the ss with the current date time to avoid duplicate name
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        //TakesScreenshot -> interface from selenium which takes ss
        TakesScreenshot ts = (TakesScreenshot) com.automation.utilities.Driver.get();
        File source = ts.getScreenshotAs((OutputType.FILE));
        // full path for the ss location
        String target = System.getProperty("user.dir") + "\\test-output\\Screenshots\\" + name + date + ".png";
        File finalDestination = new File(target);
        //save the ss to the given path
        FileUtils.copyFile(source, finalDestination);
        return target;
    }

}
