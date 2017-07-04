package com.kit.pages.hometask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Tas_ka on 6/18/2017.
 */
public class StylusResultPage extends com.kit.pages.hometask.StylusBasePage {

    By linkLocator = By.xpath("//a[@data-name='Sony Xperia Z2 Black']");
    private WebElement link;

    public StylusResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getLinkText(){
        link = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(linkLocator));
        return link.getText();
    }

    public void clickLink(){
        link.click();
    }
}
