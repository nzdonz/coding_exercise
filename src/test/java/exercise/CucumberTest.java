package exercise;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ResourceBundle;

@RunWith(Cucumber.class)
@CucumberOptions(plugin = {"pretty", "html:target/cucumber", "json:target/cucumber.json", "junit:target/junit/cucumber.xml"})
public class CucumberTest {

    public static WebDriver driver;
    public static ResourceBundle rb;


    @BeforeClass
    public static void setUp() {
        CucumberHooks.rb = ResourceBundle.getBundle("application");
        ChromeOptions options = new ChromeOptions();
//        options.addArguments("window-size=1920,1080", "start-maximized", "headless");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void cleanUp() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }
}
