package com.alseed.todolist.commands;

import com.alseed.todolist.businesslayer.ArgumentErrorHandler;
import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import java.util.List;

public abstract class BasicCommand {

    protected String name;
    protected List<String> arguments;
    protected ITaskRepository taskRepository;
    protected ArgumentErrorHandler argumentErrorHandler;
    boolean isIdFirstArgument;
    int numOfArguments;

    public BasicCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

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