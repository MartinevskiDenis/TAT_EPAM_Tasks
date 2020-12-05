package com.epam.tat.page;

import com.epam.tat.model.User;
import com.epam.tat.wait.CustomWait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class MainPage extends AbstractPage {
    private final String BASE_URL = "https://www.portative.by/";

    //@FindBy(id = "Header__Authentication")
    private final By  signInFormButton =By.id("Header__Authentication");



    @FindBy(id = "email-tab")
    private WebElement linkEmailSignIn;

    private final By  inputPhone=By.id("LLoginForm_phone");


    private final By inputPassword=By.id("LLoginForm_password");


    private final By signInButton=By.xpath("//*[@class=\"Page__ActiveButtonBg Header__ButtonLogIn\"]");

    @FindBy(className = "menu-name")
    private WebElement divName;

    @FindBy(xpath = "//div[@class=\"Header__BlockLinkOffice header-photo-wrapper Header__LinkShowWapper\"]")
    private WebElement headerPhotoButton;

    private final Logger logger = LogManager.getRootLogger();
    public MainPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public List<WebElement> getProductOnViewed(){
        return driver.findElements(By.xpath("//*[@id=\"UserSession__CarouselUserSession\"]//div[@class=\"owl-item\"]//span[@itemprop=\"name\"]"));
    }

    public MainPage openSignInWindow(){

        driver.manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);
            getSignInFormButton().click();
            logger.info("click");
        return this;
    }
    public MainPage signIn(User user)
    {
        getClickableElement(inputPhone).sendKeys(user.getPhone());
        getClickableElement(inputPassword).sendKeys(user.getPassword());
        getClickableElement(signInButton).click();
        logger.info("signIn performed");
        return new MainPage(driver);
    }
    @Override
    public MainPage openPage() {
        driver.navigate().to(BASE_URL);
        return this;
    }



    private WebElement getClickableElement(By element){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(element));
    }

    public String getUserName(){
        CustomWait.waitForPageLoaded(driver);
        headerPhotoButton.click();
        return divName.getText();
    }
    public WebElement getSignInFormButton(){
        return new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.elementToBeClickable(signInFormButton));
    }
}
