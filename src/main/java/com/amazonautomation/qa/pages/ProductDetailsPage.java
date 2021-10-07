package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
public class ProductDetailsPage extends BaseClass {
    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    WebElement addToCart;
    @FindBy(xpath = "//a[@id='breadcrumb-back-link']")
    WebElement backTOResult;
    @FindBy(xpath = "//span[@class='a-list-item']/a[@id='breadcrumb-back-link']")
    WebElement aboutThisItem;
    @FindBy(xpath = "//span[@class='a-button a-button-thumbnail a-button-toggle']")
    List<WebElement> listOfProImage;
    @FindBy(xpath = "//input[@id='buy-now-button']")
    WebElement buyNow;
    @FindBy(xpath = "//div[@id=\"technicalSpecifications_feature_div\"]/h2")
    WebElement scrollDown_ProductSpecification;
    @FindBy(xpath = "//h1[contains(text(),'Added to Cart')]")
    WebElement addedToCart;
    @FindBy(xpath = "//a[@id='hlb-view-cart-announce']")
    WebElement cart;
    //page factory
    public ProductDetailsPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public void validateProductImage(){
        Integer noOFProImage= listOfProImage.size();
        System.out.println("->No of Image on Product Details:-"+noOFProImage);
//        List<WebElement> image=listOfProImage;
//        for (int i = 1; i <image.size() ; i++) {
//            WebElement proImage=image.get(i);
//            new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(proImage));
//            proImage.click();
//
//        }
    }
    public boolean validateAboutThisItem(){
    new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(aboutThisItem));
    return aboutThisItem.isDisplayed();
}
    public void addToCartItem(){
           new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(addToCart));
          addToCart.click();
    }
    public boolean validatedItemAddedToCart(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        boolean b= addedToCart.isDisplayed();
        System.out.println("-->Product Successfully Added to Cart:-"+b);
        return b;
    }
    public CartPage navigateToCartPage(){
        new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(addToCart));
        addToCart.click();
        boolean b= addedToCart.isDisplayed();
        if(b==true){
            System.out.println("-->Product Successfully Added to Cart:-"+b);
            cart.click();
            System.out.println("-->NavigateTo CartPage Successfully:-");
        }
        else{
            System.out.println("-->Product Not Added to Cart:-"+b);
        }
        return new CartPage();
    }
    public boolean backToResult(){
          new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(backTOResult));
          return  backTOResult.isDisplayed();
    }
    public void validateBuyNow()
    {  new WebDriverWait(getDriver(), Duration.ofSeconds(2)).until(ExpectedConditions.elementToBeClickable(buyNow));
        buyNow.click();
    }
    public void scrollDownProductSpecification(){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].scrollIntoView();", scrollDown_ProductSpecification);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}