public class ToDoList implements IToDoList {
    private List<Task> tasks;
    private Stack<List<Tasks>> history;

    public ToDoList(){
        this.tasks = new ArrayList<>();
        this.history = new Stack<>();
    }

    @Override
    public void addTask(Task,task){
        
    }
}
