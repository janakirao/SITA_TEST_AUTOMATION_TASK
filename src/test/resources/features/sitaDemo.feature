#Author: v.janakirao@gmail.com

@SitaReservation
Feature: Make a reservation In Sita
  

 Background: 
  
 Given I Launch into Sita URL "https://sitatesting.github.io/AutomationTest/index.html"
 And   I verify landed on Home page successfully
  

  @submitReservation
  Scenario Outline: Make a Reservation
    Given I click on explore More button beside Carribean
    And I click on  Make a Reservation in Kingston
    When I enter details of the trip "<Name>" "<Phone_Number>" "<Number_of_Guests>" "<Checkin_Date>" "<Destination>" 
    Then I click on submit reservation now
    
  Examples:
  |Name       |Phone_Number   |Number_of_Guests|Checkin_Date |Destination|  
  |Janaki Rao |+3538884765421 | 3             |30/06/2024   | Engaland, London   |
 