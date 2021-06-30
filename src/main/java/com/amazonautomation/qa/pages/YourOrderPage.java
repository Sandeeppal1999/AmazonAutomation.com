package com.amazonautomation.qa.pages;


import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class YourOrderPage extends BaseClass {

    @FindBy(xpath = "//h1[normalize-space()='Your Orders']")
    public WebElement yourOrdersLabel;

    @FindBy(xpath = "//select[@id=\"orderFilter\"]")
    WebElement dropDown;

    @FindBy(xpath = "//input[@id='searchOrdersInput']")
    WebElement searchBox;

    @FindBy(xpath = "//span[@id='a-autoid-0']//input[@type='submit']")
    WebElement clickOnSearchButton;

    @FindBy(xpath = "//a[normalize-space()='Buy it again']")
    WebElement clickOnBuyAgain;

    @FindBy(xpath = "//div[@class='a-row _buy-again-grid-desktop_desktopGridAsinInfoStyle_addToCartContainer__36d0J']//div[@id='atcWrapper-B01F7AX9ZA']//input[@type='submit']")
    WebElement addToCart;

    @FindBy(xpath = "//a[@id='nav-cart']")
    WebElement navCartClick;

    @FindBy(xpath = "//*[@id=\"nav-cart-count\"]")
    WebElement cartItemCount;

    // PageFactory initialization

    public YourOrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public boolean YrOrderLabel() {
        return yourOrdersLabel.isDisplayed();
    }


    public void placedOrderDropDown() {
        Select select = new Select(dropDown);
        select.selectByVisibleText("2021");
    }

    public void searchBar() {
        searchBox.sendKeys("F Gear");
        clickOnSearchButton.click();
        clickOnBuyAgain.click();
    }

    public CartPage addToCartPage() {
        searchBox.sendKeys("F Gear");
        clickOnSearchButton.click();
        clickOnBuyAgain.click();
        addToCart.click();
        navCartClick.click();
        return new CartPage();
    }

    public CartPage navigateCartPage() {

        navCartClick.click();

        return new CartPage();

    }

    public String noOfItemInCart() {
        return cartItemCount.getText();
    }


}
