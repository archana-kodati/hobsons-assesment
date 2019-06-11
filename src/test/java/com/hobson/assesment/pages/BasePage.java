package com.hobson.assesment.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {
    public static WebDriver driver;

    public  BasePage(WebDriver driver){
        BasePage.driver= driver;
        PageFactory.initElements(driver,this);
    }
}
