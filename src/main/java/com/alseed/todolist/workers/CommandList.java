package com.alseed.todolist.workers;

import java.util.*;

public class CommandList {
    private List<String> existingCommands;

    public CommandList(){
        existingCommands = new ArrayList<String> (
            Arrays.asList("print", "add", "delete", "edit", "quit", "search", "toggle"));
    }

    private List<String> getExistingCommands(){
        return this.existingCommands;
    }

    public boolean commandExists(String seekingName){
        return getExistingCommands()
                .stream()
                .anyMatch(s -> s.toLowerCase().contains(seekingName.toLowerCase()));
    }
}
