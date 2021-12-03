package com.alseed.todolist.commands;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.workers.LogWriter;

public abstract class BasicCommand {

    private TaskRepository taskRepository;
    private LogWriter logWriter;

    public BasicCommand(TaskRepository taskRepository, LogWriter logWriter) {
        this.taskRepository = taskRepository;
        this.logWriter = logWriter;
    }

    public LogWriter getLogWriter() {
        return logWriter;
    }

    public abstract void execute();

    public TaskRepository getTaskRepository() {
        return taskRepository;
    }

    public abstract boolean setArguments(Arguments arguments);
}
