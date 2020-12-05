package com.epam.tat.test;

import com.epam.tat.model.Product;
import com.epam.tat.page.ProductPage;
import com.epam.tat.service.ProductCreator;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


public class ActionsWithProductTests extends CommonCondition {
    private Product product = ProductCreator.withUrlAndNameFromProperty();
    private Product productSony=ProductCreator.withUrlAndNameSonyFromProperty();

    @Test
    public void addingToFavoritesTest(){
        ProductPage productPage = new ProductPage(driver, product.getUrl())
                .openPage();

        productPage.addToFavorite();
        Assert.assertTrue(productPage
                .openFavoritePage()
                .isProductOnPage(product.getName()));
    }

    @Test
    public void deleteFromFavoritesTest(){
        String expected="Список избранного пуст";
        Assert.assertEquals(
                new ProductPage(driver, product.getUrl())
                        .openPage()
                .addToFavorite()

                .openFavoritePage()
                .deleteProduct()
                .getHeader(),expected);
    }



    @Test
    public void addingToComprasionTest(){
        ProductPage productPageSony=new ProductPage(driver,productSony.getUrl())
                .openPage()
                .addToCompair();
        ProductPage productPage=new ProductPage(driver,product.getUrl())
                .openPage()
                .addToCompair();
        Integer actual=productPage.openComparisionPage().getCountElementsInComparision();
        Integer expected=2;
        Assert.assertEquals(actual,expected);
    }

//    @Test
//    public void addedToViewedListTest(){
//        Product product=ProductCreator.withUrlAndShortNameFromProperty();
//        String name="Apple iPhone 11 64Gb Black";
//        List<WebElement> viewedList=new ProductPage(driver,product.getUrl())
//                .openPage()
//                .openMainPage()
//                .getProductOnViewed();
//        Assert.assertTrue(viewedList.stream().anyMatch(x-> x.getText().equals(name)));
//    }


}
