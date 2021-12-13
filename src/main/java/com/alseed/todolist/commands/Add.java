package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.ITaskRepository;

public class Add extends BasicCommand {

    public Add(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public String execute() {
        taskRepository.addTask(arguments.get(0));
        return "";
    }

}
