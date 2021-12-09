package com.alseed.todolist;

import com.alseed.todolist.entities.Task;
import com.alseed.todolist.interfaces.ITaskRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class TaskAsListRepository implements ITaskRepository {

    private static List<Task> taskList = new ArrayList<>();
    private static Integer currentId=0;

    @Override
    public List<Task> getTaskList() {
        return taskList;
    }

    @Override
    public boolean idExists(Integer taskId){
        return taskList
                .stream()
                .anyMatch(t -> t.getId().equals(taskId));
    }

    @Override
    public void editTask(Integer taskId, String newDescription){
        listFilteredById(taskId)
                .forEach(t -> t.setDescription(newDescription));
    }

    @Override
    public void deleteTask(Integer taskId){
        taskList.removeIf(t -> t.getId().equals(taskId));
    }

    @Override
    public void toggleTask (Integer taskId){
        listFilteredById(taskId)
                .forEach(t -> t.setCompleted(!t.isCompleted()));
    }

    @Override
    public void addTask(String taskDescription){
        currentId++;
        taskList.add(new Task(currentId, taskDescription));
    }

    private Stream<Task> listFilteredById (Integer taskId){
        return taskList.stream()
                .filter(t -> t.getId().equals(taskId));
    }

    @Override
    public Stream<Task> findTask(String seekedString){
        return taskList.stream()
                .filter(t -> t.getDescription()
                .contains(seekedString));
    }
}
