package exercise.steps;

import cucumber.api.java.en.Given;
import exercise.CucumberTest;
import exercise.pages.BankAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BankAccountSteps {
    public WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 30);
    private BankAccountPage bankAccountPage;

    public BankAccountSteps() {
        bankAccountPage = new BankAccountPage();
    }

    @Given("^I click the Add Bank Account button on the Bank Accounts form$")
    public void iClickAddBankAccountButton() {
        bankAccountPage.clickBankAcountButton();
    }


}
