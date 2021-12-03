package com.alseed.todolist.workers;

import com.alseed.todolist.TaskRepository;
import com.alseed.todolist.commands.BasicCommand;

import java.lang.reflect.Constructor;

public class CommandFactory {

    private String fullCommandName;

    public CommandFactory(String fullCommandName){
        this.fullCommandName = fullCommandName;
    }

    public BasicCommand createCommand(TaskRepository taskRepository, LogWriter logWriter) {
        try {
            Class<BasicCommand> createdClass = (Class<BasicCommand>) Class.forName(fullCommandName);
            Constructor<?> constructor = createdClass.getConstructor(TaskRepository.class, LogWriter.class);
            return (BasicCommand) constructor.newInstance(taskRepository, logWriter);
        }
        catch (Exception e) {
            return null;
        }
    }

}
