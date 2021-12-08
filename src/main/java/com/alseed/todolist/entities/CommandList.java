package com.alseed.todolist.entities;
import java.util.*;

public class CommandList {

    private List<String> existingCommands;

    private static CommandList instance;

    public static CommandList getInstance(){
        if (instance==null)
            instance = new CommandList();
        return instance;
    }

    private CommandList(){
        existingCommands = new ArrayList<> (
            Arrays.asList("print", "add", "delete", "edit", "quit", "search", "toggle"));
    }

    public List<String> getExistingCommands() {
        return existingCommands;
    }
}
