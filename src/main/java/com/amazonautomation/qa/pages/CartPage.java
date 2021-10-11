package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;
import java.util.List;

public class CartPage extends BaseClass {
    @FindBy(xpath = "//input[@name='submit.delete.C2276a563-53d1-4828-b734-682ed9997423']")
    WebElement deleteCartItem;
    @FindBy(xpath = "//div[@id='sc-active-cart']/div/div[1]/div[1]/h1")
    WebElement shoppingCart;
    @FindBy(xpath = "//input[@name='proceedToRetailCheckout']")
    WebElement proceedToBuy;
    @FindBy(xpath = "//span[@id='nav-cart-count']")
    WebElement noOFItemInCart;
    @FindBy(xpath = "//h1[contains(text(),'Your Amazon Cart is empty.')]")
    WebElement emptyCartMessage;
    @FindBy(xpath = "//h1[contains(text(),'Shopping Cart')]")
    WebElement shoppingCartMessage;
    @FindBy(xpath = "//div[@data-name=\"Active Items\"]//div[starts-with(@data-asin,'B0')]")
    List<WebElement> listOfItemOnCart;
    @FindBy(xpath = "//input[@data-action=\"delete\"and  starts-with(@name,\"submit.delete.C\")]")
    List<WebElement> delete;

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
    public void checkCartCount(){
    String item=noOFItemInCart.getText();
        int count = Integer.parseInt(item);
        if(count==0){
            Assert.assertTrue(emptyCartMessage.isDisplayed());
            String message=emptyCartMessage.getText();
            Assert.assertEquals(message,"Your Amazon Cart is empty.");
            System.out.println("No item in the Cart:-"+ item +" ->"+message);
        }
        else{
            Assert.assertTrue(shoppingCartMessage.isDisplayed());
            String message=shoppingCartMessage.getText();
            Assert.assertEquals(message,"Shopping Cart");
            System.out.println("No item in the Cart:-"+ item);
        }
    }
    public void cartCountEqCartSize(){
        String item=noOFItemInCart.getText();
        int count = Integer.parseInt(item);
        if(count==0){
            Assert.assertTrue(emptyCartMessage.isDisplayed());
            String message=emptyCartMessage.getText();
            Assert.assertEquals(message,"Your Amazon Cart is empty.");
            System.out.println("No item in the Cart:-"+ item +" ->"+message);
        }
        else{
            int list=  listOfItemOnCart.size();
            if(list==count){
                for(int i=0;i<list;i++){
                    WebElement ele=listOfItemOnCart.get(i);
                    String text=ele.getText();
                    System.out.println(text);
                }
            }
            else
            {
                System.out.println("Your cart count is not equal to no of item in cart:-");
            }
        }
    }
    public void deleteNthCartItem() {
        String item = noOFItemInCart.getText();
        int count = Integer.parseInt(item);
        if (count == 0) {
            Assert.assertTrue(emptyCartMessage.isDisplayed());
            String message = emptyCartMessage.getText();
            Assert.assertEquals(message, "Your Amazon Cart is empty.");
            System.out.println("No item in the Cart:-" + item + " ->" + message);
        } else {
            System.out.println(delete.size());
            String nthProDel = prop.getProperty("nthProductDelete");
            int num = Integer.parseInt(nthProDel);
            if (num < delete.size()) {
                System.out.println(delete.size() + " " + count);
                for (int i = 1; delete.size() > 0; i++) {
                    if (i == num) {
                        WebElement deleteElement = delete.get(i);
                        System.out.println("Before delete-------------------------------");
                        System.out.println("i="+i+" delete- "+delete.size());
                        deleteElement.click();
                        System.out.println("After delete-------------------------------");
                        System.out.println("i="+i+" delete- "+delete.size());
                    }
//                    System.out.println("Before delete-------------------------------");
//                    System.out.println("i="+i+" delete- "+delete.size());
//
//                    System.out.println("After delete-------------------------------");
//                    System.out.println("i="+i+" delete- "+delete.size());

                }
//                    System.out.println(" -------------------------------");
            }
//                System.out.println(delete.size());
        }
    }

    public void deleteAllItemFromCart(){
        String item=noOFItemInCart.getText();
        int count = Integer.parseInt(item);
        if(count==0){
            Assert.assertTrue(emptyCartMessage.isDisplayed());
            String message=emptyCartMessage.getText();
            Assert.assertEquals(message,"Your Amazon Cart is empty.");
            System.out.println("No item in the Cart:-"+ item +" ->"+message);
        }
        else{
            int list=listOfItemOnCart.size();
            if(list==count)
            {
                for (int i = 1; i < list; i++)
                {
                    System.out.println("1");
                       int list1 = delete.size();
                      if (list1 == count) {
                        for (int j = 1; j < list1; j++) {
                            System.out.println("2");
                            WebElement deleteElement = delete.get(j);
                            deleteElement.click();
                        }
                    }
                }
            }
        }
    }


}
