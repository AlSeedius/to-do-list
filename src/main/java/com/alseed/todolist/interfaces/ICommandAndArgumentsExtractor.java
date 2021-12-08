package com.alseed.todolist.interfaces;

import com.alseed.todolist.entities.Arguments;

public interface ICommandAndArgumentsExtractor {

    String getCommandName();

    Arguments getArgs();

}
