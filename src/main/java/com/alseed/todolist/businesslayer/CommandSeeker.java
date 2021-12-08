package com.alseed.todolist.businesslayer;

import com.alseed.todolist.entities.CommandList;

public class CommandSeeker {

    private CommandSeeker(){}

    public static CommandSeeker instance;

    public static CommandSeeker getInstance(){
        if (instance==null)
            instance = new CommandSeeker();
        return instance;
    }

    boolean commandExists(String commandName){
        return CommandList
                .getInstance()
                .getExistingCommands()
                .stream()
                .anyMatch(s -> s.equals(commandName));
    }

}
