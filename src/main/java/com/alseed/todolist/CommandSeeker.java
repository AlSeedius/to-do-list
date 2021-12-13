package com.alseed.todolist;

import com.alseed.todolist.entities.CommandInfo;
import com.alseed.todolist.interfaces.ICommandList;

import java.util.Optional;

public class CommandSeeker {

    private ICommandList commandList;

    public CommandSeeker(ICommandList commandList){
        this.commandList = commandList;
    }

    public Optional<CommandInfo> returnCommandIfExists(String commandName){
        return commandList
                .getExistingCommands()
                .stream()
                .filter(c -> c.getName().equals(commandName.toLowerCase()))
                .findFirst();
    }

}
