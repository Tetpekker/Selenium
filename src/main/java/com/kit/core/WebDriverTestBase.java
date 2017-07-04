package com.kit.core;

import com.kit.util.PropertiesCache;
import io.github.bonigarcia.wdm.ChromeDriverManager;

import java.security.cert.CertPathBuilder;
import java.util.concurrent.TimeUnit;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.apache.commons.lang3.EnumUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

public class WebDriverTestBase {

    protected WebDriver webDriver;
    //How to pass System variable to Selenium Framework
    //mvn -Dbrowser=CHROME or -Dbrowser=FF clean test - to run tests on diff browsers
    private String browser = System.getProperty("browser");
    //Loads settings from test.properties file
    private Browser FirefoxeDriverManager;
    long implicitWait = Long.parseLong(PropertiesCache.getProperty("wait.implicit"));
    long pageLoadTimeout = Long.parseLong(PropertiesCache.getProperty("pageLoadTimeout"));
    long setScriptTimeout = Long.parseLong(PropertiesCache.getProperty("setScriptTimeout"));

    @BeforeClass
    public void setUp() {
        //Automatically downloads and sets up the latest driver
        setBrowser();
        setWebDriverSettings();
    }

    private void setWebDriverSettings() {
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(implicitWait, TimeUnit.SECONDS);
        webDriver.manage().timeouts().pageLoadTimeout(pageLoadTimeout, TimeUnit.SECONDS);
        webDriver.manage().timeouts().setScriptTimeout(setScriptTimeout, TimeUnit.SECONDS);
    }

    public void setBrowser() {
        Browser runBrowser = EnumUtils.isValidEnum(Browser.class, browser) ?
                Browser.valueOf(browser.toUpperCase()) : Browser.CHROME;
        switch (runBrowser) {
            case CHROME:
                ChromeDriverManager.getInstance().setup();
                webDriver = new ChromeDriver();
                break;
            case FF:
                FirefoxDriverManager.getInstance().setup();
                webDriver = new FirefoxDriver();
                break;
        }
    }

    @AfterClass
    public void tearDown() {
        //Closes a browser
        webDriver.close();
        //Closes a browser's tab
//        webDriver.quit();
    }
}
