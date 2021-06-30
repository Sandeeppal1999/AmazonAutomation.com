package com.amazonautomation.qa.pages;

import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class HomePage extends BaseClass {

    @FindBy(xpath = "//span[contains(text(),'Hello, manish')]")
    WebElement loggedUserName;

    @FindBy(linkText = "Amazon Pay")
    WebElement amazonPay;

    @FindBy(xpath = "//h2[contains(text(),'Hi, manish')]")
    WebElement usernameTxt;

    @FindBy(xpath = "//p[contains(text(),'Customer since 2019')]")
    WebElement durationLoggedUser;

    @FindBy(xpath = "//span[normalize-space()='Your Orders']")
    WebElement yourOrder;

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement accountlist;
    @FindBy(xpath = "//span[normalize-space()='Your Account']")
    WebElement yourAccount;

    @FindBy(xpath = "//*[@id=\"gw-desktop-herotator\"]/div/div/div/div[1]/a/i")
    WebElement slideIcon;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchTextBox;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchTextBoxicon;

    @FindBy(xpath = "//span[contains(text(),'50% Off or more')]")
    WebElement off50;

    @FindBy(xpath = "//*[@id=\"p_n_is_cod_eligible/4931671031\"]/span/a/div/label/i")
    WebElement eligibleForPayOnDel;

    @FindBy(xpath = "//li[@id='p_n_availability/1318485031']//i[@class='a-icon a-icon-checkbox']")
    WebElement includeOutOfStock;

    @FindBy(xpath = "//*[@id=\"p_n_pct-off-with-tax-title\"]/span")
    WebElement scrollTextCheckBox;

    @FindBy(xpath = "//span[@class='a-size-medium a-color-base a-text-normal'][normalize-space()='Redmi 9 (Sky Blue, 4GB RAM, 64GB Storage)| 5000 mAh| 2.3GHz Mediatek Helio G35 Octa core Processor']")
    WebElement redmi9;

    @FindBy(xpath = "//*[@id=\"submit.add-to-cart\"]")
    WebElement addToCart;
    @FindBy(xpath = "//*[@id=\"attach-sidesheet-view-cart-button\"]/span/input")
    WebElement navigateCart;
    @FindBy(xpath = "//img[@alt='Your language is live']")
    WebElement scrollAmazonInYrLang;
    @FindBy(xpath = "//span[@class='navFooterBackToTopText']")
    WebElement backToTopslider;
    @FindBy(xpath = "//i[@class='a-icon a-icon-previous-rounded']")
    WebElement carouselButton;
    @FindBy(xpath = "//div[@class='a-section feed-carousel first-carousel hovering']//span[@class='feed-scrollbar-thumb']")
    WebElement dealScroller;
    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    WebElement amazonLogo;

    // PageFactory initialization
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }

    public String verifyHomepageTitle() {
        return getDriver().getTitle();
    }

    public boolean loggedUserName() {
        boolean logged = loggedUserName.isDisplayed();
        return logged;
    }

    public boolean userNameVisible() {
        return usernameTxt.isDisplayed();
    }

    public boolean loggedUserDuration() {
        return durationLoggedUser.isDisplayed();
    }

    public void clickOnAmazonPay() {
        amazonPay.click();
    }

    public YourOrderPage clickOnYourOrderPage() {
        Actions action = new Actions(getDriver());
        action.moveToElement(accountlist).build().perform();
        yourOrder.click();
        return new YourOrderPage();
    }

    public YourAccountPage clickOnYourAccount() {
        Actions action = new Actions(getDriver()); // action class is used to mouse movement drag and drop right click.
        action.moveToElement(accountlist).build().perform();
        yourAccount.click();
        return new YourAccountPage();
    }

    public void countSlide() {
        slideIcon.click();
    }

    public void searchItem() {
        searchTextBox.click();
        searchTextBox.sendKeys(prop.getProperty("searchText"));
        searchTextBoxicon.click();
    }

    public void off50OrMore() {
        off50.click();
    }

    public void checkboxPayOrstock() {
        if (eligibleForPayOnDel.isSelected()) {
            System.out.println("CheckBox is Already selected");
        } else {
            eligibleForPayOnDel.click();
        }
        if (includeOutOfStock.isSelected()) {
            System.out.println("CheckBox is Already selected");
        } else {
            includeOutOfStock.click();
        }
    }

    public String filteredSearchItem() {
        return redmi9.getText().toString();
    }

    public void redmi9NewTab() {
        redmi9.click();

        Set<String> parentTab = getDriver().getWindowHandles();
        Iterator<String> itr = parentTab.iterator();
        String mainWindow = itr.next();
        String childWindow = itr.next();
        getDriver().switchTo().window(childWindow);
        System.out.println("Title of child window" + getDriver().getTitle());
        //driver.close();

        //driver.switchTo().window(mainWindow);
        //System.out.println("Title of child window"+driver.getTitle());
    }

    public CartPage addTocartItem() {
        addToCart.click();
        return new CartPage();
    }

    public CartPage navigateCart() {
        navigateCart.click();
        return new CartPage();
    }

    public void scrollDownHomePage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", scrollAmazonInYrLang);
    }

    public void backToTop() {
        backToTopslider.click();
    }

    public void noOfCarousel() {
        for (int i = 0; i < 8; i++) {
            carouselButton.click();
        }
    }

    public void todayDealsSlider() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("window.scrollBy(0,1000)");

        Actions action = new Actions(getDriver());
        action.moveToElement(dealScroller).build().perform();
        action.click();
        Actions moveSlider = new Actions(getDriver());
        moveSlider.dragAndDropBy(dealScroller, 790, 0).build().perform();

    }

    public boolean amazonLogoImage() {
        return amazonLogo.isDisplayed();
    }

    public void countNoOfLinkOnHomePage() {
        List<WebElement> link = getDriver().findElements(By.tagName("a"));
        System.out.println("No of Link on Login Page:" + link.size());
    }

    public String homePageTitle() {
        return getDriver().getTitle();
    }

}
