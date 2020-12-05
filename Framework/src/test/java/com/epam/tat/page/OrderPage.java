package com.epam.tat.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderPage extends AbstractPage {


    @FindBy(xpath = "//input[@class=\"Shcart__PhoneInput\"]")
    private WebElement phoneInput;

    @FindBy(xpath = "//div[@class=\"Shcart__ItemTypeDelivery\"]")
    private WebElement courierDelivery;

    @FindBy(xpath = "//div[@class=\"filter-option-inner-inner\"]")
    private WebElement chooseCityDelivery;

    @FindBy(xpath = "//div[@class=\"inner open\"]")
    private WebElement cityDelivery;

    @FindBy(xpath = "//div[@class=\"Shcart__ButtonAdd Page__ActiveButtonBg\"]")
    private WebElement orderButton;

    protected OrderPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public OrderPage inputPhoneNumber(){
        String phoneNumber="123456789";
        phoneInput.sendKeys(phoneNumber);
        return this;
    }

    public OrderPage chooseCourierDelivery(){
        courierDelivery.click();
        return this;
    }

    public OrderPage openMenyCityDelivery(){
        chooseCityDelivery.click();
        return this;
    }

    public OrderPage chooseCity(){
        cityDelivery.click();
        return this;
    }

    @Override
    protected AbstractPage openPage() {
        return null;
    }
}
