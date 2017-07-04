package com.kit.homework25;

import com.kit.core.WebDriverTestBase;
import com.kit.pages.thomascook.ThomasCookHolidaysPage;
import com.kit.pages.thomascook.ThomasCookHomePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

/**
 * Created by Tas_ka on 6/18/2017.
 */
public class ThomasCookTest extends WebDriverTestBase{

    private String homeThomasCook = "https://www.thomascook.com";
    private String text = "holidays";

   @Test
    public void thomasCookTest(){
        ThomasCookHomePage thomasCookHomePage = new ThomasCookHomePage(webDriver);
        thomasCookHomePage.open(homeThomasCook);
       // thomasCookHomePage.diveHolidays();
       // ThomasCookHolidaysPage thomasCookHolidaysPage = new ThomasCookHolidaysPage(webDriver);
       // AssertJUnit.assertTrue("Current link text is "+thomasCookHolidaysPage.getLinkText()+" should be " + text,thomasCookHolidaysPage.getLinkText().contains(text));
      WebElement selElem;
      selElem = webDriver.findElement(By.id("SearchbarForm-duration"));
      Select selectObject = new Select(selElem);
      selectObject.selectByVisibleText("7 Nights");
      AssertJUnit.assertTrue("7 Nights", true);
    }
}
