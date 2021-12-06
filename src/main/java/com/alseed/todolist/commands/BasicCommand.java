package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import com.alseed.todolist.workers.ArgumentWorker;

public abstract class BasicCommand {

    LogWriterService logWriter;
    TaskRepository taskRepository;
    ConsoleWriterService consoleWriterService;
    ArgumentWorker argumentWorker;

    public BasicCommand(TaskRepository taskRepository, LogWriterService logWriter, ConsoleWriterService consoleWriterService, ArgumentWorker argumentWorker) {
        this.logWriter = logWriter;
        this.taskRepository = taskRepository;
        this.consoleWriterService = consoleWriterService;
        this.argumentWorker = argumentWorker;
    }

    public abstract void execute();

    public abstract boolean setArguments(Arguments arguments);
}
