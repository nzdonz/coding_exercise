@addbankaccount
Feature: Add Bank Account to User
  As a Xero User
  In order to manage my business successfully
  I want to be able to add an "ANZ (NZ)" bank account inside any Xero organisation

  Background:
    Given I have logged in as an existing user
    And I select the Bank Accounts option from Accounting dashboard menu
    Then I click the Add Bank Account button on the Bank Accounts form

  Scenario: Add bank account to existing user
    Given I select the ANZ (NZ) bank from the popular list
    When I input Test Account in the account name field
    And I choose Loan from the account type field
    And I click Continue after inputting 123456789 bank account number
    When I click I've got a form button
    And I click I'll do it later button
    And I click Go to dashboard button
    Then I can see my Test Account 123456789 in my dashboard




