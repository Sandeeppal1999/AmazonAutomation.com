package com.amazonautomation.qa.pages;

import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
public class AmazonPayPage extends BaseClass {
    @FindBy(xpath = "//span[contains(text(),'Add Money')]")
    WebElement addMoney;
    @FindBy(xpath = "//div[@id='AddMoney']//img")
    WebElement addMoneyIcon;
    @FindBy(xpath = "//div[@class='a-section a-spacing-medium a-padding-none a-text-right']")
    WebElement addMoneyLimitText;
    @FindBy(xpath = "//div[@class='a-section slot-body-margin-desktop-new']")
    WebElement amazonPayService;
    public AmazonPayPage() { PageFactory.initElements(getDriver(), this);
    }
    public void clickOnAddMoney(){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(addMoneyIcon.isDisplayed());
        addMoney.click();
        softAssert.assertEquals(driver.getTitle(),"Add Money");
        softAssert.assertAll();
    }
    public void addMoneyLimit(){
        addMoney.click();
        String limit=addMoneyLimitText.getText();
        Assert.assertTrue(addMoneyLimitText.isDisplayed());
        Assert.assertEquals(limit,"You can add upto ₹10000.00");
    }
    public void setAmazonPayService(){
        // need to implement the method with the collection and data structure.
    }
}
