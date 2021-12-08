package com.alseed.todolist.commands;

import com.alseed.todolist.businesslayer.TaskStreamToStringConverter;
import com.alseed.todolist.entities.Task;
import com.alseed.todolist.interfaces.ITaskRepository;
import java.util.stream.Stream;

public class Print extends BasicCommand {

    public Print(ITaskRepository taskRepository) {
        super(taskRepository);
        isIdFirstArgument = false;
        numOfArguments = 1;
        name = "print";
    }

    public String execute() {
        Stream<Task> taskStream = taskRepository.getTaskList().stream();
        if (this.arguments == null)
            taskStream = taskStream.filter(t -> !t.isCompleted());
        return TaskStreamToStringConverter.getInstance().taskOutputList(taskStream);
    }
}
