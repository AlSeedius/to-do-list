package com.alseed.todolist.entities;

import com.alseed.todolist.interfaces.ICommandList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandList implements ICommandList {

    private List<String> existingCommands;

    public CommandList(){
        existingCommands = new ArrayList<>(
            Arrays.asList("print", "add", "delete", "edit", "quit", "search", "toggle"));
    }

    @Override
    public List<String> getExistingCommands() {
        return existingCommands;
    }
}
