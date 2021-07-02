package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class SignInPage extends BaseClass {

    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement accountList;
    @FindBy(xpath = "//div[@id=\"nav-flyout-ya-signin\"]/a/span")
    WebElement signInLink;
    @FindBy(xpath = "//h1[normalize-space()='Sign-In']")
    WebElement signInLabel;
    @FindBy(id = "nav-link-accountList-nav-line-1")
    WebElement clickOnSign;
    @FindBy(id = "ap_email")
    WebElement username;
    @FindBy(id = "continue")
    WebElement clickOnContinue;
    @FindBy(id = "ap_password")
    WebElement password;
    @FindBy(id = "signInSubmit")
    WebElement clickOnSignInSubmit;

    // PageFactory initialization
     public SignInPage() {
       PageFactory.initElements(driver, this);
    }

    //Method of Testcase
    public boolean signInLabel() {
        Actions action = new Actions(getDriver());
        action.moveToElement(accountList).build().perform();
        signInLink.click();
        return signInLabel.isDisplayed();
    }

    public void navigateSignInPage() {
        Actions action = new Actions(getDriver());
        action.moveToElement(accountList).build().perform();
        signInLink.click();
    }

    public HomePage userLogin(String un, String pwd) {
        Actions action = new Actions(getDriver());
        action.moveToElement(accountList).build().perform();
        signInLink.click();
        username.sendKeys(un);
        clickOnContinue.click();
        password.sendKeys(pwd);
        clickOnSignInSubmit.click();
        return new HomePage();
    }
}
