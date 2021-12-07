package com.alseed.todolist.businesslayer;

import com.alseed.todolist.entities.Task;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TaskStreamToStringConverter {

    private static TaskStreamToStringConverter instance;

    public static TaskStreamToStringConverter getInstance(){
        if (instance==null)
            instance = new TaskStreamToStringConverter();
        return instance;
    }

    private static String printOutputCreator(Task task){
        StringBuilder sb = new StringBuilder();
        sb.append(task.getId());
        sb.append(". ");
        sb.append(getSymbol(task.isCompleted()));
        sb.append(task.getDescription());
        return sb.toString();
    }

    public String taskOutputList(Stream<Task> taskStream) {
        return taskStream.map(TaskStreamToStringConverter::printOutputCreator)
                .collect(Collectors.joining("\n"));
    }
    private static String getSymbol(boolean completed){
        if (completed)
            return "[x] ";
        else
            return "[] ";
    }
}
