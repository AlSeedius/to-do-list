package com.alseed.todolist.interfaces;

import com.alseed.todolist.commands.BasicCommand;

public interface ICommandFactory {
    BasicCommand createCommand(String commandName, ITaskRepository taskRepositoryImpl);
}
