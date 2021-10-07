package com.amazonautomation.qa.testcase;

import com.amazonautomation.qa.base.BaseClass;
import com.amazonautomation.qa.pages.AmazonPayPage;
import com.amazonautomation.qa.pages.HomePage;
import com.amazonautomation.qa.pages.SignInPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AmazonPayPageTest extends BaseClass {
    HomePage homePage;
    SignInPage signInPage;
    AmazonPayPage amazonPayPage;
    public AmazonPayPageTest() {
        super();
    }
    @BeforeMethod
    public void setUp() {
        initialization();
        homePage = new HomePage();
        signInPage=new SignInPage();
        homePage= signInPage.userLogin(prop.getProperty("username"), prop.getProperty("password"));
        amazonPayPage= homePage.clickOnAmazonPay();
    }
    @Test
    public void addMoneyClickable(){
        amazonPayPage.clickOnAddMoney();
    }
    @Test
    public void verifyAddMoneyLimit(){
        amazonPayPage.addMoneyLimit();

    }
    @AfterMethod
    public void tearDown() {
        getDriver().quit();
        unload();
    }
}
