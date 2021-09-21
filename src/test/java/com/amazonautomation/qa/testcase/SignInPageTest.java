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
    public void SignInNavigation() {
        signInPage.navigateSignInPage();
    }
    @Test
    public void verifySignInLabel()  {
        Assert.assertTrue(signInPage.signInLabel());
    }
    @Test
    public void checkUserLogin() {
        signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test
    public void clickOnCreateNewAmazonAccount(){
        signInPage.createYourNewAmazonAccount();
    }
    @Test
    public void verifySignInAmazonLogo(){
        signInPage.signLogoAmazon();
    }
    @Test
    public void verifyScrollDown() {
        signInPage.scrollDownHomePage();
    } @Test
    public void verifyNoOfCarousel() {
        signInPage.noOfCarousel();
    }
    @Test
    public void verifyCarouselClickable() {
        signInPage.carouselClickable();
    }
    @Test
    public void verifyNeedHelpClickable(){
        signInPage.needHelp();
    }
    @Test
    public void verifyForgotPasswordClickable(){
        signInPage.needHelp_ForgotPassword();
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}
