package com.hobson.assesment.steps;

import com.hobson.assesment.pages.CareersPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LocationsStepDef extends BaseStepDef {
    public CareersPage careersPage;
    public LocationsStepDef(){
        super();
        careersPage=new CareersPage(Hooks.driver);
    }

    @When("^I click on Careers Page at the bottom of HomePage$")
    public void iClickOnCareersPageAtTheBottomOfHomePage() throws Throwable {
        careersPage.clickCareersLink();
    }

    @Then("^I should navigate to Careers page and see HobsonsHQ ([^\"]*) header and ([^\"]*)$")
    public void iShouldNavigateToCareersPageAndSeeHobsonsHQHQlocationHeaderAndLocationaddress(String expectedLocHeader,String expectedLocAddress) throws Throwable {
       String actualHQAddress=careersPage.getHQAddress();
       String actualHQHeader=careersPage.getHQAddressHeader();

       //Verifying for HQ location address header
        Assert.assertEquals("HQ location header is not equal",expectedLocHeader,actualHQHeader);

        //Verifying for HQ location address
        Assert.assertEquals("HQ location Address are not equal",expectedLocAddress,actualHQAddress);
    }

    @And("^I click on HQ Location$")
    public void iClickOnHQLocation() throws Throwable {
        CareersPage.clickOnHQLocation();
    }

    @Then("^I should goto google maps in new window with the HQ location ([^\"]*)$")
    public void iShouldGotoGoogleMapsInNewWindowWithTheHQLocationAddress(String expectedHQTitle) throws Throwable {
        careersPage.waitForGoogleMapsPageToLoad();
        String actualHQAddressInMaps=careersPage.getAddressTitleInGoogleMaps();

        //Verifying HQ address in google maps once we click on HQ location
        Assert.assertEquals("HQ location address is not opened in Google Maps",expectedHQTitle,actualHQAddressInMaps);
    }

    @Then("^I should navigate to Careers page and see HobsonsVA ([^\"]*) header and ([^\"]*)$")
    public void iShouldNavigateToCareersPageAndSeeHobsonsVAVAlocationHeaderAndLocationaddress(String expectedLocHeader, String expectedLocAddress) throws Throwable {
        String actualVAAddress=careersPage.getVAAddress();
        String actualVAHeader=careersPage.getVAAddressHeader();
        //Verifying for VA location header
        Assert.assertEquals("VA location header is not equal",expectedLocHeader,actualVAHeader);

        //Verifying for VA location Address
        Assert.assertEquals("VA location Address is not equal",expectedLocAddress,actualVAAddress);
    }

    @And("^I click on VA Location$")
    public void iClickOnVALocation() throws Throwable {
        careersPage.clickOnVALocation();
    }

    @Then("^I should goto google maps in new window with the VA location ([^\"]*)$")
    public void iShouldGotoGoogleMapsInNewWindowWithTheVALocationAddress(String expectedVATitle) throws Throwable {
        careersPage.waitForGoogleMapsPageToLoad();
        String actualVAAddressInMaps=CareersPage.getAddressTitleInGoogleMaps();

        //Verifying VA address in google maps once we click on VA location
        Assert.assertEquals("VA location address is not opened in Google Maps",expectedVATitle,actualVAAddressInMaps);


    }
}
