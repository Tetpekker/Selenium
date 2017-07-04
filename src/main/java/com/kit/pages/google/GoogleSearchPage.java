package com.kit.pages.google;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

public class GoogleSearchPage extends GoogleBasePage{
    By searchLocator = By.name("q");
//    @FindBy(name = "q")
    private WebElement searchField;

    public GoogleSearchPage(WebDriver webDriver) {
        super(webDriver);
    }

@Attachment(value = "{0}", type = "text/plain")
@Step("Fill search text {0} and press the Enter")
    public void fillAndSubmitSearchData(String searchText) {
        webDriverUtil.waitForExpectedCondition(ExpectedConditions.visibilityOfElementLocated(searchLocator));
        searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
    }
}
