package com.alseed.todolist.commands;

import com.alseed.todolist.TaskStreamToStringConverter;
import com.alseed.todolist.interfaces.ITaskRepository;

public class Search extends BasicCommand{

    public Search(ITaskRepository taskRepository) {
        super(taskRepository);
        isIdFirstArgument = false;
        numOfArguments = 1;
        name = "search";
    }

    public String execute() {
        TaskStreamToStringConverter converter = new TaskStreamToStringConverter();
        return converter.taskOutputList((taskRepository.findTask(arguments.get(0))));
    }

}
