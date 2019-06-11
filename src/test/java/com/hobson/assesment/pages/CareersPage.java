package com.hobson.assesment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class CareersPage extends BasePage{
    public CareersPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.XPATH, using = "//footer//a[text()='Careers']")
    public static WebElement careersPageLink;

    @FindBy(how = How.XPATH, using = "//section[@id='careers-locations']//tr/td")
    public static List<WebElement> locationElement;

    @FindBy(how = How.CLASS_NAME, using = "section-hero-header-title")
    public static  WebElement titleInMaps;

    //to click on careers link
    public static void clickCareersLink(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", careersPageLink);
    }

    public static String getHQAddress(){
        return locationElement.get(0).findElement(By.xpath("address")).getText();
    }

    public static String getHQAddressHeader(){
        return locationElement.get(0).findElement(By.xpath("h4/a")).getText();
    }

    public static String getVAAddress(){
        return locationElement.get(1).findElement(By.xpath("address")).getText();
    }

    public static String getVAAddressHeader(){
        return locationElement.get(1).findElement(By.xpath("h4/a")).getText();
    }

    public static String getRemoteAddressHeader(){
        return locationElement.get(2).findElement(By.xpath("h4/a")).getText();
    }

    public static void clickOnHQLocation(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement HQHeaderElement = locationElement.get(0).findElement(By.xpath("h4/a"));
        executor.executeScript("arguments[0].click();", HQHeaderElement);
    }

    public static void clickOnVALocation(){
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        WebElement VAHeaderElement = locationElement.get(1).findElement(By.xpath("h4/a"));
        executor.executeScript("arguments[0].click();", VAHeaderElement);
    }

    public static String getAddressTitleInGoogleMaps(){
        return titleInMaps.getText();
    }

    public static void waitForGoogleMapsPageToLoad(){
        List<String> browserTabs = new ArrayList<String>(driver.getWindowHandles());
        System.out.println("browserTabs length " + browserTabs.size());

        driver.switchTo().window(browserTabs.get(0));
        driver.close();
        driver.switchTo().window(browserTabs.get(1));
        new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.presenceOfElementLocated(By.className("section-hero-header-title")));

        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(driver.findElement(By.className("section-hero-header-title"))));

    }

}
