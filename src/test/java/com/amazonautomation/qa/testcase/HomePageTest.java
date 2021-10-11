package com.amazonautomation.qa.testcase;
import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.HomePage;
import com.amazonautomation.qa.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
public class HomePageTest extends BaseClass {
    HomePage homePage;
    SignInPage signInPage;
    public HomePageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        signInPage=new SignInPage();
       homePage =signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
    }
    @Test(priority = 1)
    public void verifyHomePageTitle() {
        String title = homePage.homePageTitle();
        System.out.println("-->Title of Home Page"+title);
        Assert.assertEquals(title,"Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in");
    }
    @Test
    public void verifyHelloUserName() {
        Assert.assertTrue(homePage.helloUserNameVisible());
    }
//    @Test
    public void verifyHiUserName() {
        Assert.assertTrue(homePage.hiUserNameVisible());
    }
//    @Test
    public void verifyLoggedUserDuration() {
        Assert.assertTrue(homePage.loggedUserDuration());
    }
    @Test
    public void clickOnAmazonPayPage() {
        homePage.clickOnAmazonPay();
    }
    @Test
    public void verifyClickOnYourOrder() {
       homePage.clickOnYourOrderPage();
    }
    @Test
    public void verifyClickYourAccount() {
        homePage.clickOnYourAccount();
    }
    @Test
    public void verifySearchItem() {
        homePage.searchItem();
    }
    @Test
    public void verifyPrintSearchItem(){
        homePage.listOfSearchItem();
    }
    @Test
    public void verifyPrintSponsoredSearchItem(){
        homePage.listOfSponsoredSearchItem();
    }
    @Test
    public void verify25PerOffOrMore() {
        homePage.discount25perOrMore();
    }
    @Test
    public void verifyCheckBoxPayOnDeliveryOrStock() {
        homePage.selectCheckBoxPayOnDeliveryOutOfStock();
    }
    @Test
    public void verifyFetchNthProduct() {
        homePage.fetchNthProduct();
    }
    @Test
    public void verifyFetchItemDetails() {
        homePage.fetchItemDetails();
    }
    @Test
    public void verifyAmazonLogoImage() {
        boolean flag = homePage.amazonLogoImage();
        Assert.assertTrue(flag);
    }
    @Test
    public void noOfLinkOnHomePage() {
        homePage.countNoOfLinkOnHomePage();
    }
    @Test
    public void verifyNavigateYourAccountPage(){
        homePage.navigateYourAccountPage();
    }
    @Test
    public void verifyNavigateYourOrderPage(){
        homePage.navigateYourOrderPage();
    }
    @Test
    public void navigateTOCartPage(){
        homePage.cartPageNavigate();
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}
