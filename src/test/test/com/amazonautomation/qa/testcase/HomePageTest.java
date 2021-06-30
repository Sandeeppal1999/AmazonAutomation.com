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

public class HomePageTest extends BaseClass {
    SignInPage signInPage;
    HomePage homePage;
    CartPage cartPage;
    YourOrderPage yourOrderPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        signInPage = new SignInPage();
        homePage = new HomePage();
        homePage = signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
    }

    @Test
    public void verifyLoggedUserName() {
        Assert.assertTrue(homePage.loggedUserName());
    }

    @Test
    public void verifyUserNameVisible() {
        Assert.assertTrue(homePage.userNameVisible());
    }

    @Test
    public void verifyLoggedUserDuration() {
        Assert.assertTrue(homePage.loggedUserDuration());
    }

    @Test
    public void clickOnAmazonPayPage() {
        homePage.clickOnAmazonPay();
    }

    @Test
    public void clickOnYourOrder() {
        yourOrderPage = homePage.clickOnYourOrderPage();
    }

    @Test
    public void verifyYourAccount() {
        homePage.clickOnYourAccount();
    }

    @Test
    public void verifySearchItem() {
        homePage.searchItem();
    }

    @Test
    public void verify50OffOrMore() {
        verifySearchItem();
        homePage.off50OrMore();
    }

    @Test
    public void verifyCheckBoxStock() {
        verifySearchItem();
        homePage.checkboxPayOrstock();
    }

    @Test
    public void verifyFilterSearchItem() {
        verifySearchItem();
        homePage.checkboxPayOrstock();
        String text = homePage.filteredSearchItem();
        Assert.assertEquals(text, "Redmi 9 (Sky Blue, 4GB RAM, 64GB Storage)| 5000 mAh| 2.3GHz Mediatek Helio G35 Octa core Processor");
    }

    @Test
    public void verifyNavigateNewTab() {
        verifyFilterSearchItem();
        homePage.redmi9NewTab();
    }

    @Test
    public void verifyAddToCart() {
        verifyNavigateNewTab();
        homePage.addTocartItem();
    }

    @Test
    public void verifyNavigateToCart() {
        verifyAddToCart();
        cartPage = homePage.navigateCart();
    }

    @Test
    public void verifyScrollDown() {
        homePage.scrollDownHomePage();
    }

    @Test
    public void verifyBackToTop() {
        homePage.scrollDownHomePage();
        homePage.backToTop();
    }

    @Test
    public void verifyCarouselClickable() {
        homePage.noOfCarousel();
    }

    @Test
    public void verifyTodayDealsSlider() {
        homePage.todayDealsSlider();
    }

    @Test
    public void amazonLogoImageTest() {
        boolean flag = homePage.amazonLogoImage();
        Assert.assertTrue(flag);
    }

    @Test
    public void noOfLinkOnHomePage() {
        homePage.countNoOfLinkOnHomePage();
    }

    @Test
    public void loginPageTitle() {
        String title = homePage.verifyHomepageTitle();
        Assert.assertEquals(title, "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in", "HomePage Title not matched");
    }

    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}
