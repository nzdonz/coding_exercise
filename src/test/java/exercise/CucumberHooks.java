package exercise;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ResourceBundle;


public class CucumberHooks {
    public static ResourceBundle rb;
    public WebDriver driver;
    public WebDriverWait wait = new WebDriverWait(CucumberTest.driver, 30);

    @Before
    /*
      Delete all cookies at the start of each scenario to avoid
      shared state between tests
     */
    public void deleteCookies() {
        CucumberTest.driver.manage().deleteAllCookies();
    }

    @After
    /*
      Embed a screenshot in test report if test is marked as failed
     */
    public void embedScreenshot(Scenario scenario) {
        JavascriptExecutor js = (JavascriptExecutor) CucumberTest.driver;
        js.executeScript("window.localStorage.clear();");

        if (scenario.isFailed()) {
            try {
                scenario.write("Current Page URL is " + CucumberTest.driver.getCurrentUrl());
                byte[] screenshot = ((TakesScreenshot) CucumberTest.driver).getScreenshotAs(OutputType.BYTES);
                scenario.embed(screenshot, "image/png");
            } catch (WebDriverException somePlatformsDontSupportScreenshots) {
                System.err.println(somePlatformsDontSupportScreenshots.getMessage());
            }

        }
        CucumberTest.driver.manage().deleteAllCookies();
    }

}
