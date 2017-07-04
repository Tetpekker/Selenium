package com.kit.homework21;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.hometask.StylusHomePage;
import com.kit.pages.hometask.StylusResultPage;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

/**
 * Created by Tas_ka on 6/6/2017.
 */
public class Stylus extends WebDriverTestBase{

    private String stylusSearch = "https://stylus.ua";
    private String searchText = "Sony Z2";

    @Test
    public void stylusTest() {
        // GoogleSearchPage googleSearchPage = PageFactory.initElements(webDriver, GoogleSearchPage.class);
        StylusHomePage stylusHomePage = new StylusHomePage(webDriver);
        stylusHomePage.open(stylusSearch);
        stylusHomePage.fillAndSubmitSearchData(searchText);
        StylusResultPage stylusResultPage = new StylusResultPage(webDriver);
        assertTrue("Current link text is "+stylusResultPage.getLinkText()+" should be " + searchText,stylusResultPage.getLinkText().contains(searchText));
    }
}

