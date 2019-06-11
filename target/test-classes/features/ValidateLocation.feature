Feature: Validate Hobsons locations in Careers Page

  Background: : Open Hobsons website and go to Careers Page
    Given I open Hobsons website in Chrome browser
    When I click on Careers Page at the bottom of HomePage

  @feature
  Scenario Outline:Verify Hobsons HQ location in Careers Page
    Then I should navigate to Careers page and see HobsonsHQ <HQlocation> header and <locationaddress>
    And I click on HQ Location
    Then I should goto google maps in new window with the HQ location <address>
    Examples:
      |HQlocation     |locationaddress                                                    |address                          |
      |Cincinnati, OH |400 E-Business Way, Suite 400\nCincinnati, OH 45241\n+1.513.891.5444|400 E Business Way #400Cincinnati|

  @feature
  Scenario Outline: Verify Hobsons VA location in Careers Page
    Then I should navigate to Careers page and see HobsonsVA <VAlocation> header and <locationaddress>
    And I click on VA Location
    Then I should goto google maps in new window with the VA location <address>
    Examples:
      |VAlocation    |locationaddress                                                     |address                        |
      |Arlington, VA  |3033 Wilson Boulevard, Suite 500 Arlington, VA 22201\n+1.703.234.5910|3033 Wilson Blvd #500Arlington |


