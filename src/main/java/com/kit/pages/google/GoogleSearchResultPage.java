package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Step;

public class GoogleSearchResultPage extends GoogleBasePage {
    By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
    private WebElement link;

    public GoogleSearchResultPage(WebDriver webDriver) {
        super(webDriver);
    }

    public String getLinkText() {
        link = webDriverUtil.waitForExpectedCondition(ExpectedConditions.elementToBeClickable(linkLocator));
        return link.getText();
    }

    public void clickLink() {
        webDriverUtil.jsClick("gb_70", "id");
    }

}
