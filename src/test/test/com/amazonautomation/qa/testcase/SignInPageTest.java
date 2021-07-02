package com.amazonautomation.qa.testcase;

import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignInPageTest extends BaseClass {
    SignInPage signInPage;

    @BeforeMethod
    public void setUp() {
        initialization();
        signInPage = new SignInPage();
    }

    @Test
    public void verifySignInNavigation() {
        signInPage.navigateSignInPage();
    }

    @Test
    public void verifySignInLabel() {
        Assert.assertTrue(signInPage.signInLabel());
    }

    @Test
    public void VerifyUserLogin() {
        signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}
