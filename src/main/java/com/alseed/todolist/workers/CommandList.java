package com.alseed.todolist.workers;

import com.alseed.todolist.commands.BasicCommand;
import org.reflections.Reflections;

import java.util.*;

public class CommandList {
    private List<String> existingCommands;

    public CommandList(){
        existingCommands = new ArrayList<>();
        new Reflections("com.alseed.todolist.commands").getSubTypesOf(BasicCommand.class)
                .stream()
                .forEach(s -> existingCommands.add(s.getName()));
    }

    public List<String> getExistingCommands(){
        return this.existingCommands;
    }
}
