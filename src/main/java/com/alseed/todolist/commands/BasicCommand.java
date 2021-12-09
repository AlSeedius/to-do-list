package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.ITaskRepository;

import java.util.List;

public abstract class BasicCommand {

    protected String name;
    protected List<String> arguments;
    protected ITaskRepository taskRepository;
    boolean isIdFirstArgument;
    int numOfArguments;

    public BasicCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public BasicCommand(){}

    public abstract String execute();

    public boolean isIdFirstArgument(){
        return isIdFirstArgument;
    }

    public int getNumOfArguments(){
        return numOfArguments;
    }

    public String getName(){return name;}

    public void setArguments(List<String> arguments) {
        this.arguments = arguments;
    }
}