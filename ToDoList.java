import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import edu.ucalgary.oop.Task;

public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Tasks>> history;

    public ToDoList() {
        this.tasks = new ArrayList<>();
        this.history = new Stack<>();
    }

    @Override
    public void addTask(Task task) {
        tasks.add(task);
        history.push(tasks);

    }

    @Override
    public void completeTask(String taskId) {
        // Find task by taskId and mark it as completed
        // Push the current state of tasks list onto history stack
    }

    @Override
    public void deleteTask(String taskId) {
        // Remove task from tasks list
        // Push the current state of tasks list onto history stack
    }

    @Override
    public void editTask(String taskId, String newTitle) {
        // Find task by taskId and update its title
        // Push the current state of tasks list onto history stack
    }

    @Override
    public void undoLastAction() {
        
        // Pop the last state of tasks list from history stack and restore it
    }

    @Override
    public List<Task> listTasks() {
        // Return the current state of tasks list
        return tasks;
    }
}