package com.hobson.assesment.steps;

import com.hobson.assesment.pages.HomePage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;


public class ScorllStepdefs extends BaseStepDef {

    private HomePage homePage;
    public ScorllStepdefs(){
        super();
        homePage = new HomePage(Hooks.driver);
    }


    @Then("^I should get tiles in the ([^\"]*)$")
    public void iShouldGetTilesInTheExpectedOrder(String expectedTileName) throws Throwable {
        String actualTileName = homePage.getFirstTileName();
        Assert.assertEquals(expectedTileName,actualTileName);

    }

    @When("^I click on right arrow ([^\"]*) times$")
    public void iClickOnRightArrow(int n) throws Throwable {
       for(int i = 0; i < n; i++) {
            homePage.clickRightArrow();
        }
        homePage.waitForTileToBeVisble();
    }

    @When("^I click on left arrow ([^\"]*) times$")
    public void iClickOnLeftArrowNTimes(int n) throws Throwable {
        for(int i = 0; i < n; i++) {
            homePage.clickLeftArrow();
        }
        homePage.waitForTileToBeVisble();
    }
}


