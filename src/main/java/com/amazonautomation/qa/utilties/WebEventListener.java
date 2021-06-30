package com.amazonautomation.qa.utilties;

import com.amazonautomation.qa.base.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

public class WebEventListener extends BaseClass implements WebDriverEventListener {
    @Override
    public void beforeAlertAccept(WebDriver driver) {
        System.out.println("Before Alert Accept:-");

    }

    @Override
    public void afterAlertAccept(WebDriver driver) {
        System.out.println("After Alert Accept:-");

    }

    @Override
    public void afterAlertDismiss(WebDriver driver) {
        System.out.println("After Alert Dismiss:-");

    }

    @Override
    public void beforeAlertDismiss(WebDriver driver) {
        System.out.println("Before Alert Dismiss:-");
    }

    @Override
    public void beforeNavigateTo(String url, WebDriver driver) {
        System.out.println("Before navigating to: '" + url + "'");
    }

    @Override
    public void afterNavigateTo(String url, WebDriver driver) {
        System.out.println("Navigated to:'" + url + "'");

    }

    @Override
    public void beforeNavigateBack(WebDriver driver) {
        System.out.println(" Before Navigating back to previous page");
    }

    @Override
    public void afterNavigateBack(WebDriver driver) {
        System.out.println("After Navigated back to previous page");

    }

    @Override
    public void beforeNavigateForward(WebDriver driver) {
        System.out.println("Before Navigating forward to next page");
    }

    @Override
    public void afterNavigateForward(WebDriver driver) {
        System.out.println("After Navigated forward to next page");
    }

    @Override
    public void beforeNavigateRefresh(WebDriver driver) {
        System.out.println("Before Navigated page refresh");
    }

    @Override
    public void afterNavigateRefresh(WebDriver driver) {
        System.out.println("After Navigated page refresh");
    }

    @Override
    public void beforeFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Trying to find Element By : " + by.toString());

    }

    @Override
    public void afterFindBy(By by, WebElement element, WebDriver driver) {
        System.out.println("Found Element By : " + by.toString());

    }

    @Override
    public void beforeClickOn(WebElement element, WebDriver driver) {
        System.out.println("Trying to click on: " + element.toString());
    }

    @Override
    public void afterClickOn(WebElement element, WebDriver driver) {
        System.out.println("Clicked on: " + element.toString());
    }

    @Override
    public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Value of the:" + element.toString() + " before any changes made");
    }

    @Override
    public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
        System.out.println("Element value changed to: " + element.toString());
    }

    @Override
    public void beforeScript(String script, WebDriver driver) {

    }

    @Override
    public void afterScript(String script, WebDriver driver) {

    }

    @Override
    public void beforeSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void afterSwitchToWindow(String windowName, WebDriver driver) {

    }

    @Override
    public void onException(Throwable throwable, WebDriver driver) {

    }

    @Override
    public <X> void beforeGetScreenshotAs(OutputType<X> target) {

    }

    @Override
    public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {

    }

    @Override
    public void beforeGetText(WebElement element, WebDriver driver) {

    }

    @Override
    public void afterGetText(WebElement element, WebDriver driver, String text) {

    }
}
