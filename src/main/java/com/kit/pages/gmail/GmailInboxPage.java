package com.kit.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * Created by Tas_ka on 6/18/2017.
 */
public class GmailInboxPage extends GmailBasePage {

    By gmailLinkLocator = By.xpath("//*[@id=':i']/span[text()='Gmail']");
    private WebElement gmailLink;

    By userAccountButton = By.xpath("//a[contains(@href, 'SignOutOptions')]");
    private WebElement userAccount;

    By logoutButton = By.xpath("//a[contains(@href, 'Logout')]");
    private WebElement userLogout;



    public GmailInboxPage(WebDriver webDriver) {
        super(webDriver);
    }

    public Boolean isLoggedIn(){
        gmailLink = webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(gmailLinkLocator));
        return gmailLink.isDisplayed();
    }

    public void logOut(){
        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(userAccountButton));
        userAccount = webDriver.findElement(userAccountButton);
        userAccount.click();

        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(logoutButton));
        userLogout = webDriver.findElement(logoutButton);
        userLogout.click();

    }
}
