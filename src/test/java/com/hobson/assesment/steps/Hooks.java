package com.hobson.assesment.steps;


import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



public class Hooks {

    public static WebDriver driver;

    @Before
    public void beforeTest(){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

     driver = new ChromeDriver();
    }
    @After
    public void afterTest(){
        driver.quit();

    }
}
