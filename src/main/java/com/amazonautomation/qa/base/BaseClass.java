package com.amazonautomation.qa.base;

import com.amazonautomation.qa.utilties.TestUtil;
import com.amazonautomation.qa.utilties.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


public class BaseClass {
    public static WebDriver driver;
    public static Properties prop;
    public static ThreadLocal<WebDriver> dr = new ThreadLocal<WebDriver>();

    public BaseClass() {
        String projectPath = System.getProperty("user.dir");
        try {
            prop = new Properties();
            FileInputStream ip = new FileInputStream(projectPath + "/src/main/java/com/amazonautomation/qa/configuration/config.properties");
            prop.load(ip);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static WebDriver getDriver() {
        return dr.get();
    }

    public static void setDriver(WebDriver driverref) {
        dr.set(driverref);
    }

    public static void unload() {
        dr.remove();
    }

    public static void initialization() {
        String browserName = prop.getProperty("browser");
        if (browserName.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            setDriver(driver);
        } else if (browserName.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            setDriver(driver);
        } else if (browserName.equals("ie")) {
            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
            setDriver(driver);
        } else if (browserName.equals("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            setDriver(driver);
        }
        EventFiringWebDriver eventDriver = new EventFiringWebDriver(getDriver());
        WebEventListener handler = new WebEventListener();
        eventDriver.register(handler);
        driver = eventDriver;
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
        driver.get(prop.getProperty("url"));

    }
}
