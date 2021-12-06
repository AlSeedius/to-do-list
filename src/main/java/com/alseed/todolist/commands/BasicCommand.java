package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.workers.ConsoleWriter;
import com.alseed.todolist.workers.IOWorker;
import com.alseed.todolist.workers.LogWriter;

import java.util.List;

public abstract class BasicCommand {

    protected List<String> arguments;

    protected TaskRepository taskRepository;
    protected IOWorker ioWorker;

    public BasicCommand(TaskRepository taskRepository, IOWorker ioWorker) {
        this.taskRepository = taskRepository;
        this.ioWorker = ioWorker;
    }

    public abstract void execute();

    public abstract boolean setArguments(Arguments arguments);
}