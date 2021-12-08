package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.ITaskRepository;

public class Delete extends BasicCommand {

    public Delete(ITaskRepository taskRepository) {
        super(taskRepository);
        isIdFirstArgument = true;
        numOfArguments = 1;
        name = "delete";
    }

    public String execute() {
        taskRepository.deleteTask(Integer.parseInt(arguments.get(0)));
        return "";
    }
}