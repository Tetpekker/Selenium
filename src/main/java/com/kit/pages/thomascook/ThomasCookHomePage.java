package com.kit.pages.thomascook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Tas_ka on 6/18/2017.
 */
public class ThomasCookHomePage extends ThomasCookBasePage{

    By holidaysLocator = By.xpath("//*[@id='globalHeaderContent']/ul/li[1]/a");
    private WebElement holidays;

    public ThomasCookHomePage(WebDriver webDriver){
        super(webDriver);
    }

    public void diveHolidays(){
        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(holidaysLocator));
        holidays = webDriver.findElement(holidaysLocator);
        holidays.click();
        webDriver.findElement(By.xpath("//*[@id='globalHeaderContent']/ul/li[1]/a")).click();
    }

}
