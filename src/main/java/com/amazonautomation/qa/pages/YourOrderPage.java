package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
public class YourOrderPage extends BaseClass {
    // web Locators
    @FindBy(xpath = "//div[@id=\"nav-flyout-ya-signin\"]/a/span")
    @CacheLookup
    WebElement signInLink;
    @FindBy(id = "ap_email")
    @CacheLookup
    WebElement username;
    @FindBy(id = "continue")
    @CacheLookup
    WebElement clickOnContinue;
    @FindBy(id = "ap_password")
    @CacheLookup
    WebElement password;
    @FindBy(id = "signInSubmit")
    @CacheLookup
    WebElement clickOnSignInSubmit;
    @FindBy(xpath = "//*[@id=\"nav-link-accountList\"]/span/span")
    @CacheLookup
    WebElement accountList;
    @FindBy(xpath = "//span[normalize-space()='Account & Lists']//span[@class='nav-icon nav-arrow']")
    WebElement getAccountList;
    @FindBy(xpath = "//a[@id=\"nav_prefetch_yourorders\"]/span")
    WebElement yourOrder;
    @FindBy(xpath = "//h1[normalize-space()='Your Orders']")
    WebElement yourOrdersLabel;
    @FindBy(xpath ="//select[@id='orderFilter']")
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
    @FindBy(xpath = "//div[@class='a-row _buy-again-grid-desktop_desktopGridAsinInfoStyle_atcMessageRow__115V3']//div[@id='atcMessage-B01F7AX9ZA']//div[@class='a-alert-content'][normalize-space()='Added']")
    WebElement proAddedToCart;
    @FindBy(xpath = "//a[@href=\"/gp/cart/view.html?ref_=ewc_gtc\"]")
    WebElement gotoCart;
    @FindBy(xpath = "//input[@aria-label=\"Delete F Gear Luxur Brown 25 Liter Laptop Backpack (2404)\"]")
    WebElement deleteAddedPro;
    @FindBy(xpath = "//body/div[@id='a-page']/div[@class='a-container sc-background-dark']/div[@id='content']/div[@id='sc-retail-cart-container']/div[@class='a-fixed-right-grid-inner']/div[@class='a-fixed-right-grid-col sc-retail-cart-column-spacing a-col-left']/div[@id='sc-active-cart']/div[@class='a-cardui-body']/form[@id='activeCartViewForm']/div[@class='a-section a-spacing-mini sc-list-body sc-java-remote-feature']/div[@id='sc-item-C1b431be4-5d92-4fe3-add6-f31f8dde9665']/div[@class='sc-list-item-removed-msg']/div[1]/span[1]")
    WebElement messageProDelete;

    // PageFactory initialization
    public YourOrderPage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String yourOrderPageTitle(){
         return getDriver().getTitle();
    }
    public boolean YourOrderLabel() {
        return yourOrdersLabel.isDisplayed();
    }
    public void placedOrderDropDown() {
        Select select = new Select(dropDown);
        select.selectByVisibleText("2020");
    }
    public void searchOrderedProduct() {
        searchBox.sendKeys(prop.getProperty("yourPlacedOrderSearch"));
        clickOnSearchButton.click();
    }
    public void  buyAgain() {
        searchBox.sendKeys(prop.getProperty("yourPlacedOrderSearch"));
        clickOnSearchButton.click();
        clickOnBuyAgain.click();
    }
    public boolean addToCartSearchPro() {
        searchBox.sendKeys(prop.getProperty("yourPlacedOrderSearch"));
        clickOnSearchButton.click();
        clickOnBuyAgain.click();
        addToCart.click();
        return proAddedToCart.isDisplayed();
    }
    public void cleanMethod(){
        searchBox.sendKeys(prop.getProperty("yourPlacedOrderSearch"));
        clickOnSearchButton.click();
        clickOnBuyAgain.click();
        addToCart.click();
//       proAddedToCart.isDisplayed();
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(gotoCart));
        gotoCart.click();
        new WebDriverWait(getDriver(), Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(deleteAddedPro));
        deleteAddedPro.click();
//        return messageProDelete.isDisplayed();
    }
    public CartPage navigateCartPage() {
        navCartClick.click();
        return new CartPage();
    }
    public String noOfItemInCart() {
        return cartItemCount.getText();
    }

}
