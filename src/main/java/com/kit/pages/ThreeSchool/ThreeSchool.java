package com.kit.pages.ThreeSchool;

import com.kit.util.WebDriverUtil;
import org.openqa.selenium.WebDriver;

/**
 * Created by Tas_ka on 6/30/2017.
 */
public class ThreeSchool {

    protected WebDriver webDriver;
    protected WebDriverUtil webDriverUtil;

    private String url = "https://www.w3schools.com/tags/tryit.asp?filename=tryhtml_select";

    public ThreeSchool(String url){
        this.url = url;
    }


}
