package com.epam.tat.test;

import com.epam.tat.page.FilterPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ActionWithFilter extends CommonCondition {
    @Test
    public void applyedFilterTest(){
        String expectedDataModel="409224";
        Assert.assertTrue(new FilterPage(driver).openPage()
                .setSteelModel()
                .setWomenType()

                .setSteelMaterial()
                .setTwoSides()
                .appledFilter()
                .isProductOnPage(expectedDataModel));

    }
}
