package com.alseed.todolist.presentationlayer;

import com.alseed.todolist.entities.Arguments;
import com.alseed.todolist.interfaces.ICommandAndArgumentsExtractor;
import com.alseed.todolist.interfaces.IParser;

public class Parser implements IParser {

    private String parsedCommandName;
    private Arguments parsedCommandArguments;

    @Override
    public void ParseCommandAndArguments(String input){
        ICommandAndArgumentsExtractor extractor = new CommandAndArgumentsExtractor(input);
        this.parsedCommandArguments = extractor.getArgs();
        this.parsedCommandName = extractor.getCommandName();
    }

    @Override
    public String getParsedCommandName(){
        return this.parsedCommandName;
    }

    @Override
    public Arguments getParsedCommandArguments(){
        return this.parsedCommandArguments;
    }

}
