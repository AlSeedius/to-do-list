package com.alseed.todolist.interfaces;
import com.alseed.todolist.entities.Task;
import java.util.List;
import java.util.stream.Stream;

public interface ITaskRepository {

    List<Task> getTaskList();

    boolean idExists(Integer taskId);

    void editTask(Integer taskId, String newDescription);

    void deleteTask(Integer taskId);

    void addTask(String taskDescription);

    Stream<Task> findTask(String seekedString);

    void toggleTask (Integer taskId);

}
