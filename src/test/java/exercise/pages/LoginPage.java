package exercise.pages;


import exercise.CucumberTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;

public class LoginPage {
    private WebDriver driver;
    private ResourceBundle rb;
    private WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 30);


    public LoginPage() {
        driver = CucumberTest.driver;
        rb = ResourceBundle.getBundle("application");
    }

    public void navigateTo() {
        driver.get(rb.getString("site.url"));
    }

    public WebElement getEmailAddressInput() {
        return wait.until(ExpectedConditions.presenceOfElementLocated(By.id("email")));
    }

    public WebElement getPasswordInput() {
        return driver.findElement(By.id("password"));
    }

    public WebElement getLoginInButton() {
        return driver.findElement(By.id("submitButton"));
    }

    public void setEmailAddressInput() {
        getEmailAddressInput().sendKeys(rb.getString("site.username"));
    }

    public void setPasswordInput() {
        getPasswordInput().sendKeys(rb.getString("site.password"));
    }

    public void clickLoginButton() {
        getLoginInButton().click();
    }
}
