package com.alseed.todolist.interfaces;

import com.alseed.todolist.entities.CommandInfo;

import java.util.List;

public interface ICommandList {
    List<CommandInfo> getExistingCommands();
}
