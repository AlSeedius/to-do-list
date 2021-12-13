package com.alseed.todolist;

import com.alseed.todolist.interfaces.ICommandAndArgumentsExtractor;
import java.util.Arrays;
import java.util.Optional;

public class CommandAndArgumentsExtractor implements ICommandAndArgumentsExtractor {
    private String commandName;
    private Optional<String[]> arguments;

    @Override
    public void extractCommandAndArguments(String bufferedReaderLine){
        String[] lines = bufferedReaderLine.split(" ");
        extractCommand(lines);
        if (lines.length > 1)
            extractArguments(lines);
        else
            this.arguments = Optional.empty();
    }

    @Override
    public String getCommandName() {
        return commandName;
    }

    @Override
    public Optional<String[]> getArguments() {
        return arguments;
    }

    private void extractCommand(String[] lines){
        this.commandName = lines[0];
    }

    private void extractArguments(String[] lines){
        arguments = Optional.of(Arrays.copyOfRange(lines, 1, lines.length));
    }

}
