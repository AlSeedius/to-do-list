package com.alseed.todolist.commands;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import java.util.List;

public abstract class BasicCommand {

    protected List<String> arguments;
    protected String commandOutput;
    protected ITaskRepository taskRepository;

    public BasicCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public abstract void execute();

    public abstract boolean setArguments(Arguments arguments);

    public String getCommandOutput(){
        return commandOutput;
    }
}