package com.kit.pages.hometask;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tas_ka on 6/18/2017.
 */
public class StylusBasePage {

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;

    public StylusBasePage(WebDriver webDriver){
        this.webDriver = webDriver;
        webDriverUtil = new WebDriverUtil(webDriver);
    }

    public void open(String url) {
        webDriver.get(url);
    }
}
