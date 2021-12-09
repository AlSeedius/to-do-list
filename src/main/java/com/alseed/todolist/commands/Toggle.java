package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.ITaskRepository;

public class Toggle extends BasicCommand {

    public Toggle(ITaskRepository taskRepository) {
        super(taskRepository);
        isIdFirstArgument = true;
        numOfArguments = 1;
        name = "toggle";
    }

    public String execute() {
        taskRepository.toggleTask(Integer.parseInt(arguments.get(0)));
        return "";
    }
}
