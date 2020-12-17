package exercise.pages;

import exercise.CucumberTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class AddBankAccountPage {
    public WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 40);

    public AddBankAccountPage() {
        driver = CucumberTest.driver;
    }

    public WebElement getBankAccountNameInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountname-1037-inputEl")));
    }

    public WebElement getBankAccountTypeInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accounttype-1039-inputEl")));
    }

    public WebElement getBankAccountNumberInput() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountnumber-1068-inputEl")));
    }

    public WebElement getContinueButton() {
        return driver.findElement(By.id("common-button-submit-1015-btnInnerEl"));
    }

    public WebElement getCurrencyList() {
        return driver.findElement(By.id("currencyCombo-1069-inputEl"));
    }
    public List<WebElement> getBankList() {
        return driver.findElements(By.cssSelector("li.ba-banklist--item"));
    }

    public WebElement getIveGotAFormButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-automationid='connectbank-buttonIHaveAForm']")));
    }

    public WebElement getDoItLaterButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-automationid='uploadForm-uploadLaterButton']")));
    }

    public WebElement getGoToDashboardButton() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a[data-automationid='uploadFormLater-goToDashboardButton']")));
    }

    public void setBankAccountName(String accountName) {
        getBankAccountNameInput().sendKeys(accountName);
    }

    public void setBankAccountType(String accountType) {
        getBankAccountTypeInput().click();
        driver.findElement(By.xpath("//ul[@id='boundlist-1076-listEl']/li[contains(.,'" + accountType + "')]")).click();
    }

    public void setBankAccountNumber(String accountNumber) {
//        int bankNumber = 100000000 + new Random().nextInt(900000);
        getBankAccountNumberInput().sendKeys(String.valueOf(accountNumber));
        getCurrencyList().click();
    }

    public void clickContinueButton() {
        getContinueButton().click();
    }

    public void clickIHaveAFormButton() {
        getIveGotAFormButton().click();
    }

    public void clickDoItLaterButton() {
        getDoItLaterButton().click();
    }

    public void clickGoToDashboardButton() {
        getGoToDashboardButton().click();
    }

    public void selectBankFromPopularList(String bank) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("xui-searchfield-1018-inputEl")));
        List<WebElement> bankList = getBankList();
        bankList.stream()
                .filter(webElement -> webElement.getText().trim().equals(bank))
                .findAny().get().click();
    }
}
