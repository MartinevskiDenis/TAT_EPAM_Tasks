package com.epam.tat.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ComparisionPage extends AbstractPage {

    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "/html/head/title")
    private WebElement titlee;

    public ComparisionPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle(){
        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
        return titlee.getText();
    }

    public Integer getCountElementsInComparision(){
        return driver.findElements(By.className("ComparePage__InnerBlockInfoModel")).size();
    }

    @Override
    protected ComparisionPage openPage() {
        return null;
    }
}
