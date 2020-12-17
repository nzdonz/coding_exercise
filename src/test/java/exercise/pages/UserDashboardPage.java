package exercise.pages;

import exercise.CucumberTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

public class UserDashboardPage {
    private WebDriver driver;
    private ResourceBundle rb;
    private WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 30);

    public UserDashboardPage() {
        driver = CucumberTest.driver;
    }


    public WebElement getAccountingMenuOption() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-name='navigation-menu/accounting']")));
    }

    public WebElement getBankAccountMenuOption() {
        return driver.findElement(By.linkText("Bank accounts"));
    }

    public WebElement getDashboardBankWidget() {
        return driver.findElement(By.cssSelector("a[data-automationid='bankWidget']"));
    }

    public WebElement getDashboardBankAccountName(String accountName) {
        return getDashboardBankWidget().findElement(By.xpath("h3[contains(., '" + accountName + "')]"));
    }

    public WebElement getDashboardBankAccountNumber(String accountNumber) {
        return getDashboardBankWidget().findElement(By.xpath("div[contains(., '" + accountNumber + "')]"));
    }

    public void selectBankAccountsOptionFromAccountingMenu() {
        getAccountingMenuOption().click();
        getBankAccountMenuOption().click();
        Assert.assertTrue(wait.until(ExpectedConditions.urlContains("Bank/BankAccounts")));
    }
}
