package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.TaskRepositoryInterface;
import com.alseed.todolist.workers.IOWorker;

import java.util.List;

public abstract class BasicCommand {

    protected List<String> arguments;

    protected TaskRepositoryInterface taskRepositoryInterface;
    protected IOWorker ioWorker;

    public BasicCommand(TaskRepositoryInterface taskRepositoryInterface, IOWorker ioWorker) {
        this.taskRepositoryInterface = taskRepositoryInterface;
        this.ioWorker = ioWorker;
    }

    public abstract void execute();

    public abstract boolean setArguments(Arguments arguments);
}