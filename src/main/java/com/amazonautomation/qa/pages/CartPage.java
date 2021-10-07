package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class CartPage extends BaseClass {
    @FindBy(xpath = "//input[@name='submit.delete.C2276a563-53d1-4828-b734-682ed9997423']")
    WebElement deleteCartItem;
    @FindBy(xpath = "//div[@id='sc-active-cart']/div/div[1]/div[1]/h1")
    WebElement shoppingCart;
    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    WebElement proceedToBuy;
    @FindBy(xpath = "//div[@id=\"nav-cart-count-container\"]")
    WebElement cart;

    // PageFactory initialization
    public CartPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public String validateCartPageTitle() {
        return getDriver().getTitle();
    }
    public boolean shoppingCartLabel(){
       return shoppingCart.isDisplayed();
    }
    public OrderPlacedPage proceedToBuyItem(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(proceedToBuy));
        proceedToBuy.click();
        return new OrderPlacedPage();
    }
//    public void deleteCart() {
//        deleteCartItem.click();
//
//    }
}
