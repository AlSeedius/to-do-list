package com.alseed.todolist.commands;

import com.alseed.todolist.businesslayer.ArgumentErrorHandler;
import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ITaskRepository;
import java.util.List;

public abstract class BasicCommand {

    protected List<String> arguments;
    protected ITaskRepository taskRepository;
    protected ArgumentErrorHandler argumentErrorHandler;

    public BasicCommand(ITaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public abstract String execute();

    public abstract void setArguments(Arguments arguments);
}