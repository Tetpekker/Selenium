package com.kit.pages.thomascook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Tas_ka on 6/18/2017.
 */
public class ThomasCookHolidaysPage extends ThomasCookBasePage{

    By linkLocator = By.linkText("holidays");
    private WebElement link;

    public ThomasCookHolidaysPage(WebDriver webDriver){
        super(webDriver);
    }

    public String getLinkText(){
        link = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(linkLocator));
        return link.getText();
    }
}
