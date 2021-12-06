package com.alseed.todolist.workers;

public class CommandSeeker {
    private String seekingName;

    public CommandSeeker(String commandName){
        this.seekingName = commandName;
    }

    public boolean commandExists(){
        CommandList commandList = new CommandList();
        return commandList.getExistingCommands()
                .stream()
                .anyMatch(s -> s.toLowerCase().contains(seekingName.toLowerCase()));
    }
}
