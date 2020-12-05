package com.epam.tat.test;

import com.epam.tat.model.User;
import com.epam.tat.page.MainPage;
import com.epam.tat.service.UserCreator;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserAccesTest extends CommonCondition {
    @Test
    public void oneCanLoginGithub() {
        String expectedName="userForTestFramework12345";
        User testUser = UserCreator.withCredentialsFromProperty();
        String loggedInUserName = new MainPage(driver)
                .openPage()
                .openSignInWindow()

                .signIn(testUser)
                .getUserName();
        System.out.println(loggedInUserName);
        Assert.assertEquals(loggedInUserName, expectedName);
    }
}
