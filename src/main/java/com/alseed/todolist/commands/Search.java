package com.alseed.todolist.commands;

import com.alseed.todolist.TaskStreamToStringConverter;
import com.alseed.todolist.interfaces.ITaskRepository;

public class Search extends BasicCommand{

    public Search(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public String execute() {
        TaskStreamToStringConverter converter = new TaskStreamToStringConverter();
        return converter.taskOutputList((taskRepository.findTask(arguments.get(0))));
    }

}
