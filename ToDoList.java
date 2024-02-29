package edu.ucalgary.oop;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Task>> history;

    public ToDoList() {
        tasks = new ArrayList<>();
        history = new Stack<>();
    }

    @Override
    public void addTask(Task task) {
        // Before adding the task, save the current state
        saveState();
        tasks.add(task);
    }

    @Override
    public void completeTask(String taskId) {
        // Find the task by ID and mark it as completed
        // Then save the current state
        saveState();
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                break;
            }
        }
    }

    @Override
    public void deleteTask(String taskId) {
        // Find the task by ID and remove it
        // Then save the current state
        saveState();
        tasks.removeIf(task -> task.getId().equals(taskId));
    }

    @Override
    public void editTask(String taskId, String newTitle, boolean isCompleted) {
        // Find the task by ID and update its properties
        // Then save the current state
        saveState();
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setTitle(newTitle);
                task.setCompleted(isCompleted);
                break;
            }
        }
    }

    @Override
    public void undo() {
        // Check if there are any changes to undo
        if (!history.isEmpty()) {
            // Restore the previous state by popping the last saved state from the history stack
            tasks = history.pop();
        }
    }

    @Override
    public List<Task> listTasks() {
        // Return the current list of tasks
        return tasks;
    }

    // Method to save the current state of tasks
    private void saveState() {
        // Create a deep copy of the tasks and push it onto the history stack
        List<Task> currentState = new ArrayList<>(tasks.size());
        for (Task task : tasks) {
            currentState.add(new Task(task));
        }
        history.push(currentState);
    }
}
