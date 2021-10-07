package com.amazonautomation.qa.testcase;
import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.HomePage;
import com.amazonautomation.qa.pages.SignInPage;
import com.amazonautomation.qa.pages.YourOrderPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class YourOrderPageTest extends BaseClass {
    YourOrderPage yourOrderPage;
    SignInPage signInPage;
    HomePage homePage;
    public YourOrderPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        signInPage=new SignInPage();
        homePage=new HomePage();
        yourOrderPage=new YourOrderPage();
        homePage= signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        yourOrderPage= homePage.navigateYourOrderPage();
    }
    @Test
    public void verifyYourOrderTitle(){
         String title=yourOrderPage.yourOrderPageTitle();
         Assert.assertEquals(title,"Your Orders");
    }
    @Test
    public void verifyYourOrderPageLabel() {
        Assert.assertTrue(yourOrderPage.YourOrderLabel());
    }
    @Test
    public void VerifyDropDownFilter() {
        yourOrderPage.placedOrderDropDown();
    }
    @Test
    public void verifyYourOrderedSearchPro() {
        yourOrderPage.searchOrderedProduct();
    }
    @Test
    public void verifyBuyAgainOrderedItem() {
        yourOrderPage.buyAgain();
    }
//    @Test
    public void verifyAddToCart()  {
        yourOrderPage.addToCartSearchPro();
    }
    @Test
    public void verifyDeleteCart(){
        yourOrderPage.cleanMethod();
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }

}
