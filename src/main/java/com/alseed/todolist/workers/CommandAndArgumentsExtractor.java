package com.alseed.todolist.workers;

import com.alseed.todolist.commands.Arguments;

public class CommandAndArgumentsExtractor {
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

    public String getCommandName() {
        return commandName;
    }

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
