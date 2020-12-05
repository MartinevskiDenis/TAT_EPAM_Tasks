package com.epam.tat.page;

import com.epam.tat.wait.CustomWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class FavoritesPage extends AbstractPage {
    private final Logger logger = LogManager.getRootLogger();
    private final String BASE_URL = "https://www.portative.by/favorites/";


    private By productLocator;
    private List<WebElement> productList;

    @FindBy(xpath = "//div[@class=\"delete-button\"]")
    private WebElement deleteButton;

    @FindBy(xpath = "//h2[@class=\"favourites-title PageAutn__Title\"]")
    private WebElement headerFavoritePage;


    protected FavoritesPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver,this);
    }

    public FavoritesPage deleteProduct(){
        CustomWait.waitForPageLoaded(driver);
        deleteButton.click();
        CustomWait.waitForPageLoaded(driver);
        return this;
    }

    public String getHeader(){
        return headerFavoritePage.getText();
    }



    public Boolean isProductOnPage(String name){
        productList=  driver.findElements(By.id("favourites-content"));
        name="Мышь проводная USB оптическая A4Tech Bloody X5 Max с подсветкой 9 кнопок 10000 dpi игровая черная";

        productLocator = By.xpath("//*[text()='"+name+"']");
        try{
            new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                    .until(ExpectedConditions.presenceOfElementLocated(productLocator));
        }catch (TimeoutException e){
            logger.info("Product not found");
            return false;
        }
        return true;
    }

    @Override
    public FavoritesPage openPage() {
        driver.navigate().to(BASE_URL);
        logger.info("Favorites page opened");
        CustomWait.waitForPageLoaded(driver);
        return this;
    }

}
