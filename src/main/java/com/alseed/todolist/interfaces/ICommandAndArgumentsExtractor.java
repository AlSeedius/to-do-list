package com.alseed.todolist.interfaces;

import java.util.Optional;

public interface ICommandAndArgumentsExtractor {

    String getCommandName();

    Optional<String[] > getArguments();

    void extractCommandAndArguments(String bufferedReaderLine);

}
