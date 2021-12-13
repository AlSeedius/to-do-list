package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.ITaskRepository;

import java.util.List;

public abstract class BasicCommand {

    protected List<String> arguments;
    protected ITaskRepository taskRepository;

    public BasicCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public BasicCommand(){}

    public abstract String execute();

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}