package com.kit.pages.ThreeSchool;

import com.kit.core.WebDriverTestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

public class DragandDrop extends WebDriverTestBase{


        @Test
        public void testDragDrop() throws InterruptedException {
            webDriver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml5_draganddrop");
            webDriver.switchTo().frame("iframewrapper");
            WebElement From = webDriver.findElement(By.xpath(".//*[@id='drag1']"));
            WebElement To = webDriver.findElement(By.xpath(".//*[@id='div1']"));
            Actions builder = new Actions(webDriver);
            builder.clickAndHold(From).moveToElement(To).release(To).build().perform();
        }
    }

