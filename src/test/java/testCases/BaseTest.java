package testCases;

import utilities.BrowserFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = BrowserFactory.getDriver("chrome");  // Change browser if needed
        driver.get("https://todomvc.com/examples/elm/");
    }

    @AfterMethod
    public void tearDown() {
        BrowserFactory.closeDriver();
    }
}