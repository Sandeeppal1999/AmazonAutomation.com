package com.amazonautomation.qa.testcase;
import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.HomePage;
import com.amazonautomation.qa.pages.ProductDetailsPage;
import com.amazonautomation.qa.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class ProductDetailsPageTest extends BaseClass {
    SignInPage signInPage;
    ProductDetailsPage productDetailsPage;
    HomePage homePage;
    public ProductDetailsPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        signInPage=new SignInPage();
        homePage = new HomePage();
        productDetailsPage =new ProductDetailsPage();
        homePage= signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        productDetailsPage =homePage.fetchItemDetails();
    }
    @Test
    public void verifyProductDetailsImage(){
        productDetailsPage.validateProductImage();
    }
    @Test
    public void verifyAboutThisItem(){
        Assert.assertTrue(productDetailsPage.validateAboutThisItem());
    }
    @Test
    public void verifyBackToResult(){
        Assert.assertTrue(productDetailsPage.backToResult());
    }
    @Test
    public void verifyAddToCart(){
        productDetailsPage.addToCartItem();
    }
    @Test
    public void verifyItemAddedTOCart(){
        productDetailsPage.validatedItemAddedToCart();
    }
    @Test
    public void verifyNavigateToCart(){
        productDetailsPage.navigateToCartPage();
    }
    @Test
    public void verifyBuyNow(){
        productDetailsPage.validateBuyNow();
    }
    @Test
    public void verifyScrollDownTillProSpecification(){
        productDetailsPage.scrollDownProductSpecification();
        //print table size and content
    }
//    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}
