package com.alseed.todolist.entities;

import com.alseed.todolist.interfaces.ICommandList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandList implements ICommandList {

    private List<CommandInfo> existingCommands;

    public CommandList() {
        existingCommands = new ArrayList<>(
                Arrays.asList(
                        new CommandInfo("print", 1, false),
                        new CommandInfo("add", 1, false),
                        new CommandInfo("delete", 1, true),
                        new CommandInfo("edit", 2, true),
                        new CommandInfo("quit", 0, false),
                        new CommandInfo("search", 1, false),
                        new CommandInfo("toggle", 1, true)
                ));
    }

    @Override
    public List<CommandInfo> getExistingCommands() {
        return existingCommands;
    }
}
