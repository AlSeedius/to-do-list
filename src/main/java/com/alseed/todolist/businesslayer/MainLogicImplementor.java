package com.alseed.todolist.businesslayer;

import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.interfaces.*;
import com.alseed.todolist.datasourcelayer.TaskAsListRepository;

public class MainLogicImplementor implements IMainLogicImplementor {

    @Override
    public String executeCommand(IParser parser) {
        ITaskRepository taskRepository = TaskAsListRepository.getInstance();
        ICommandFactory commandFactory = new CommandFactory();
        BasicCommand command = commandFactory.createCommand(parser.getParsedCommandName(), taskRepository);
        command.setArguments(parser.getParsedCommandArguments());
        return command.execute();
    }
}

