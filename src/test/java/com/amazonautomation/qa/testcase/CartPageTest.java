package com.amazonautomation.qa.testcase;

import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.CartPage;
import com.amazonautomation.qa.pages.HomePage;
import com.amazonautomation.qa.pages.SignInPage;
import com.amazonautomation.qa.pages.YourOrderPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CartPageTest extends BaseClass {
    SignInPage signInPage;
    HomePage homePage;
    YourOrderPage yourOrderPage;
    CartPage cartPage;

    public CartPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        signInPage = new SignInPage();
        cartPage = new CartPage();
        yourOrderPage = new YourOrderPage();
        homePage = signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        yourOrderPage = homePage.clickOnYourOrderPage();
        cartPage = yourOrderPage.addToCartPage();
    }

    @Test
    public void verifyCartPageTitle() {
        String cartPageTitle = cartPage.validateCartPageTitle();
        Assert.assertEquals(cartPageTitle, "Amazon.in Shopping Cart", "CartPage title doesnot match");
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        getDriver().quit();
        unload();
    }
}
