package com.alseed.todolist.workers;

import java.util.*;

public class CommandList {

    private List<String> existingCommands;

    public CommandList(){
        existingCommands = new ArrayList<> (
            Arrays.asList("print", "add", "delete", "edit", "quit", "search", "toggle"));
    }

    public boolean commandExists(String seekingName){
        return existingCommands
                .stream()
                .anyMatch(s -> s.toLowerCase().contains(seekingName.toLowerCase()));
    }
}
