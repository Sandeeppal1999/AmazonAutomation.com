package com.amazonautomation.qa.testcase;
import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.HomePage;
import com.amazonautomation.qa.pages.SignInPage;
import com.amazonautomation.qa.pages.YourAccountPage;
import com.amazonautomation.qa.utilties.TestUtil;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class YourAccountPageTest extends BaseClass {
    SignInPage signInPage;
    YourAccountPage yourAccountPage;
    TestUtil testUtil;
    HomePage homePage;
    public YourAccountPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        signInPage=new SignInPage();
        testUtil = new TestUtil();
        homePage=new HomePage();
        yourAccountPage=new YourAccountPage();
        homePage= signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        yourAccountPage= homePage.navigateYourAccountPage();
    }
    @Test
    public void verifyYourAccountPageTitle(){
        String title = yourAccountPage.validateYourAccountTitle();
        Assert.assertEquals(title,"Your Account");
    }
    @Test
    public void verifyYourAccountLabel(){
        String label=yourAccountPage.yourAccountLabel();
        Assert.assertEquals(label,"Your Account");
    }
    @Test
    public void verifyNavigateYourOrder(){
        yourAccountPage.yourOrderNavigate();
    }
    @Test
    public void verifyNavigateYourAddress() {
        yourAccountPage.yourAddressNavigate();
    }
    @Test
    public void verifyYourAddressesLabel(){
        String label=yourAccountPage.yourAddressesLabel();
        Assert.assertEquals(label,"Your Addresses");
    }
    @Test
    public void verifyAddNewAddress() {

        yourAccountPage.addNewAddress();
    }
    @DataProvider(name = "getAmazonTestData")
    public Object[][] getAmazonTestData() {
        Object[][] data = TestUtil.getTestData_AddNewAddress();
        return data;
    }
    @Test(dataProvider = "getAmazonTestData")
    public void VerifyCreateNewADD(String country, String fullName, String mobileNo, String pinCode, String flat, String area, String landmark, String town, String state, String addressType)
    {
        yourAccountPage.createNewAddress(country, fullName, mobileNo, pinCode, flat, area, landmark, town, state, addressType);
    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}