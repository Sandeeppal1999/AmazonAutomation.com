package com.amazonautomation.qa.pages;
import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.support.PageFactory;
public class OrderPlacedPage extends BaseClass {
    public OrderPlacedPage() {
        PageFactory.initElements(getDriver(), this);
    }
    public String getTitleOrderPlacedPage(){
        return getDriver().getTitle();
    }
}
