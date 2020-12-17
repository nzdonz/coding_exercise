package exercise.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import exercise.CucumberTest;
import exercise.pages.AddBankAccountPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddBankAccountSteps {
    public WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 30);
    private AddBankAccountPage addBankAccountPage;

    public AddBankAccountSteps() {
        addBankAccountPage = new AddBankAccountPage();
    }


    @And("I select the (.*) bank from the popular list")
    public void iSelectTheBankFromThePopularList(String bank) {
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("/Banking/Account/#find")));
        addBankAccountPage.selectBankFromPopularList(bank);
    }

    @And("I input (.*) in the account name field")
    public void iInputInTheAccountNameField(String accountName) {
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("Account/#add/direct")));
        addBankAccountPage.setBankAccountName(accountName);
    }

    @And("I click Continue after inputting (.*) bank account number")
    public void iClickContinueAfterInputtingABankccountNumber(String accountNumber) {
        addBankAccountPage.setBankAccountNumber(accountNumber);
        addBankAccountPage.clickContinueButton();
    }

    @And("I choose (.*) from the account type field")
    public void iChooseFromTheAccountTypeField(String accountType) {
        addBankAccountPage.setBankAccountType(accountType);
    }

    @When("I click I've got a form button")
    public void iClickIVeGotAFormButton() {
        addBankAccountPage.clickIHaveAFormButton();
    }

    @And("I click I'll do it later button")
    public void iClickDoItLaterButton() {
        addBankAccountPage.clickDoItLaterButton();
    }

    @And("I click Go to dashboard button")
    public void iClickGoToDashboardButton() {
        addBankAccountPage.clickGoToDashboardButton();
    }
}
