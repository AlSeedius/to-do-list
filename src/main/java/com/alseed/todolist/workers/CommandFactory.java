package com.alseed.todolist.workers;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.services.ConsoleWriterService;
import com.alseed.todolist.services.LogWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;

@Component
public class CommandFactory {

    @Autowired
    LogWriterService logWriterService;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    ConsoleWriterService consoleWriterService;

    @Autowired
    ArgumentWorker argumentWorker;

    public CommandFactory(){}

    public BasicCommand createCommand(String fullCommandName) {
        try {
            Class<BasicCommand> createdClass = (Class<BasicCommand>) Class.forName(fullCommandName);
            Constructor<?> constructor = createdClass.getConstructor(TaskRepository.class, LogWriterService.class, ConsoleWriterService.class, ArgumentWorker.class);
            return (BasicCommand) constructor.newInstance(taskRepository, logWriterService, consoleWriterService, argumentWorker);
        }
        catch (Exception e) {
            return null;
        }
    }

}
