package com.alseed.todolist;

import com.alseed.todolist.interfaces.ICommandList;

public class CommandSeeker {

    private ICommandList commandList;

    public CommandSeeker(ICommandList commandList){
        this.commandList = commandList;
    }

    public boolean commandExists(String commandName){
        return commandList
                .getExistingCommands()
                .stream()
                .anyMatch(s -> s.equals(commandName));
    }

}
