interface IToDoList {
    void addTask(Task task);

    void completeTask(String taskId);

    void deleteTask(String taskId);

    void editTask(String taskId, String newTitle);

    void undoLastAction();

    List<Task> listTasks();
}