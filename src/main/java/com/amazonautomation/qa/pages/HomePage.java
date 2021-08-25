package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
//HomepageClass
public class HomePage extends BaseClass {
    @FindBy(xpath = "//span[contains(text(),'Hello, manish')]")
    WebElement helloUserName;
    @FindBy(linkText = "Amazon Pay")
    WebElement amazonPay;
    @FindBy(xpath = "//h2[contains(text(),'Hi, manish')]")
    WebElement hiUserName;
    @FindBy(xpath = "//p[contains(text(),'Customer since 2019')]")
    WebElement durationLoggedUser;
    @FindBy(xpath = "//span[normalize-space()='Your Orders']")
    WebElement yourOrder;
    @FindBy(xpath = "//span[@id='nav-link-accountList-nav-line-1']")
    WebElement accountlist;
    @FindBy(xpath = "//span[normalize-space()='Your Account']")
    WebElement yourAccount;
    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    WebElement searchTextBox;
    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    WebElement searchTextBoxicon;
    @FindBy(xpath = "//span[contains(text(),'25% Off or more')]")
    WebElement discountOff25;
    @FindBy(xpath = "//*[@id=\"p_n_is_cod_eligible/4931671031\"]/span/a/div/label/i")
    WebElement eligibleForPayOnDel;
    @FindBy(xpath = "//li[@id='p_n_availability/1318485031']//i[@class='a-icon a-icon-checkbox']")
    WebElement includeOutOfStock;
    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    WebElement amazonLogo;
    @FindBy(xpath = "//div[@data-component-type='s-search-result']")
    List<WebElement> listOfSearchItem;
    @FindBy(xpath = "//div[@class='sg-col-4-of-12 s-result-item s-asin sg-col-4-of-16 AdHolder sg-col sg-col-4-of-20' ]")
    List<WebElement> listOfSearchItemHorizontalSpo;
    @FindBy(xpath = "//div[@class='s-result-item s-asin sg-col-0-of-12 sg-col-16-of-20 AdHolder sg-col sg-col-12-of-16' ]")
    List<WebElement> listOfSearchItemVerticalSpo;
    @FindBy(xpath = "//span[normalize-space()='Account & Lists']//span[@class='nav-icon nav-arrow']")
    WebElement getAccountList;

    // PageFactory initialization
    public HomePage() {
        PageFactory.initElements(getDriver(), this);
    }
    //Homepage Method

    public String homePageTitle() {
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.titleIs("Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in"));
        return getDriver().getTitle();
    }
    public boolean helloUserNameVisible() {
        return helloUserName.isDisplayed();
    }
    public boolean hiUserNameVisible() {
        return hiUserName.isDisplayed();
    }
    public boolean loggedUserDuration() {
        return durationLoggedUser.isDisplayed();
    }
    public void clickOnAmazonPay() {
        amazonPay.click();
    }
    public void clickOnYourOrderPage() {
        Actions action = new Actions(getDriver());
        action.moveToElement(accountlist).build().perform();
        yourOrder.click();
    }
    public void clickOnYourAccount() {
        Actions action = new Actions(getDriver());
        action.moveToElement(accountlist).build().perform();
        yourAccount.click();
    }

    public void searchItem() {
        searchTextBox.click();
        searchTextBox.sendKeys(prop.getProperty("searchText"));
        searchTextBoxicon.click();
    }
    public void listOfSponsoredSearchItem(){
        searchTextBox.click();
        searchTextBox.sendKeys(prop.getProperty("searchText"));
        searchTextBoxicon.click();

        if(listOfSearchItemHorizontalSpo.size()!=0)
        {   Integer sizeOfList = listOfSearchItemHorizontalSpo.size();
            System.out.println("<-----No of Searched item found:-" + sizeOfList);
            List<WebElement> list=listOfSearchItemHorizontalSpo;
            for (int i = 1; i <list.size() ; i++)
            {
                System.out.println("<----------------------------------------------------------------------------------------------------------------------->");
                WebElement element=list.get(i);
                String textPro= element.getText();
                System.out.println("->"+i+" Product of List:"+"\n" +"Name of Product:-"+textPro);
            }
        }
        else {Integer sizeOfList = listOfSearchItemVerticalSpo.size();
            System.out.println("<-----No of Searched item found:-" + sizeOfList);
            List<WebElement> list=listOfSearchItemVerticalSpo;
            for (int i = 1; i <list.size() ; i++)
            {
                System.out.println("<----------------------------------------------------------------------------------------------------------------------->");
                WebElement element=list.get(i);
                String textPro= element.getText();
                System.out.println("->"+i+" Product of List:"+"\n" +"Name of Product:-"+textPro);
            }
        }
    }
    public void listOfSearchItem(){
        searchTextBox.click();
        searchTextBox.sendKeys(prop.getProperty("searchText"));
        searchTextBoxicon.click();
            Integer sizeOfList = listOfSearchItem.size();
            System.out.println("<-----No of Searched item found:-" + sizeOfList);
            List<WebElement> list=listOfSearchItem;
            for (int i = 1; i <list.size() ; i++)
           {
               System.out.println("<----------------------------------------------------------------------------------------------------------------------->");
               WebElement element=list.get(i);
               String textPro= element.getText();
               System.out.println("->"+i+" Product of List:"+"\n" +"Name of Product:-"+textPro);
           }
    }
    public void discount25perOrMore() {
        searchTextBox.click();
        searchTextBox.sendKeys(prop.getProperty("searchText"));
        searchTextBoxicon.click();
        discountOff25.click();
        Integer sizeOfList = listOfSearchItem.size();
        System.out.println("<-----No of Searched item found:-" + sizeOfList);
        List<WebElement> list=listOfSearchItem;
        for (int i = 1; i <list.size() ; i++)
        {
            System.out.println("<----------------------------------------------------------------------------------------------------------------------->");
            WebElement element=list.get(i);
            String textPro= element.getText();
            System.out.println("->"+i+" Product of List:"+"\n" +"Name of Product:-"+textPro);
        }
    }
    public void selectCheckBoxPayOnDeliveryOutOfStock() {
        searchTextBox.click();
        searchTextBox.sendKeys(prop.getProperty("searchText"));
        searchTextBoxicon.click();
        discountOff25.click();
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
    public void fetchNthProduct() {
        searchTextBox.click();
        searchTextBox.sendKeys(prop.getProperty("searchText"));
        searchTextBoxicon.click();
        List<WebElement> list=listOfSearchItem;
        String nthPro=prop.getProperty("nthProduct");
        int num = Integer.parseInt(nthPro);
        for (int i = 1; i < list.size(); i++) {
            if(i==num)
            {
                WebElement element = list.get(i);
                element.click();
                String textPro = element.getText();
                System.out.println("-->" + i + " Product of List:--->" + textPro);
            }
            
        }
    }
    public ProductDetailsPage fetchItemDetails()  {
        searchTextBox.click();
        searchTextBox.sendKeys(prop.getProperty("searchText"));
        searchTextBoxicon.click();
        List<WebElement> list=listOfSearchItem;
        String nthPro=prop.getProperty("nthProduct");
        int num = Integer.parseInt(nthPro);
        for (int i = 1; i < list.size(); i++) {
            if(i==num) {
                WebElement element = list.get(i);
                String textPro = element.getText();
                System.out.println("-->" + i + " Product of List:--->" + textPro);
                element.click();
               // String parentWin=getDriver().getWindowHandle();
                for(String winHandle:getDriver().getWindowHandles()){
                  getDriver().switchTo().window(winHandle);
                }
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return new ProductDetailsPage();
            }
        }
        return null;
    }
    public boolean amazonLogoImage() {
        return amazonLogo.isDisplayed();
    }
    public void countNoOfLinkOnHomePage() {
        List<WebElement> link = getDriver().findElements(By.tagName("a"));
        System.out.println("No of Link on Login Page:" + link.size());
    }
    public  YourAccountPage navigateYourAccountPage(){
        Actions action1= new Actions(getDriver());
        action1.moveToElement(getAccountList).perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(yourAccount));
        yourAccount.click();
        return new YourAccountPage();
    }
    public YourOrderPage navigateYourOrderPage() {
        Actions action1 = new Actions(getDriver());
        action1.moveToElement(getAccountList).perform();
        new WebDriverWait(getDriver(), Duration.ofSeconds(3)).until(ExpectedConditions.elementToBeClickable(yourOrder));
        yourOrder.click();
        return new YourOrderPage();
    }
}
