package com.alseed.todolist;

import com.alseed.todolist.entities.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Component
public class TaskRepository {

    @Autowired
    private static List<Task> taskList = new ArrayList<>();

    private static Integer currentId=0;

    public TaskRepository() {}

    public List<Task> getTaskList() {
        return taskList;
    }

    public Optional<Task> getTaskById(Integer taskId) {
        return listFilteredById(taskId)
                .findFirst();
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
