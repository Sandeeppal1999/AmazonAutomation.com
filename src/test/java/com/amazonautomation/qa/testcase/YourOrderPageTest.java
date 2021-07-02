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

public class YourOrderPageTest extends BaseClass {
    SignInPage signInPage;
    HomePage homePage;
    YourOrderPage yourOrderPage;
    CartPage cartPage;

    public YourOrderPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        signInPage = new SignInPage();
        homePage = new HomePage();
        cartPage = new CartPage();
        homePage = signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        yourOrderPage = homePage.clickOnYourOrderPage();
    }

    @Test
    public void verifyYrOrderPageLabel() {
        Assert.assertTrue(yourOrderPage.YrOrderLabel());
    }

    @Test
    public void VerifyPlacedOrderDetails() {
        yourOrderPage.placedOrderDropDown();
    }

    @Test
    public void validateSearchBox() {
        yourOrderPage.searchBar();
    }

    @Test
    public void verifyAddToCart() throws InterruptedException {
        yourOrderPage.addToCartPage();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }

}
