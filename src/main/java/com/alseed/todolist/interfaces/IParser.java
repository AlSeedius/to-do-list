package com.alseed.todolist.interfaces;

import com.alseed.todolist.entities.Arguments;

public interface IParser {

    void ParseCommandAndArguments(String input);

    String getParsedCommandName();

    Arguments getParsedCommandArguments();
}
