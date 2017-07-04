package com.kit.pages.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Tas_ka on 6/18/2017.
 */
public class StylusHomePage extends com.kit.pages.hometask.StylusBasePage {

    By searchLocator = By.xpath("//input[@name='q']");
    //    @FindBy(name = "q")
    private WebElement searchField;

    public StylusHomePage(WebDriver webDriver) {
        super(webDriver);
    }



    public void fillAndSubmitSearchData(String searchText) {
        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(searchLocator));

        searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
    }
}
