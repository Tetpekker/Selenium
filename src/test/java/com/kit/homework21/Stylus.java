package com.kit.homework21;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Tas_ka on 6/6/2017.
 */
public class Stylus {

    private String stylusSearch;
    private WebDriver webDriver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Tas_ka\\repos\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        stylusSearch = "https://www.stylus.com.ua/";
        webDriver.get(stylusSearch);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void searchTest(){
        String searchText = "Sony Z2";
        By searchLocator = By.xpath("//input[@name='q']");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.xpath("//a[@data-name='Sony Xperia Z2 Black']");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.isDisplayed());
        // assertTrue(link.getText().contains(searchText));
    }

    @AfterClass
    public void tearDown(){
        webDriver.quit();
    }
}

