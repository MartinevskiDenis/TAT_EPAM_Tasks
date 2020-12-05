package com.epam.tat.test;

import com.epam.tat.driver.DriverManager;
import com.epam.tat.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonCondition {

    protected WebDriver driver;


    @BeforeMethod()
    public void setUp()
    {
        driver = DriverManager.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverManager.closeDriver();
    }
}
