package com.epam.tat.service;

import com.epam.tat.model.Product;

public class ProductCreator {
    public static final String TESTDATA_PRODUCT_URL = "testdata.product.url";
    public static final String TESTDATA_PRODUCT_NAME = "testdata.product.name";
    public static final String TESTDATA_PRODUCT_SHORTNAME = "testdata.product.shortname";

    public static final String TESTDATA_PRODUCT_SONY_URL = "testdata.productSony.url";
    public static final String TESTDATA_PRODUCT_SONY_NAME = "testdata.productSony.name";

    public static final String TESTDATA_PRODUCT_CART_URL = "testdata.productOrderOnSite.url";
    public static final String TESTDATA_PRODUCT_CART_NAME = "testdata.productOrderOnSite.name";


    public static Product withUrlAndNameFromProperty(){
            return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_URL),
                    TestDataReader.getTestData(TESTDATA_PRODUCT_NAME));
        }
    public static Product withUrlAndNameSonyFromProperty(){
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_SONY_URL),
                TestDataReader.getTestData(TESTDATA_PRODUCT_SONY_NAME));
    }

    public static Product withUrlAndShortNameFromProperty(){
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_URL),
                TestDataReader.getTestData(TESTDATA_PRODUCT_SHORTNAME));
    }
    public static Product withUrlAndNameFromPropertyOnOrderSite(){
        return new Product(TestDataReader.getTestData(TESTDATA_PRODUCT_CART_URL),
                TestDataReader.getTestData(TESTDATA_PRODUCT_CART_NAME));
    }
}


