
@tag
Feature: loginTest
  I want to use this template for my feature file

  @tag1
  Scenario Outline: loginTest
    Given open chrome and get url
    When login by providing correct "<username>" and "<password>" 
    #And some other action
    #And yet another action
    Then check whether logged in or not
    Then quit driver
    
    Examples: 
    		 | username | password |
      | mngr190342 |rApEtAm |
      #| mngr190342 | rApEtAm |
      
   @tag2
   Scenario: checking New Customer element on user page
     Given open user page
     Then check whether New Customer element present or not on user page
     Then dismis browser
      
      
      
  #
  #Scenario Outline: actual and displayed balance of account test
    #Given open chrome and get url
    #And login by providing correct username and password 
    #And some other action
    #And yet another action
    #Then check whether logged in or not
    #Then check more outcomes
  #
  
  

    
      
