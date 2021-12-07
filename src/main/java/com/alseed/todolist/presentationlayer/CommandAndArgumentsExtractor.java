package com.alseed.todolist.presentationlayer;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ICommandAndArgumentsExtractor;

public class CommandAndArgumentsExtractor implements ICommandAndArgumentsExtractor {
    private String commandName;
    private Arguments args;

    public CommandAndArgumentsExtractor(String bufferedReaderLine) {
        String[] lines = bufferedReaderLine.split(" ");
        extractCommand(lines);
        if (lines.length > 1)
            extractArguments(lines);
        else
            this.args = null;
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public Arguments getArgs() {
        return args;
    }

    private void extractCommand(String[] lines){
        this.commandName = lines[0];
    }

    private void extractArguments(String[] lines){
        this.args = new Arguments(lines);
    }

}
