package com.kit.pages.gmail;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


/**
 * Created by Tas_ka on 6/18/2017.
 */
public class GmailLoginPage extends com.kit.pages.gmail.GmailBasePage {

    By emailLocator = By.xpath("//*[@id='identifierId']");
    private WebElement emailField;
    By passwordLocator = By.xpath("//input[@autocomplete='current-password']");
    private WebElement passwordField;


    public GmailLoginPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void loginToGmail(String gmailUserName, String gmailPassword) {

        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(emailLocator));
        emailField = webDriver.findElement(emailLocator);
        emailField.sendKeys(gmailUserName);
        emailField.sendKeys(Keys.ENTER);

        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(passwordLocator));
        passwordField = webDriver.findElement(passwordLocator);
        passwordField.sendKeys(gmailPassword);
        passwordField.sendKeys(Keys.ENTER);
    }
}
