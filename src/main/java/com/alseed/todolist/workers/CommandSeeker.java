package com.alseed.todolist.workers;

public class CommandSeeker {
    private String seekingName;
    private CommandList commandList;
    private String fullCommandName;

    public CommandSeeker(String commandName, CommandList cl){
        this.seekingName = commandName;
        this.commandList = cl;
    }

    public boolean commandExists(){
        return commandList.getExistingCommands()
                .stream()
                .filter(s -> s.toLowerCase().contains(seekingName.toLowerCase()))
                .map( s -> fullCommandName = s)
                .count()>0;
    }

    public String getFullCommandName() {
        return fullCommandName;
    }
}
