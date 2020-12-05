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

public class ProductPage extends AbstractPage {
        private final Logger logger = LogManager.getRootLogger();
        private String productUrl;


     @FindBy(className = "header-logo")
     private WebElement logoButton;

     @FindBy(xpath = "//a[@data-ga=\"add_to_cart\"]")
     private WebElement addToCartButton;

     @FindBy(xpath = "//a[@class=\"header-link cart-link\"]")
     private WebElement cartPageButton;

    //@FindBy(className = "Favourites__Text favourites-text")
    private By addToFavoriteButton=new By.ByClassName("Favourites__BlockButton");

    //@FindBy(className = "header-link favourites-link")
    private By favoriteButton=new By.ByClassName("favourites-link");

    private By addToComairButton=new By.ByClassName("CompareBlock__Text");

    private By compairButton=new By.ByClassName("comparision-link");

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public ProductPage(WebDriver driver, String productUrl) {
        super(driver);
        this.productUrl = productUrl;
        PageFactory.initElements(this.driver, this);
    }

    public ProductPage addToCart(){
        addToCartButton.click();
        CustomWait.waitForPageLoaded(driver);
        return this;
    }

    public ProductPage addToFavorite(){
        getClickableElement(addToFavoriteButton).click();

        return this;
    }

    public CartPage openCartPage(){
        cartPageButton.click();
        CustomWait.waitForPageLoaded(driver);
        return new CartPage(driver);
    }

    public ProductPage addToCompair(){
        getClickableElement(addToComairButton).click();
        return this;
    }
    public ComparisionPage openComparisionPage(){
        getClickableElement(compairButton).click();
        return new ComparisionPage(driver);
    }

    public FavoritesPage openFavoritePage(){
        getClickableElement(favoriteButton).click();
        //favoriteButton.click();
        CustomWait.waitForPageLoaded(driver);
        return new FavoritesPage(driver);
    }

    public MainPage openMainPage(){
        logoButton.click();
        CustomWait.waitForPageLoaded(driver);
        return new MainPage(driver);
    }


    @Override
    public ProductPage openPage() {
        driver.navigate().to(productUrl);
        logger.info("Product page opened");
        CustomWait.waitForPageLoaded(driver);

        return this;
    }
    private WebElement getClickableElement(By element){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }
}
