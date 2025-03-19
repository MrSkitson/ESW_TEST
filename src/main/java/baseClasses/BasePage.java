package baseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    // Constructor
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Wait for an element to be **visible**
    public void waitForElementToBeVisible(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Wait for an element to be **clickable** before interacting
    public void waitForElementToBeClickable(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Click an element safely
    public void clickElement(By locator) {
        waitForElementToBeClickable(locator);
        driver.findElement(locator).click();
    }

    // Type text into a field safely
    public void typeText(By locator, String text) {
        waitForElementToBeVisible(locator);
        WebElement element = driver.findElement(locator);
        element.clear();  // Ensure the field is empty before typing
        element.sendKeys(text);
    }

    // Wait for an element to disappear (useful for loading overlays)
    public void waitForElementToDisappear(By locator) {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
    }

    // Wait for text to be present in an element
    public void waitForTextToBePresent(By locator, String text) {
        wait.until(ExpectedConditions.textToBe(locator, text));
    }
}
