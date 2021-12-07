package com.alseed.todolist.workers;

import com.alseed.todolist.commands.Arguments;

public class Parser {

    private String parsedCommandName;
    private Arguments parsedCommandArguments;

    public void ParseCommandAndArguments(String input){
        CommandAndArgumentsExtractor extractor = new CommandAndArgumentsExtractor(input);
        this.parsedCommandArguments = extractor.getArgs();
        this.parsedCommandName = extractor.getCommandName();
    }

    public String getParsedCommandName(){
        return this.parsedCommandName;
    }

    public Arguments getParsedCommandArguments(){
        return this.parsedCommandArguments;
    }

}
