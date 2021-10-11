package com.amazonautomation.qa.testcase;
import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.*;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class CartPageTest extends BaseClass {
    SignInPage signInPage;
    HomePage homePage;
    YourOrderPage yourOrderPage;
    CartPage cartPage;
    ProductDetailsPage productDetailsPage;
    public CartPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() throws InterruptedException {
        initialization();
        signInPage=new SignInPage();
        homePage=new HomePage();
        productDetailsPage=new ProductDetailsPage();
        cartPage=new CartPage();
        homePage= signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
       cartPage= homePage.cartPageNavigate();
    }
    @Test
    public void verifyCartPageTitle() {
        String cartPageTitle = cartPage.validateCartPageTitle();
        Assert.assertEquals(cartPageTitle, "Amazon.in Shopping Cart", "CartPage title doesnot match");
    }
    @Test
    public void verifyShoppingCartLabel(){
        cartPage.shoppingCartLabel();
    }
    @Test
    public void verifyProceedToCart(){
        cartPage.proceedToBuyItem();
    }
    @Test
    public void navigationTOCart(){
        System.out.println("hello");
    }
    @Test
    public void noOfItemsInCart(){
    cartPage.checkCartCount();
    }
    @Test
    public void verifyCartCountEqNoOfCartItem(){
       cartPage.cartCountEqCartSize();
    }
    @Test
    public void deleteNthItem(){
        cartPage.deleteNthCartItem();   }
    //@Test
    public void deleteAllItem(){
       cartPage.deleteAllItemFromCart();
    }
    @AfterMethod
    public void tearDown()  {
        getDriver().quit();
        unload();
    }
}
