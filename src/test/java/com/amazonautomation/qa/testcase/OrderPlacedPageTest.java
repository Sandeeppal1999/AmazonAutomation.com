package com.amazonautomation.qa.testcase;
import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class OrderPlacedPageTest extends BaseClass {
    OrderPlacedPage orderPlacedPage;
    SignInPage signInPage;
    HomePage homePage;
    ProductDetailsPage productDetailsPage;
    CartPage cartPage;
    public OrderPlacedPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        signInPage=new SignInPage();
        productDetailsPage=new ProductDetailsPage();
        cartPage=new CartPage();
        orderPlacedPage=new OrderPlacedPage();
        homePage= signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        productDetailsPage =homePage.fetchItemDetails();
        cartPage=productDetailsPage.navigateToCartPage();
        orderPlacedPage=cartPage.proceedToBuyItem();
    }
    @Test
    public void verifyTitleOfPlacedOrderPage(){
        String orderPlacedPageTitle = orderPlacedPage.getTitleOrderPlacedPage();
        Assert.assertEquals(orderPlacedPageTitle, "Select a delivery address", "orderPlacedPage title does not match");
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}
