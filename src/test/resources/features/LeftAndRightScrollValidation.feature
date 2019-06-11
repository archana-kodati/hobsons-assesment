Feature: Validate Left and Right Scroll functionality on Homepage

  Background:
    Given I open Hobsons website in Chrome browser

  Scenario Outline: Verify for right scroll features
    When I click on right arrow <n> times
    Then I should get tiles in the <Expected Order>
    Examples:
    |n |Expected Order                                                                  |
    | 0 |JOIN US AT HOBSONS SUMMER INSTITUTE 2019                                       |
    | 1 |NAVIANCE WIELDS ‘POWER AND INFLUENCE’ IN COLLEGE ADMISSIONS                    |
    | 2 |STUDENT SUCCESS KIT                                                            |
    | 3 |NAVIANCE CCLR LIVE BY KAPLAN                                                   |
    | 4 |WESTERN CONNECTICUT STATE UNIVERSITY                                           |
    | 5 |RAMAPO COLLEGE OF NEW JERSEY: FACULTY AND STAFF ADOPTION OF STARFISH SOLUTIONS |
    | 6 |CCLR FRAMEWORK                                                                 |
    | 7 |OPTIMIZE IN-PERSON STUDENT CONNECTIONS WITH REPVISITS                          |
    | 8 |JOIN US AT HOBSONS SUMMER INSTITUTE 2019                                       |

  Scenario Outline: Verify for left  scroll features
    When I click on left arrow <n> times
    Then I should get tiles in the <Expected Order>
    Examples:
      |n |Expected Order                                                                  |
      | 0 |JOIN US AT HOBSONS SUMMER INSTITUTE 2019                                       |
      | 1 |OPTIMIZE IN-PERSON STUDENT CONNECTIONS WITH REPVISITS                          |
      | 2 |CCLR FRAMEWORK                                                                 |
      | 3 |RAMAPO COLLEGE OF NEW JERSEY: FACULTY AND STAFF ADOPTION OF STARFISH SOLUTIONS |
      | 4 |WESTERN CONNECTICUT STATE UNIVERSITY                                           |
    #  | 5 |NAVIANCE CCLR LIVE BY KAPLAN                                                   |
     # | 6 |STUDENT SUCCESS KIT                                                            |
     # | 7 |NAVIANCE WIELDS ‘POWER AND INFLUENCE’ IN COLLEGE ADMISSIONS                    |
     #| 8 |JOIN US AT HOBSONS SUMMER INSTITUTE 2019                                       |