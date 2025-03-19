package testCases;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageClasses.ToDoPage;
public class ToDoTests extends BaseTest{
    private ToDoPage todoPage;
    
    @BeforeMethod
    public void setUpTest() {
        todoPage = new ToDoPage(driver);
    }
    /**
     * Test case to add new task
     */
    @Test
    public void testAddTask() {
        String taskText = "Test Automation Task";

        // Add a new task
        todoPage.addTask(taskText);

        // Verify task is added
        List<WebElement> tasks = todoPage.getTasks();
        Assert.assertFalse(tasks.isEmpty(), "No tasks found after adding one!");
        Assert.assertEquals(tasks.get(0).getText(), taskText, "Task text mismatch!");
    }

    /**
     * Test case to complete Task
     */
    @Test
    public void testCompleteTask() {
        todoPage.addTask("Task to Complete");

        // Mark first task as completed
        todoPage.completeFirstTask();

        // Verify the task is marked as completed
        List<WebElement> tasks = todoPage.getTasks();
        Assert.assertTrue(tasks.get(0).getAttribute("class").contains("completed"),
                "Task was not marked as completed!");
    }
    /**
     * Test case to test filter Active task
     */
    @Test
    public void testFilterActiveTasks() {
        todoPage.addTask("Active Task 1");
        todoPage.addTask("Active Task 2");

        todoPage.addTask("Completed Task");
        todoPage.completeFirstTask(); // Marking first task as completed

        todoPage.filterActiveTasks(); // Apply Active filter

        // Verify only active tasks are shown
        List<WebElement> tasks = todoPage.getTasks();
        Assert.assertEquals(tasks.size(), 2, "Incorrect number of active tasks displayed!");
    }
    /**
     * Test case to test filter Completed task
     */
    @Test
    public void testFilterCompletedTasks() {
        todoPage.addTask("Completed Task");
        todoPage.completeFirstTask(); // Mark as completed

        todoPage.filterCompletedTasks(); // Apply Completed filter

        // Verify only completed tasks are shown
        List<WebElement> tasks = todoPage.getTasks();
        Assert.assertEquals(tasks.size(), 1, "Incorrect number of completed tasks displayed!");
    }
    /**
     * Test case E2E add multiple tasks and set filter as active
     */
	@Test
	public void testE2E_AddMultipleTasksAndFilterActive() {

	    // Step 1: Add multiple tasks
	    todoPage.addTask("Task 1");
	    todoPage.addTask("Task 2");
	    todoPage.addTask("Task 3");
	    Assert.assertEquals(todoPage.getTasks().size(), 3, "Not all tasks were added!");

	    // Step 2: Complete Task 2
	    todoPage.completeFirstTask(); // Completing Task 1 (since toggle is first child)
	    
	    // Step 3: Apply 'Active' filter
	    todoPage.filterActiveTasks();
	    
	    // Step 4: Verify only 2 active tasks are displayed
	    Assert.assertEquals(todoPage.getTasks().size(), 2, "Incorrect number of active tasks displayed!");
	}
//    /**
//     * Test case to delete task
//     */
//    @Test
//    public void testDeleteTask() {
//        todoPage.addTask("Task to Delete");
//
//        int initialSize = todoPage.getTasks().size();
//
//        // Delete the first task
//        todoPage.deleteFirstTask();
//
//        int newSize = todoPage.getTasks().size();
//        Assert.assertTrue(newSize < initialSize, "Task was not deleted!");
//    }
	  
}
