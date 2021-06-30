package com.amazonautomation.qa.pages;

import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends BaseClass {
    @FindBy(xpath = "//input[@name='submit.delete.C2276a563-53d1-4828-b734-682ed9997423']")
    WebElement deleteCartItem;

    // PageFactory initialization
    public CartPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String validateCartPageTitle() {
        return getDriver().getTitle();
    }

    public void deleteCart() {
        deleteCartItem.click();

    }
}
