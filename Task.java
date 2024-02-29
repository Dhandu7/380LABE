package edu.ucalgary.oop;

import java.util.Objects;

public class Task {

    private String id;
    private String title;
    private boolean isCompleted;



    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id) &&
               Objects.equals(title, task.title) &&
               isCompleted == task.isCompleted; 
    }



    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }

    public copy(Task task){
        Task newTask = (Task) task.clone();
        return newTask;
    }
}