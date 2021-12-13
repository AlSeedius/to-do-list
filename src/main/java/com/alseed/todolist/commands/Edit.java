package com.alseed.todolist.commands;

import com.alseed.todolist.interfaces.ITaskRepository;

public class Edit extends BasicCommand {


    public Edit(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public String execute() {
        taskRepository.editTask(Integer.parseInt(arguments.get(0)), arguments.get(1));
        return "";
    }
}
