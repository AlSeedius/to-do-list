package com.alseed.todolist.interfaces;

import com.alseed.todolist.entities.Arguments;

public interface IParser {

    void parseCommandAndArguments(String input);

    String getParsedCommandName();

    Arguments getParsedCommandArguments();
}
