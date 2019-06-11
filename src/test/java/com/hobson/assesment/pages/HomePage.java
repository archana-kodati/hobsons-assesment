package com.hobson.assesment.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver){
        super(driver);

    }

    @FindBy(how=How.XPATH, using="//nav/ul/li[not(contains(@class, 'home-link'))]/a")
    public static List<WebElement> menuItems;

    @FindBy(how = How.CLASS_NAME, using ="owl-next" )
    public static WebElement nextElement;

    @FindBy(how = How.CLASS_NAME, using = "owl-prev")
    public static WebElement prevElement;


    @FindBy(how=How.XPATH, using="//div[contains(@class, 'owl-item') and contains(@class, 'active')]/li/div/h4")
    public static List<WebElement> tileElements;

    public static List<String> getMenuItems() {
        List<String> menuItemNames = new ArrayList<>();
        for(WebElement menuItem : menuItems) {
            menuItemNames.add(menuItem.getText());
        }
        return menuItemNames;
    }

    public static List<String> getSubMenuItems(String menuName) {
        List<String> subMenuItemNames = new ArrayList<>();
        List<WebElement> subMenuItems = new ArrayList<>();
        for(WebElement menuItem : menuItems) {
            if(menuItem.getText().toUpperCase().equals(menuName.trim().toUpperCase())) {
                subMenuItems = menuItem.findElements(By.xpath("../ul/li/a"));
                break;
            }
        }

        for(WebElement subMenuItem : subMenuItems) {
            subMenuItemNames.add(subMenuItem.getAttribute("innerHTML"));
        }

        return subMenuItemNames;
    }

    public static List<String> getSpansInSubMenu(String menuName, String subMenuName) {
        List<String> spanNames = new ArrayList<>();
        String xpath="//nav/ul/li/a[contains(text(),'" + menuName.trim() + "')]/../ul/li/a[contains(text(), '" + subMenuName + "')]/../span/a";
        System.out.println("xpath " + xpath);

        List<WebElement> spanItems = driver.findElements(By.xpath(xpath));
        System.out.println("spanItems " + spanItems);
        for(WebElement spanItem : spanItems) {
            spanNames.add(spanItem.getAttribute("innerHTML"));
        }

        return spanNames;
    }
    public static void clickRightArrow() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", nextElement);
    }
    public static void clickLeftArrow() {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", prevElement);
    }

    public static String getFirstTileName() {
        return tileElements.get(0).getText();
    }

    public void waitForTileToBeVisble() throws Error{
        new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOf(tileElements.get(0)));
    }

    public void hoverMenu(String mainMenuItem) {
        Actions action = new Actions(driver);
        action.moveToElement(getMenuElementByName(mainMenuItem)).perform();
    }

    private WebElement getMenuElementByName(String menuName) {
        for(WebElement menuItem : menuItems) {
            if(menuItem.getText().toUpperCase().equals(menuName.trim().toUpperCase())) {
               return menuItem;
            }
        }
        return null;
    }



}
