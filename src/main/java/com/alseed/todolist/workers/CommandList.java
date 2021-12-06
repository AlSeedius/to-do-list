package com.alseed.todolist.workers;

import com.alseed.todolist.commands.BasicCommand;
import org.reflections.Reflections;

import java.util.*;

public class CommandList {
    private List<String> existingCommands;

    public CommandList(){
        existingCommands = new ArrayList<String> (
            Arrays.asList("print", "add", "delete", "edit", "quit", "search", "toggle"));
    }

    public List<String> getExistingCommands(){
        return this.existingCommands;
    }
}
