package exercise.pages;

import exercise.CucumberTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class BankAccountPage {
    public WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 30);

    public BankAccountPage() {
        driver = CucumberTest.driver;
    }

    public WebElement getAddBankAccountButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ext-gen15")));
    }

    public void clickBankAcountButton() {
        getAddBankAccountButton().click();
    }


}
