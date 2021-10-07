package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.Iterator;
import java.util.Set;

//Your AccountPage
public class YourAccountPage extends BaseClass {
    @FindBy(xpath = "//h1[normalize-space()='Your Account']")
    WebElement yrAccountLabel;
    @FindBy(xpath = "//div[@data-card-identifier='YourOrders']")
    WebElement yourOrder;
    @FindBy(xpath = "//h2[normalize-space()='Your Addresses']")
    WebElement yourAddress;
    @FindBy(xpath = "//h1[@class='a-spacing-medium']")
    WebElement yourAddressesLabel;
    @FindBy(xpath = "//div[@id=\"ya-myab-plus-address-icon\"]")
    WebElement clickOnADDAddress;
    @FindBy(xpath = "//select[@id=\"address-ui-widgets-countryCode-dropdown-nativeId\"]")
    WebElement dropDownCountry;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressFullName']")
    WebElement full_Name;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPhoneNumber']")
    WebElement mobile_No;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressPostalCode']")
    WebElement pinCode_No;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine1']")
    WebElement flat_ADDLine1;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressLine2']")
    WebElement area_ADDLine2;
    @FindBy(xpath = "//input[@id='address-ui-widgets-landmark']")
    WebElement landMarkEntry;
    @FindBy(xpath = "//input[@id='address-ui-widgets-enterAddressCity']")
    WebElement town_City;
    @FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressStateOrRegion-dropdown-nativeId\"]")
    WebElement dropDown_state;
    @FindBy(xpath = "//*[@id=\"address-ui-widgets-enterAddressFormContainer\"]/div[2]/div[4]/span/select")
    WebElement address_Type;
    @FindBy(xpath = "//*[@id=\"address-ui-widgets-form-submit-button\"]/span/input")
    WebElement addAddress;
    @FindBy(xpath = "//select[@id='address-ui-widgets-countryCode-dropdown-nativeId']")
    WebElement dropIsSelected;
    @FindBy(xpath = "//div[@id='yaab-alert-box']/div/h4")
    WebElement addedAddressLabel;

    @FindBy(xpath = "//*[@id=\"ya-myab-address-delete-btn-1\"]")
    WebElement removeAddress;
    @FindBy(xpath = "//span[@id='deleteAddressModal-1-submit-btn']//input[@type='submit']")
    WebElement confirmDelete;
    // PageFactory initialization
    public YourAccountPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public  String validateYourAccountTitle(){
         return  getDriver().getTitle();
    }
    public String yourAccountLabel(){
          return yrAccountLabel.getText();
    }
    public void yourOrderNavigate(){
        yourOrder.click();
    }
    public void yourAddressNavigate() {
        yourAddress.click();
    }
    public String yourAddressesLabel(){
        yourAddress.click();
        return yourAddressesLabel.getText();
    }
    public void addNewAddress() {
        yourAddress.click();
        clickOnADDAddress.click();
    }
    public void createNewAddress(String country, String fullName, String mobileNo, String pinCode, String flat, String area, String landmark, String town, String state, String addressType)  {
        yourAddress.click();
        clickOnADDAddress.click();
        if(dropIsSelected.isSelected()){
            Select select1 = new Select(dropDownCountry);
            select1.selectByVisibleText(country);
        }
        else {
            System.out.println(country+" is not Selected By DropDown;");
        }
        full_Name.sendKeys(fullName);
        mobile_No.sendKeys(mobileNo);
        pinCode_No.sendKeys(pinCode);
        flat_ADDLine1.sendKeys(flat);
        area_ADDLine2.sendKeys(area);
        landMarkEntry.sendKeys(landmark);
        town_City.sendKeys(town);
        if(dropIsSelected.isSelected()){
            Select select = new Select(dropDown_state);
            select.selectByVisibleText(state);
        }
        else {
            System.out.println(state+" is not Selected By DropDown;");
        }
        if(dropIsSelected.isSelected()){
            Select select2 = new Select(address_Type);
            select2.selectByVisibleText(addressType);
        }
        else {
            System.out.println(addressType+" is not Selected By DropDown;");
        }
        addAddress.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
       boolean b= addedAddressLabel.isDisplayed();
        System.out.println("-->New Address is Added Successfully "+b);
        removeAddress.click();
        String parentWindow=getDriver().getWindowHandle();
        Set<String> allWin=getDriver().getWindowHandles();
        for (String childWin:allWin) {
            if(!parentWindow.equalsIgnoreCase(childWin)){
                getDriver().switchTo().window(childWin);
                System.out.println("ChildWindow:-"+childWin);
                confirmDelete.click();
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                getDriver().close();
            }
        }
        getDriver().switchTo().window("ParentWindow"+parentWindow);
    }
}
