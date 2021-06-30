package com.amazonautomation.qa.pages;

import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YourAccountPage extends BaseClass {

    @FindBy(xpath = "//h2[normalize-space()='Your Addresses']")
    WebElement clickOnAddress;

    @FindBy(xpath = "//div[@id=\"ya-myab-plus-address-icon\"]")
    WebElement clickOnADDAddress;

    @FindBy(xpath = "//select[@id=\"address-ui-widgets-countryCode-dropdown-nativeId\"]")
    WebElement dropDown_Country;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    WebElement fullName;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    WebElement mobileNo;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
    WebElement pincodeno;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    WebElement flat_ADDLine1;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
    WebElement area_ADDLine2;

    @FindBy(xpath = "//input[@id='address-ui-widgets-landmark']")
    WebElement landmarkentry;

    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
    WebElement town_City;

    @FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId\"]")
    WebElement dropDown_state;

    @FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[2]/div[4]/span/select")
    WebElement addressType;

    @FindBy(xpath = "//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")
    WebElement addAddress;

    // PageFactory initialization
    public YourAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public void navigateToAddress() {
        clickOnAddress.click();
    }

    public void addNewAddress() {
        clickOnADDAddress.click();
    }

    public void createNewAddress(String country, String fullname, String mobilenumber, String pincode, String flat, String area, String landmark, String town, String state, String addresstype) throws InterruptedException {
        Select select1 = new Select(dropDown_Country);
        select1.selectByVisibleText(country);
        fullName.sendKeys(fullname);
        mobileNo.sendKeys(mobilenumber);
        pincodeno.sendKeys(pincode);
        flat_ADDLine1.sendKeys(flat);
        area_ADDLine2.sendKeys(area);
        landmarkentry.sendKeys(landmark);
        town_City.sendKeys(town);
        Thread.sleep(100);
        Select select = new Select(dropDown_state);
        select.selectByVisibleText(state);
        Select select2 = new Select(addressType);
        select2.selectByVisibleText(addresstype);
        Thread.sleep(1000);
        addAddress.click();
    }
}
