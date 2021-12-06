package com.alseed.todolist.workers;

public class CommandSeeker {

    public boolean commandExists(String seekingName){
        CommandList commandList = new CommandList();
        return commandList.getExistingCommands()
                .stream()
                .anyMatch(s -> s.toLowerCase().contains(seekingName.toLowerCase()));
    }
}
