package com.kit.google;

import com.kit.core.WebDriverTestBase;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static org.testng.AssertJUnit.assertFalse;
import static org.testng.AssertJUnit.assertTrue;

@Features("searhTest")
@Stories("WEB-888")
public class GoogleSearchOldTest extends WebDriverTestBase {

    private String googleSearch = "https://www.google.com.ua/";

    @Test(enabled = false)
    public void searchTest() {
        webDriver.get(googleSearch);
        String searchText = "Selenium";
        By searchLocator = By.name("q");
        WebElement searchField = webDriver.findElement(searchLocator);
        searchField.sendKeys(searchText);
        searchField.submit();
        By linkLocator = By.xpath(".//*[@id='rso']/div[2]/div/div[1]/div/div/h3/a");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.getText().contains(searchText));
        List<WebElement> webElementList = webDriver.findElements(By.cssSelector(".r>a"));
        if (!webElementList.isEmpty()) {
            for (WebElement webElement : webElementList) {
                assertTrue(webElement.getText().toLowerCase().contains(searchText.toLowerCase()));
            }
        } else {
            assertFalse("Elements not found", true);
        }

    }
}
