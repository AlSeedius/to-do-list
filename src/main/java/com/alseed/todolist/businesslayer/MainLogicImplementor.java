package com.alseed.todolist.businesslayer;

import com.alseed.todolist.commands.BasicCommand;
import com.alseed.todolist.entities.CommandExecutorMessage;
import com.alseed.todolist.interfaces.*;
import com.alseed.todolist.presentationlayer.Parser;
import com.alseed.todolist.datasourcelayer.TaskAsListRepository;

public class MainLogicImplementor implements IMainLogicImplementor {

    @Override
    public CommandExecutorMessage executeCommand(IParser parser) {
        ITaskRepository taskRepository = TaskAsListRepository.getInstance();
        ICommandFactory commandFactory = new CommandFactory();
        BasicCommand command = commandFactory.createCommand(parser.getParsedCommandName(), taskRepository);
        if (command.setArguments(parser.getParsedCommandArguments())) {
            command.execute();
            return commandToReturnBuilder(command.getCommandOutput(),true);
        }
        else
            return commandToReturnBuilder(command.getCommandOutput(), false);
    }

    private CommandExecutorMessage commandToReturnBuilder(String message, Boolean isSuccessful){
        return new CommandExecutorMessage(message, isSuccessful);
    }

}

