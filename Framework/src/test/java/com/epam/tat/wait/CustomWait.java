package com.epam.tat.wait;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomWait {
    private static final int WAIT_TIMEOUT_SECONDS = 10;

    public static void waitForPageLoaded(WebDriver driver){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.jQueryAJAXsCompleted());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(CustomConditions.waitForLoad());
    }
}