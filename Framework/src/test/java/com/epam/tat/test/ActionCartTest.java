package com.epam.tat.test;

import com.epam.tat.model.Product;
import com.epam.tat.page.ProductPage;
import com.epam.tat.service.ProductCreator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class ActionCartTest extends CommonCondition {
    Product product= ProductCreator.withUrlAndNameFromPropertyOnOrderSite();

    @Test
    public void addedToCart(){
        List<WebElement> productsInCart=new  ProductPage(driver,product.getUrl())
                .openPage()
                .addToCart()
                .openCartPage()
                .getProductsInCart();
        for (WebElement item:productsInCart
             ) {
            System.out.println(item.getText());
        }
        Assert.assertTrue(productsInCart.stream().anyMatch(x-> x.getText().equals("Видеорегистратор Xiaomi 70mai Dash Cam Lite модель Midrive D08")));
    }

    @Test
    public void deleteFromCart(){
        String expected="Ваша корзина пуста";
        Assert.assertEquals(new ProductPage(driver,product.getUrl())
                .openPage()
                .addToCart()
                .openCartPage()
                .deleteProduct()
                .getHeaderCart(),expected);
    }



}
