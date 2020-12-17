package exercise.steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import exercise.CucumberTest;
import exercise.pages.UserDashboardPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UserDashboardSteps {
    public WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 30);
    private UserDashboardPage userDashboardPage;

    public UserDashboardSteps() {
        userDashboardPage = new UserDashboardPage();
    }


    @Given("^I select the Accounting option from dashboard menu$")
    public void iSelectTheOptionFromAccountingMenu() {
        userDashboardPage.getAccountingMenuOption().click();
    }

    @Then("I select the Bank Accounts option from Accounting dashboard menu")
    public void iSelectTheBankAccountsOptionFromSubmenu() {
        userDashboardPage.selectBankAccountsOptionFromAccountingMenu();
    }

    @Then("I can see my (.*) (.*) in my dashboard")
    public void iCanSeeMyAccountInMyDashboard(String accountName, String accountNumber) {
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("Dashboard")));
        Assert.assertTrue(userDashboardPage.getDashboardBankAccountName(accountName).isDisplayed());
        Assert.assertTrue(userDashboardPage.getDashboardBankAccountNumber(accountNumber).isDisplayed());
    }
}
