package com.alseed.todolist.interfaces;

import com.alseed.todolist.entities.CommandExecutorMessage;

public interface IMainLogicImplementor {

    CommandExecutorMessage executeCommand(IParser parser);

}
