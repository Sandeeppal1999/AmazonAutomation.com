package com.amazonautomation.qa.testcase;

import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.HomePage;
import com.amazonautomation.qa.pages.SignInPage;
import com.amazonautomation.qa.pages.YourAccountPage;
import com.amazonautomation.qa.utilties.TestUtil;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class YourAccountPageTest extends BaseClass {
    SignInPage signInPage;
    HomePage homePage;
    YourAccountPage yrAccountPage;
    TestUtil testUtil;

    public YourAccountPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        signInPage = new SignInPage();
        homePage = new HomePage();
        testUtil = new TestUtil();
        homePage = signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        yrAccountPage = homePage.clickOnYourAccount();
    }

    @Test
    public void navigateToAddressLink() {
        yrAccountPage.navigateToAddress();
    }

    @Test
    public void verifyAddNewAddress() {
        yrAccountPage.navigateToAddress();
        yrAccountPage.addNewAddress();
    }

    @DataProvider(name = "getAmazonTestData")
    public Object[][] getAmazonTestData() {
        Object[][] data = TestUtil.getTestData_AddNewAddress();
        return data;
    }

    @Test(dataProvider = "getAmazonTestData")
    public void createNewADDTest(String country, String fullname, String mobilenumber, String pincode, String flat, String area, String landmark, String town, String state, String addresstype) throws InterruptedException {
        yrAccountPage.navigateToAddress();
        yrAccountPage.addNewAddress();
        yrAccountPage.createNewAddress(country, fullname, mobilenumber, pincode, flat, area, landmark, town, state, addresstype);
    }

    //After method
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }

}


