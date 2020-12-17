package exercise.steps;

import cucumber.api.java.en.Given;
import exercise.CucumberTest;
import exercise.pages.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

public class LoginSteps {
    public WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 30);
    private LoginPage loginPage;
    private ResourceBundle rb;


    public LoginSteps() {
        loginPage = new LoginPage();
        rb = ResourceBundle.getBundle("application");
    }

    @Given("^I have logged in as an existing user$")
    public void login() {
        loginPage.navigateTo();
        loginPage.setEmailAddressInput();
        loginPage.setPasswordInput();
        loginPage.clickLoginButton();
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("go.xero.com/Dashboard/")));
    }
}
