package com.kit.homework22;

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
public class Gmail {

    private String gmail;
    private WebDriver webDriver;

    @BeforeClass
    public void setUp(){
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\Tas_ka\\repos\\src\\main\\resources\\chromedriver.exe");
        webDriver = new ChromeDriver();
        gmail = "https://www.google.com/intl/uk/gmail/about/";
        webDriver.get(gmail);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

    @Test
    public void gmailEnter(){

        webDriver.findElement(By.xpath("html/body/nav/div/a[2]")).click();
        webDriver.findElement(By.xpath("//*[@id='identifierId']")).click();
        webDriver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys("solodkagannusya@gmail.com");
        webDriver.findElement(By.xpath("//*[@id='identifierId']")).sendKeys(Keys.ENTER);
//        webDriver.findElement(By.xpath("//*[@id='password']/div[1]/div/div[1]/input")).click();
        webDriver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys("zxcvb1986");
        webDriver.findElement(By.xpath("//input[@autocomplete='current-password']")).sendKeys(Keys.ENTER);

        By linkLocator = By.xpath("//*[@id=':82']/div/div[2]/span/a");
        WebElement link = webDriver.findElement(linkLocator);
        assertTrue(link.isDisplayed());
    }

    @AfterClass
    public void logOut(){
        webDriver.findElement(By.xpath("//*[@id='gb']/div[1]/div[1]/div[2]/div[4]/div[1]/a/span")).click();
        webDriver.findElement(By.xpath("//*[@id='gb_71']")).click();
    }

    public void tearDown(){
        webDriver.quit();
    }
}
