package com.alseed.todolist.commands;

import com.alseed.todolist.TaskStreamToStringConverter;
import com.alseed.todolist.entities.Task;
import com.alseed.todolist.interfaces.ITaskRepository;

import java.util.stream.Stream;

public class Print extends BasicCommand {

    public Print(ITaskRepository taskRepository) {
        super(taskRepository);
    }

    public String execute() {
        Stream<Task> taskStream = taskRepository.getTaskList().stream();
        if (this.arguments == null)
            taskStream = taskStream.filter(t -> !t.isCompleted());
        TaskStreamToStringConverter converter = new TaskStreamToStringConverter();
        return converter.taskOutputList(taskStream);
    }
}
