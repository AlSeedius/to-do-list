package com.alseed.todolist.workers;

import com.alseed.todolist.entities.Task;
import com.alseed.todolist.interfaces.TaskRepositoryInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TaskAsListRepository implements TaskRepositoryInterface {
    private List<Task> taskList;
    private static Integer currentId=0;

    public TaskAsListRepository() {
        this.taskList = new ArrayList<>();
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public boolean idExists(Integer taskId){
        return taskList
                .stream()
                .anyMatch(t -> t.getId().equals(taskId));
    }

    public void editTask(Integer taskId, String newDescription){
        listFilteredById(taskId)
                .forEach(t -> t.setDescription(newDescription));
    }

    public void deleteTask(Integer taskId){
        taskList.removeIf(t -> t.getId().equals(taskId));
    }

    public void toggleTask (Integer taskId){
        listFilteredById(taskId)
                .forEach(t -> t.setCompleted(!t.isCompleted()));
    }

    public void addTask(String taskDescription){
        currentId++;
        taskList.add(new Task(currentId, taskDescription));
    }

    private Stream<Task> listFilteredById (Integer taskId){
        return taskList.stream()
                .filter(t -> t.getId().equals(taskId));
    }

    public Stream<Task> findTask(String seekedString){
        return taskList.stream()
                .filter(t -> t.getDescription()
                .contains(seekedString));
    }
}
