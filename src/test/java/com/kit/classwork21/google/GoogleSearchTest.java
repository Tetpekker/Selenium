package com.kit.classwork21.google;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.google.GoogleSearchPage;
import com.kit.pages.google.GoogleSearchResultPage;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static org.testng.AssertJUnit.assertTrue;

@Features("searhTest")
@Stories("WEB-777")
@Listeners({com.kit.core.TestListener.class})
public class GoogleSearchTest extends WebDriverTestBase {
    private String googleSearch = "https://www.google.com/";
    private String searchText = "Selenium";

    @Title("Google search test - positive scenario")
    @Description("Searches any text on google.com")
    @Test
    public void searchTest() {
      // GoogleSearchPage googleSearchPage = PageFactory.initElements(webDriver, GoogleSearchPage.class);
        GoogleSearchPage googleSearchPage = new GoogleSearchPage(webDriver);
        googleSearchPage.open(googleSearch);
        googleSearchPage.fillAndSubmitSearchData(searchText);
        GoogleSearchResultPage googleSearchResultPage = new GoogleSearchResultPage(webDriver);

        assertTrue(googleSearchResultPage.getLinkText().contains(searchText));
    }
}
