package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.ITaskRepository;

public class Add extends BasicCommand {

    public Add(ITaskRepository taskRepository) {
        super(taskRepository);
        isIdFirstArgument = false;
        numOfArguments = 1;
        name = "add";
    }

    public String execute() {
        taskRepository.addTask(arguments.get(0));
        return "";
    }

}
