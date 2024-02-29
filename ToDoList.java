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
        history.push(new ArrayList<>(tasks));

    }

    @Override
    public void completeTask(String taskId) {
        for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setCompleted(true);
                break;
            }
        }
        // Save the current state of tasks list onto the history stack
        history.push(new ArrayList<>(tasks));

    }

    @Override
    public void deleteTask(String taskId) {
        tasks.removeIf(task -> task.getId().equals(taskId));
        // Save the current state of tasks list onto the history stack
        history.push(new ArrayList<>(tasks));
        // Remove task from tasks list
        // Push the current state of tasks list onto history stack
    }

    @Override
    public void editTask(String taskId, String newTitle) {
         for (Task task : tasks) {
            if (task.getId().equals(taskId)) {
                task.setTitle(newTitle);
                break;
            }
        }
        // Save the current state of tasks list onto the history stack
        history.push(new ArrayList<>(tasks));
        // Find task by taskId and update its title
        // Push the current state of tasks list onto history stack
    }

    @Override
    public void undoLastAction() {
        if (!history.isEmpty()){
            tasks = history.pop();
        }
        // Pop the last state of tasks list from history stack and restore it
    }

    @Override
    public List<Task> listTasks() {
        // Return the current state of tasks list
        return tasks;
    }


}
