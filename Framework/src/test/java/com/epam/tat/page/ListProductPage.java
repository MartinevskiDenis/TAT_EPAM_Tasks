package com.epam.tat.page;

import com.epam.tat.wait.CustomWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ListProductPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private String productUrl;

    public ListProductPage(WebDriver driver, String url) {
        super(driver);
        productUrl=url;
        PageFactory.initElements(this.driver,this);
    }

    //@FindBy(xpath = "//div[@class=\"PanelSetUp__SortBlock PanelSetUp__SortActBlock\"]")
    //private WebElement choosingTypeSort;

    private By choosingTypeSort=new By.ByXPath("//div[@class=\"PanelSetUp__SortBlock PanelSetUp__SortActBlock\"]");

    @FindBy(xpath = "//ul[@class=\"chzn-results\"]/li[1]")
    private WebElement chooseSortPopularButton;

    @FindBy(xpath = "//ul[@class=\"chzn-results\"]/li[2]")
    private WebElement chooseSortCheapButton;

    @FindBy(xpath = "//ul[@class=\"chzn-results\"]/li[3]")
    private WebElement chooseSortExpenciveButton;

    @FindBy(xpath = "//ul[@class=\"chzn-results\"]/li[4]")
    private WebElement chooseSortSaleButton;


    @Override
    public ListProductPage openPage()
    {
        driver.navigate().to(this.productUrl);
        logger.info("Filter page opened");
        CustomWait.waitForPageLoaded(driver);
        return this;

    }

    public ListProductPage sortSale(){
       // choosingTypeSort.click();
        getClickableElement(choosingTypeSort).click();
        chooseSortSaleButton.click();
        CustomWait.waitForPageLoaded(driver);
        return this;
    }

    public ListProductPage sortCheapPrice(){
       getClickableElement(choosingTypeSort).click();
        chooseSortCheapButton.click();
        return this;
    }
    public ListProductPage sortExpencivePrice(){
        getClickableElement(choosingTypeSort).click();
        chooseSortExpenciveButton.click();
        return this;
    }
    public ListProductPage sortPopular(){

        CustomWait.waitForPageLoaded(driver);
        getClickableElement(choosingTypeSort).click();
        chooseSortPopularButton.click();
        CustomWait.waitForPageLoaded(driver);
        return this;
    }
    public List<WebElement> getProductsPrice(){
        return driver.findElements(By.xpath("//span[@class=\"PriceBlock__PriceValue\"]/span"));
    }
    public List<WebElement> getProductsSale(){
        return driver.findElements(By.xpath("//span[@class=\"PriceBlock__DiscountValue\"]"));
    }
    private WebElement getClickableElement(By element){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

}
