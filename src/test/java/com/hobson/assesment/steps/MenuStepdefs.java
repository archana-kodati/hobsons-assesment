package com.hobson.assesment.steps;

import com.hobson.assesment.pages.HomePage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class MenuStepdefs extends BaseStepDef{

    public HomePage homePage;
 public MenuStepdefs(){

     super();
     homePage = new HomePage(Hooks.driver);
 }
    @Given("^I open Hobsons website in Chrome browser$")
    public void iOpenHobsonsWebsiteInChromeBrowser() throws Throwable {
     driver.get("https://www.hobsons.com/");
    driver.manage().window().maximize();
    }

    @Then("^I see following list of ([^\"]*) items$")
    public void iSeeFollowingListOfMenuItems(String expectedMenuItems) throws Throwable {

        List<String> actualMenuList = homePage.getMenuItems();
        List<String> expectedMenuItemsList = Arrays.asList(expectedMenuItems.split("\\s*,\\s*"));
        System.out.println("expectedMenuItemsList " + expectedMenuItemsList);

        for(int i=0; i < expectedMenuItemsList.size(); i++) {
           Assert.assertEquals("Main Menu Values are not equal ", expectedMenuItemsList.get(i), actualMenuList.get(i));

        }

    }

    @When("^I hover over on ([^\"]*) items$")
    public void iHoverOverOnMenuItems(String mainMenuItem) throws Throwable {
       homePage.hoverMenu(mainMenuItem);
    }

    @Then("^I should see following list of ([^\"]*) items for ([^\"]*) menu$")
    public void iShouldSeeFollowingListOfSubMenuItemsForGivenMenu(String subMenuItem, String menuName) throws Throwable {
        List<String> actualSubMenuList = homePage.getSubMenuItems(menuName);
        List<String> expectedSubMenuItemsList = Arrays.asList(subMenuItem.split("\\s*,\\s*"));

        for(int i=0; i < expectedSubMenuItemsList.size(); i++) {
            System.out.println("actualSubMenuList.get(i) " + actualSubMenuList.toString());
             Assert.assertEquals("Sub Menu Values are not equal ", expectedSubMenuItemsList.get(i), actualSubMenuList.get(i));

        }

    }

    @Then("^I should see following list of ([^\"]*) items for([^\"]*) ,([^\"]*) section$")
    public void iShouldSeeFollowingListOfItemsItemsForMenuSubMenuSection(String spanItems,String menuName,String subMenuName) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        List<String> actualSpanItems=homePage.getSpansInSubMenu(menuName,subMenuName);
        List<String> expectedSpanItemsList = Arrays.asList(spanItems.split("\\s*,\\s*"));
        for(int i=0; i < expectedSpanItemsList.size(); i++) {
            Assert.assertEquals("Sub Menu Values are not equal ", expectedSpanItemsList.get(i), actualSpanItems.get(i));

        }

    }
}
