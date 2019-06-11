Feature: To validate menu and submenu items

  Background:
    Given I open Hobsons website in Chrome browser

  Scenario Outline: Validate menu items
  Then I see following list of <Menu> items
  Examples:
   |Menu|
   |SOLUTIONS, SERVICES, RESOURCES, ABOUT, BLOG, GET STARTED|



  Scenario Outline: Validate Sub menu items
    When I hover over on <Menu> items
    Then I should see following list of <SubMenu> items for <Menu> menu
  Examples:
  |Menu           | SubMenu                                                                                 |
  |SOLUTIONS    |College and Career Readiness, Match and Fit, Student Success and Advising                |
  |RESOURCES      |All,Webinars,Events,Case Studies,White Papers,Blog,Press Releases,Press Coverage,Videos  |
  |ABOUT          |Company,Partnerships,Careers,Media Kit,Contact Us                                        |

  Scenario Outline: Verify for sub sections under Solution menu->College and Career Readiness
    When I hover over on <Menu> items
    Then I should see following list of <Items> items for <Menu> ,<SubMenu> section
  Examples:
  |Menu           | SubMenu                        |Items                                                   |
  |Solutions      |College and Career Readiness    |California,Michigan,Texas,Pennsylvania,Illinois,Florida |







