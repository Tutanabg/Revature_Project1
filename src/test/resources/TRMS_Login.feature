#This is a comment in a Feature File
Feature: TRMS Page Work
    #Each Scenario will correspond to a User Story
  Scenario: Login works
    Given The Guest is on the Employee Page
    When The Guest clicks Click Here
    Then The Guest should be on the TRMS Page
