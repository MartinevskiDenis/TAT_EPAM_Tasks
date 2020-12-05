package com.epam.tat.util;

public class IntegerUtil {
    public static int parsePrice(String priceStr){

        return Integer.parseInt(priceStr.replaceAll("[^\\d]", ""));
    }
}
