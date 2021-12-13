package com.alseed.todolist.interfaces;

import java.util.List;

public interface IParser {

    void parseCommandAndArguments(String input);

    String getParsedCommandName();

    List<String> getParsedCommandArguments();
}
