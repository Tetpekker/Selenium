package com.kit.homework22;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.gmail.GmailInboxPage;
import com.kit.pages.gmail.GmailLoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Tas_ka on 6/8/2017.
 */
public class Gmail extends WebDriverTestBase {

    private String gmailPage = "https://gmail.com";
    private String gmailUserName = "solodkagannusya@gmail.com";
    private String gmailPassword = "zxcvb1986";

    @Test
    public void t001GmailLogin(){
        GmailLoginPage gmailLoginPage = new GmailLoginPage(webDriver);
        gmailLoginPage.open(gmailPage);
        gmailLoginPage.loginToGmail(gmailUserName, gmailPassword);
        GmailInboxPage gmailInboxPage = new GmailInboxPage(webDriver);
        assertTrue(gmailInboxPage.isLoggedIn());
    }

    @Test
    public void t002GmailLoout(){
        GmailInboxPage gmailInboxPage = new GmailInboxPage(webDriver);
        gmailInboxPage.logOut();
    }


}
