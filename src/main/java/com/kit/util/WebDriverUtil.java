package com.kit.util;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import static com.google.common.io.Files.toByteArray;

import java.io.File;

import static com.google.common.io.Files.toByteArray;

/**
 * Created by Tas_ka on 6/16/2017.
 */
public class WebDriverUtil {

    private long explicitWait = Long.parseLong(PropertiesCache.getProperty("wait.explicit"));
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private JavascriptExecutor executor;

    public WebDriverUtil(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait = new WebDriverWait(webDriver, explicitWait);
    }

    public WebElement waitForExpectedCondition(ExpectedCondition expectedCondition) {
        return  (WebElement)webDriverWait.until(expectedCondition);
    }

    public void jsClick(String locator, String type) {
        executor = (JavascriptExecutor) webDriver;
        if (type.equals("id")) {
            executor.executeScript("document.getElementById(\"" + locator + "\").click()");

        } else if (type.equals("name")) {
            executor.executeScript("document.getElementsByName(\"" + locator + "\")[0].click()");

        }
    }

    @Attachment(value = "{0}")
    public byte[] saveScreenshot(String attachName) {
        try {
            File scrFile = ((TakesScreenshot) webDriver).getScreenshotAs(OutputType.FILE);
            return toByteArray(scrFile);
        } catch (Exception e) {
            System.out.println("Is not saved screenshot" + e);
        }
        return new byte[0];
    }
}

