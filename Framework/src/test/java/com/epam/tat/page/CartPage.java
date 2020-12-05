package com.epam.tat.page;

import com.epam.tat.wait.CustomWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CartPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.portative.by/cart/";

    @FindBy(xpath = "//a[@class=\"ShopItemList__AddToCart Page__ActiveButtonBg order-button\"]")
    private WebElement orderPageButton;

    @FindBy(xpath = "//div[@class=\"Shcart__ItemDeleteBtn Shcart__OrderDeleteBtn\"]")
    private WebElement deleteProductFromCartButton;

    private By deleteButton=new By.ByXPath("//span[@class=\"Page__DeleteMessageButton\"]");


    @FindBy (xpath = "//h1[@class=\"Page__TitleActivePage\"]")
    private WebElement headerCart;
    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getProductsInCart(){
        return driver.findElements(By.xpath("//div[@class=\"ModelList__NameBlock\"]"));
    }

    public OrderPage openOrderPage(){
        orderPageButton.click();
        CustomWait.waitForPageLoaded(driver);
        return new OrderPage(driver);
    }

    public CartPage deleteProduct(){
        deleteProductFromCartButton.click();
        getClickableElement(deleteButton).click();
        return this;
    }

    public String getHeaderCart(){
        driver.navigate().refresh();
        CustomWait.waitForPageLoaded(driver);
        return headerCart.getText();
    }

    private WebElement getClickableElement(By element){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
