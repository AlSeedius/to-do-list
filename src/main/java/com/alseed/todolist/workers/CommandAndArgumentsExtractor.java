package com.alseed.todolist.workers;

import com.alseed.todolist.commands.Arguments;
import com.alseed.todolist.services.LogWriterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class CommandAndArgumentsExtractor {
    private String commandName;
    private Arguments args;

    @Autowired
    LogWriterService logWriterService;

    public CommandAndArgumentsExtractor() {}

    public void extractCommandsAndArguments(String bufferedReaderLine){
        logWriterService.logInput(bufferedReaderLine);
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
