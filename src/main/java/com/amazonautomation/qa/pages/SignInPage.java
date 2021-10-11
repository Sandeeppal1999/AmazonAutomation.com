package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class SignInPage extends BaseClass {
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    @CacheLookup
    WebElement accountList;
    @FindBy(xpath = "//div[@id=\"nav-flyout-ya-signin\"]/a/span")
    @CacheLookup
    WebElement signInLink;
    @FindBy(xpath = "//h1[normalize-space()='Sign-In']")
    @CacheLookup
    WebElement signInLabel;
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
    @FindBy(id="createAccountSubmit")
    WebElement createYourAmazonAccount;
    @FindBy(xpath = "//i[@aria-label='Amazon']")
    WebElement amazonLogoSignIn;
    @FindBy(xpath = "//span[@class='navFooterBackToTopText']")
    WebElement scrollTillBackToTop;
    @FindBy(xpath = "//li[@class='a-carousel-card']")
    List<WebElement> carousel;
    @FindBy(xpath = "//i[@class='a-icon a-icon-previous-rounded']")
    WebElement carouselButton;
    @FindBy(xpath = "//i[@class='a-icon a-icon-expand']")
    WebElement needHelpIcon;
    @FindBy(id="auth-fpp-link-bottom")
    WebElement forgotPassword;

    // PageFactory initialization
    public SignInPage() {
        PageFactory.initElements(getDriver(), this);
    }
    //Method of Testcase
    public void commonCodeSignPage(){
        Actions action = new Actions(getDriver());
        action.moveToElement(accountList).perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(signInLink));
        signInLink.click();
    }
    public boolean signInLabel()  {
        commonCodeSignPage();
        return signInLabel.isDisplayed();
    }
    public void navigateSignInPage() {
        commonCodeSignPage();
    }
    public HomePage userLogin(String un, String pwd) {
        commonCodeSignPage();
        username.sendKeys(un);
        clickOnContinue.click();
        password.sendKeys(pwd);
        clickOnSignInSubmit.click();
        return new HomePage();
    }
    public void createYourNewAmazonAccount(){
        commonCodeSignPage();
        createYourAmazonAccount.click();
    }
    public boolean  signLogoAmazon(){
        commonCodeSignPage();
        return amazonLogoSignIn.isDisplayed();
    }
    public void scrollDownHomePage() {
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", scrollTillBackToTop);
        js.executeScript("scroll(0, -250);");

    }
    public void  noOfCarousel() {
        System.out.println("No of Carousel:-"+carousel.size());
    }
    public void carouselClickable() {
        int click=0;
        for (int i = 0; i <=carousel.size(); i++) {
            carouselButton.click();
            click++;
        }
        System.out.println("No of Click:-"+click);
    }
    public void needHelp(){
        commonCodeSignPage();
        needHelpIcon.click();
    }
    public void needHelp_ForgotPassword(){
        commonCodeSignPage();
        if(needHelpIcon.isEnabled()){
            needHelpIcon.click();
            forgotPassword.click();
        }
        else{
            System.out.println("-->NeedHelp element is not clickable;-");
        }
    }
}
