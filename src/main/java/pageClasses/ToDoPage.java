package pageClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import baseClasses.BasePage;

import java.util.List;

public class ToDoPage extends BasePage {

    // Constructor
    public ToDoPage(WebDriver driver) {
        super(driver);
    }

    // Locators
    private By taskInput = By.cssSelector("input.new-todo");
    private By taskList = By.xpath("//ul[@class='todo-list']/li");
    private By deleteButton = By.xpath("//button[@class='destroy']");
    private By filterAll = By.xpath("//a[text()='All']");
    private By filterActive = By.xpath("//a[text()='Active']");
    private By filterCompleted = By.xpath("//a[text()='Completed']");


    // Add a new task
    public void addTask(String task) {
        typeText(taskInput, task + "\n");  // Reusing method from BasePage
    }

    // Get list of tasks
    public List<WebElement> getTasks() {
        return driver.findElements(taskList);
    }

    // Delete the first task
    public void deleteFirstTask() {
        WebElement firstTask = getTasks().get(0);
        firstTask.findElement(deleteButton).click();
    }

    // Mark the first task as completed
    public void completeFirstTask() {
        WebElement firstTask = getTasks().get(0);
        firstTask.findElement(By.cssSelector("input.toggle")).click();
    }

    // Apply "All" filter
    public void filterAllTasks() {
        clickElement(filterAll);
    }

    // Apply "Active" filter
    public void filterActiveTasks() {
        clickElement(filterActive);
    }

    // Apply "Completed" filter
    public void filterCompletedTasks() {
        clickElement(filterCompleted);
    }
    
   
}
