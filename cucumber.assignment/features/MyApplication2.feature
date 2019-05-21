Feature: matching of actual with expected balance of customer
  I want to use this template for my feature file

  @tag1
  Scenario Outline: loginTest
    Given open chrome and get url of bank
    When login by providing "<username>" and "<password>"
    And open mini statement with customer "<accountNumber>" and check balance
    #And yet another action
    Then check whether the actual balance is being match with expected balance
    Then close browser

    Examples: 
      | username   | password | accountNumber |
      | mngr190342 | rApEtAm  |         59350 |

  @tag2
  Scenario Outline: loginTest
    Given open chrome and get url of bank
    When login by providing "<username>" and "<password>"
    And open mini statement with customer "<accountNumber>"
    #And yet another action
    Then check whether the home button is displayed or not
    Then close browser

    Examples: 
      | username   | password | accountNumber |
      | mngr190342 | rApEtAm  |         59350 |
