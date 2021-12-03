package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.workers.LogWriter;

import java.util.List;

public class Quit extends BasicCommand {

    private static String name = "Print";
    private List<String> arguments;

    public Quit(TaskRepository taskRepository, LogWriter logWriter) {
        super(taskRepository, logWriter);
    }

    public void execute(){
        System.exit(1);
    }

    public boolean setArguments(Arguments arguments) {
        return true;
    }

}
